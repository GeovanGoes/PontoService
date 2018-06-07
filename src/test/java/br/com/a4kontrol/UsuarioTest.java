/**
 * 
 */
package br.com.a4kontrol;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
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
	public void inserir()
	{
		ResultBaseFactoryTO result = controller.inserirUsuario(NOME_USUARIO);
		assertNotNull(result);
		assertEquals(true, result.isSuccess());
	}
	
	@Test
	public void buscar()
	{
		ResultBaseFactoryTO result = controller.inserirUsuario(NOME_USUARIO);
		assertNotNull(result);
		assertEquals(true, result.isSuccess());
		
		Usuario usuario = service.getUsuario(NOME_USUARIO);
		assertEquals(NOME_USUARIO, usuario.getUserName());		
	}
	
	@Test
	public void atualizar()
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
	public void deletar()
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
}
