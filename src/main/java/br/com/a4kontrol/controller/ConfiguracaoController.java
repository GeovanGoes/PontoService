package br.com.a4kontrol.controller;

import br.com.a4kontrol.service.ConfiguracaoService;
import br.com.a4kontrol.to.ResultBaseFactoryTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/configuracoes")
public class ConfiguracaoController
{

	@Autowired
	private ConfiguracaoService service;

	/*
	 * @RequestMapping(method=RequestMethod.GET) public Iterable<Configuracao> list() { return service.list(); }
	 * 
	 * @RequestMapping(method=RequestMethod.POST, name="/configuracoes1") public boolean minhaRola () { return new ResultBaseFactoryTO().isSuccess(); }
	 */

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody ResultBaseFactoryTO insertConfiguracao(Long idUsuari)
	{
		return new ResultBaseFactoryTO();
	}
}