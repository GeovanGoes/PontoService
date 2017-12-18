/**
 * 
 */
package br.com.a4kontrol.service;

import br.com.a4kontrol.model.Usuario;
import br.com.a4kontrol.repository.UsuarioRepository;

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
	
	public Usuario getUsuario(Long id)
	{
		return repository.findOne(id);
	}
	
	/***
	 * 
	 * @param userName
	 * @return
	 */
	public boolean inserir(String userName)
	{		
		Usuario exists = repository.getByUserName(userName);
		
		if (exists == null)
		{
			Usuario usuario = new Usuario();
			usuario.setUserName(userName);
			repository.save(usuario);
			return true;
		}
		return false;
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
