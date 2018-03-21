/**
 * 
 */
package br.com.a4kontrol.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.a4kontrol.authentication.util.SessionUtil;
import br.com.a4kontrol.model.Feriado;
import br.com.a4kontrol.model.Usuario;
import br.com.a4kontrol.repository.FeriadoRepository;
import br.com.a4kontrol.to.ResultBaseFactoryTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author geovan.goes
 *
 */
@Service
public class FeriadoService
{
	/***
	 * 
	 */
	@Autowired
	private FeriadoRepository repository;
	
	/***
	 * 
	 */
	@Autowired
	private UsuarioService usuarioService;
	
	/***
	 * 
	 */
	@Autowired
	private LancamentoService lancamentoService;
	
	/***
	 * 
	 * @param userName
	 * @param data
	 * @return
	 */
	public ResultBaseFactoryTO inserir(Date data)
	{
		ResultBaseFactoryTO resultBaseFactoryTO = new ResultBaseFactoryTO();
		
		Usuario usuario = usuarioService.getUsuario(SessionUtil.getUserNameAutheticatedUser());
		
		if (usuario != null)
		{
			boolean feriadoJaExiste = validarExistenciaDoFeriadoParaUsuario(usuario, data);
			if (!feriadoJaExiste)
			{
				
				//removerLancamentosDeUmDia(usuario, data);
				
				Feriado feriado = new Feriado(data, usuario);
				repository.save(feriado);
				
				Map<String, Object> result = new HashMap<String, Object>();
				resultBaseFactoryTO.setSuccess(result);
			}
			else
			{
				resultBaseFactoryTO.addErrorMessage("falha-insercao-feriado", "Não foi possível inserir esse feriado :/");
			}
		}
		else
		{
			resultBaseFactoryTO.addErrorMessage("falha-insercao-feriado", "Não foi possível inserir esse feriado :/");
		}
		return resultBaseFactoryTO;
	}
	
	

	/**
	 * @param usuario
	 * @param data
	 */
	private boolean validarExistenciaDoFeriadoParaUsuario(Usuario usuario, Date data)
	{
		Feriado feriado = repository.getFeriadoByDataAndUsuario(data, usuario);
		if (feriado == null)
			return false;
		else 
			return true;
	}

	/***
	 * 
	 * @param userName
	 * @return
	 */
	public ResultBaseFactoryTO getAll()
	{
		ResultBaseFactoryTO resultBaseFactoryTO = new ResultBaseFactoryTO();
		Usuario usuario = usuarioService.getUsuario(SessionUtil.getUserNameAutheticatedUser());
		
		if (usuario != null)
		{
			List<Feriado> feriadosByUsuario = repository.getFeriadosByUsuario(usuario);
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("result", feriadosByUsuario);
			resultBaseFactoryTO.setSuccess(result);
		}
		else
		{
			resultBaseFactoryTO.addErrorMessage("falha-busca-feriados", "Não foi possível listar os feriados desse usuário.");
		}
		return resultBaseFactoryTO;
	}

	/**
	 * @param date
	 * @return
	 */
	public ResultBaseFactoryTO removerFeriado(Date date)
	{
		ResultBaseFactoryTO resultBaseFactoryTO = new ResultBaseFactoryTO();
		
		Usuario usuario = usuarioService.getUsuario(SessionUtil.getUserNameAutheticatedUser());
		
		Feriado feriadoByDataAndUsuario = repository.getFeriadoByDataAndUsuario(date, usuario);
		
		if (feriadoByDataAndUsuario != null)
		{			
			repository.delete(feriadoByDataAndUsuario);
			resultBaseFactoryTO.setSuccess(new HashMap<String, Object>());
		}
		else
		{
			resultBaseFactoryTO.addErrorMessage("falha-remover-feriado", "Não foi possível remover o feriado.");
		}
		
		return resultBaseFactoryTO;
	}
}
