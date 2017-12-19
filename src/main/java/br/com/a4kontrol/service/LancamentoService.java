/**
 * 
 */
package br.com.a4kontrol.service;

import br.com.a4kontrol.model.Feriado;
import br.com.a4kontrol.model.Usuario;
import br.com.a4kontrol.repository.UsuarioRepository;
import br.com.a4kontrol.to.ResultBaseFactoryTO;

import java.util.Date;
import java.util.HashMap;
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
	
	public ResultBaseFactoryTO obterPorUsuario(String userName)
	{
		ResultBaseFactoryTO result = new ResultBaseFactoryTO();
		
		if (userName != null && !userName.trim().isEmpty())
		{
			Usuario user = usuarioRepository.getByUserName(userName);
			
			if (user != null)
			{
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("lancamentos", user.getLancamentos());
				result.setSuccess(map);
			}
			else
			{
				result.addErrorMessage("user-not-found", "Usuário não encontrado.");
			}
		}
		else
		{
			result.addErrorMessage("username-invalid", "Nome de usuário inválido.");
		}
		return result;
	}
	
	public ResultBaseFactoryTO inserir(String userName, Date data)
	{
		ResultBaseFactoryTO result = new ResultBaseFactoryTO();
		
		if (data != null)
		{
			Usuario user = usuarioRepository.getByUserName(userName);
			
			if (user != null)
			{
				user.getFeriados().add(new Feriado(data));
				usuarioRepository.save(user);
				
				result.setSuccess(new HashMap<String, Object>());
			}
			else
			{
				result.addErrorMessage("user-not-found", "Usuário não encontrado.");
			}
		}
		else
		{
			result.addErrorMessage("date-null", "Data inválida.");
		}
		
		return result;
	}

}
