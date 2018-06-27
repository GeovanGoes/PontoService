/**
 * essa é uma alteracao para ver o comportamento do git
 */
package br.com.a4kontrol;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Iterator;

import br.com.a4kontrol.controller.UsuarioController;
import br.com.a4kontrol.model.Usuario;
import br.com.a4kontrol.service.UsuarioService;
import br.com.a4kontrol.to.ResultBaseFactoryTO;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author geovan.goes
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UsuarioTest
{
	
	/**
	 * 
	 */
	private static final String NOME_USUARIO = "Manézinzézin";

	@Autowired
	UsuarioController controller;

	@Autowired
	UsuarioService service;
	
	@Test
	public void deveInserirUmNovoUsuario()
	{
		ResultBaseFactoryTO result = controller.inserirUsuario(NOME_USUARIO);
		assertNotNull(result);
		assertEquals(true, result.isSuccess());
	}
	
	@Test
	public void naoDevePermitirInsercaoDeDoisUsuarioComMesmoNome()
	{
		ResultBaseFactoryTO result = controller.inserirUsuario(NOME_USUARIO);
		assertNotNull(result);
		assertEquals(true, result.isSuccess());
		
		result = controller.inserirUsuario(NOME_USUARIO);
		assertNotNull(result);
		assertEquals(false, result.isSuccess());
	}
	
	@Test
	public void deveBuscarUmUsuarioPeloNome()
	{
		ResultBaseFactoryTO result = controller.inserirUsuario(NOME_USUARIO);
		assertNotNull(result);
		assertEquals(true, result.isSuccess());
		
		Usuario usuario = service.getUsuario(NOME_USUARIO);
		assertEquals(NOME_USUARIO, usuario.getUserName());		
	}
	
	@Test
	public void deveAtualizarUmUsuario()
	{
		ResultBaseFactoryTO result = controller.inserirUsuario(NOME_USUARIO);
		assertNotNull(result);
		assertEquals(true, result.isSuccess());
		
		Usuario usuario = service.getUsuario(NOME_USUARIO);
		assertNotNull(usuario);
		
		usuario.setUserName("Jupira");
		usuario = service.update(usuario);
		
		assertNotNull(usuario);
		assertEquals("Jupira", usuario.getUserName());
	}
	
	@Test
	public void deveDeletarUmUsuario()
	{
		ResultBaseFactoryTO result = controller.inserirUsuario(NOME_USUARIO);
		assertNotNull(result);
		assertEquals(true, result.isSuccess());
		
		Usuario usuario = service.getUsuario(NOME_USUARIO);
		assertEquals(NOME_USUARIO, usuario.getUserName());
		
		service.deletar(usuario);
		
		usuario = service.getUsuario(NOME_USUARIO);
		assertNull(usuario);
	}
	
	@Test
	public void devListarOsUsuarios()
	{
		ResultBaseFactoryTO result = controller.inserirUsuario(NOME_USUARIO);
		assertNotNull(result);
		assertEquals(true, result.isSuccess());
		
		ResultBaseFactoryTO listar = controller.listar();
		assertNotNull(listar);
		assertEquals(true, listar.isSuccess());
		
		Object objectFromService = listar.getResult().get("users");
		assertNotNull(objectFromService);
		
		@SuppressWarnings("unchecked")
		Iterable<Usuario> iterable = (Iterable<Usuario>) objectFromService; 
		
		Iterator<Usuario> iterator = iterable.iterator();
		boolean achei = false;
		while (iterator.hasNext())
		{
			if (iterator.next().getUserName().equals(NOME_USUARIO))
				achei = true;
		}
		
		assertEquals(true, achei);
	}
}
