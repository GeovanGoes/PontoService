/**
 * 
 */
package br.com.a4kontrol.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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
			Map<String, Object> map = new HashMap<String, Object>();
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
	public Optional<Usuario> getUsuario(long id)
	{
		return repository.findById(id);
	}
	
	/***
	 * 
	 * @param userName
	 * @return
	 */
	public Usuario getUsuario(String userName)
	{
		return repository.getByUserName(userName);
	}
	
	public boolean usuarioExists (String userName)
	{
		Usuario usuario = getUsuario(userName);
		if (usuario != null)
		{
			return true;
		}
		else
		{
			return false;
		}
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
				result.addErrorMessage("duplicated-userName", "Nome de usu�rio j� usado.");
			}
		}
		else
		{
			result.addErrorMessage("userName-invalid", "Nome de usu�rio inv�lido.");
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

	/**
	 * @param usuario
	 */
	public void deletar(Usuario usuario)
	{
		repository.delete(usuario);
	}
}
