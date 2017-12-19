/**
 * 
 */
package br.com.a4kontrol.service;

import java.util.HashMap;
import java.util.Map;

import br.com.a4kontrol.model.Usuario;
import br.com.a4kontrol.repository.UsuarioRepository;
import br.com.a4kontrol.to.ResultBaseFactoryTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author geovan.goes
 *
 */
@Service
public class UsuarioService 
{
	
	@Autowired
	private UsuarioRepository repository;
	
	
	public ResultBaseFactoryTO list()
	{
		ResultBaseFactoryTO result = new ResultBaseFactoryTO();
		
		Iterable<Usuario> findAll = repository.findAll();
		if (findAll != null)
		{
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("users", findAll);
			result.setSuccess(map);
		}
		
		return result;
	}
	
	/***
	 * 
	 * @param id
	 * @return
	 */
	public Usuario getUsuario(Long id)
	{
		return repository.findOne(id);
	}
	
	/***
	 * 
	 * @param userName
	 * @return
	 */
	public ResultBaseFactoryTO inserir(String userName)
	{		
		ResultBaseFactoryTO result = new ResultBaseFactoryTO();
		
		if (userName != null && !userName.isEmpty())
		{
			Usuario exists = repository.getByUserName(userName);
			
			if (exists == null)
			{
				Usuario usuario = new Usuario();
				usuario.setUserName(userName);
				repository.save(usuario);
				result.setSuccess(new HashMap<String, Object>());
			}
			else
			{
				result.addErrorMessage("duplicated-userName", "Nome de usuário já usado.");
			}
		}
		else
		{
			result.addErrorMessage("userName-invalid", "Nome de usuário inválido.");
		}
		
		return result;
	}
	
	/***
	 * 
	 * @param usuario
	 * @return
	 */
	public Usuario update(Usuario usuario)
	{
		return repository.save(usuario);
	}
}
