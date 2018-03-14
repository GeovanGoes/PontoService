/**
 * 
 */
package br.com.a4kontrol.service;

import br.com.a4kontrol.authentication.util.SessionUtil;
import br.com.a4kontrol.model.Lancamento;
import br.com.a4kontrol.model.Usuario;
import br.com.a4kontrol.repository.LancamentoRepository;
import br.com.a4kontrol.repository.UsuarioRepository;
import br.com.a4kontrol.to.ResultBaseFactoryTO;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author geovan.goes
 *
 */
@Service
public class LancamentoService 
{
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	LancamentoRepository repository;
	
	/***
	 * 
	 * @param userName
	 * @return
	 */
	public ResultBaseFactoryTO obterPorUsuario()
	{
		ResultBaseFactoryTO result = new ResultBaseFactoryTO();
		
		Usuario usuario = usuarioRepository.getByUserName(SessionUtil.getUserNameAutheticatedUser());
		
		if (usuario != null)
		{				
			List<Lancamento> lancamentoByUsuario = repository.getLancamentoByUsuario(usuario);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("result", lancamentoByUsuario);
			result.setSuccess(map);
		}
		else
		{
			result.addErrorMessage("user-not-found", "Usuário não encontrado.");
		}
		
		return result;
	}
	
	/***
	 * 
	 * @param userName
	 * @param data
	 * @return
	 */
	public ResultBaseFactoryTO inserir(Date data)
	{
		ResultBaseFactoryTO result = new ResultBaseFactoryTO();
		
		if (data != null)
		{
			Usuario usuario = usuarioRepository.getByUserName(SessionUtil.getUserNameAutheticatedUser());
			
			if (usuario != null)
			{
				boolean lancamentoExistente = existeLancamentoNesseDiaHorario(data, usuario);
				
				if (!lancamentoExistente)
				{
					repository.save(new Lancamento(data, usuario));
					result.setSuccess(new HashMap<String, Object>());
				}
				else
				{
					erroGenericoInsercaoLancamento(result);
				}
			}
			else
			{
				erroGenericoInsercaoLancamento(result);
			}
		}
		else
		{
			result.addErrorMessage("falha-insercao-lancamento-date-null", "Data inválida.");
		}
		
		return result;
	}

	/**
	 * @param result
	 */
	private void erroGenericoInsercaoLancamento(ResultBaseFactoryTO result)
	{
		result.addErrorMessage("falha-insercao-lancamento", "Não foi possível inserir esse lancamento.");
	}

	/**
	 * @param data
	 * @param usuario
	 */
	private boolean existeLancamentoNesseDiaHorario(Date data, Usuario usuario)
	{
		if (repository.getLancamentoByUsuarioAndDataLancamento(usuario, data) != null)
			return true;
		else
			return false;
	}

}
