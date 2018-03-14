/**
 * 
 */
package br.com.a4kontrol.controller;

import br.com.a4kontrol.service.DominioService;
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
@RequestMapping(value = "/dominios")
public class DominioController
{

	@Autowired
	DominioService service;
	
	@RequestMapping(method = RequestMethod.GET, value="/inicializar")
	public ResultBaseFactoryTO inicializar()
	{
		return service.incializarDominios();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResultBaseFactoryTO obterDominio(String nome)
	{
		return service.getDominio(nome);
	}
}
