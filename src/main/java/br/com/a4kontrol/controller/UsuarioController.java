/**
 * 
 */
package br.com.a4kontrol.controller;

import br.com.a4kontrol.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author geovan.goes
 *
 */
@Controller
public class UsuarioController 
{
	
	@Autowired
	private UsuarioService service;
	
	@RequestMapping(method=RequestMethod.POST, name="/usuarios")
	public @ResponseBody boolean inserirUsuario(String userName)
	{
		return service.inserir(userName);
	}
}
