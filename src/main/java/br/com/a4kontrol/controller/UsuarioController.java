/**
 * 
 */
package br.com.a4kontrol.controller;

import br.com.a4kontrol.service.UsuarioService;
import br.com.a4kontrol.to.ResultBaseFactoryTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author geovan.goes
 *
 */
@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController
{

	@Autowired
	private UsuarioService service;

	@RequestMapping(method = RequestMethod.POST)
	public ResultBaseFactoryTO inserirUsuario(String userName)
	{
		return service.inserir(userName);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResultBaseFactoryTO listar()
	{
		return service.list();
	}
}
