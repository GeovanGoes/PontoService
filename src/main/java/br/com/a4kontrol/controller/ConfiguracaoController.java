package br.com.a4kontrol.controller;

import br.com.a4kontrol.service.ConfiguracaoService;
import br.com.a4kontrol.to.ConfiguracaoTO;
import br.com.a4kontrol.to.ResultBaseFactoryTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/configuracoes")
public class ConfiguracaoController
{

	@Autowired
	private ConfiguracaoService service;

	/***
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResultBaseFactoryTO obterConfiguracoes()
	{
		return service.getConfiguracoes();
	}
	
	/***
	 * 
	 * @param configuracaoTO
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResultBaseFactoryTO salvarConfiguracao(ConfiguracaoTO configuracaoTO)
	{
		return service.salvarConfiguracao(configuracaoTO);
	}
	
}