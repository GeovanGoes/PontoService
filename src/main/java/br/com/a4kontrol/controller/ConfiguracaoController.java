package br.com.a4kontrol.controller;

import br.com.a4kontrol.model.Configuracao;
import br.com.a4kontrol.service.ConfiguracaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ConfiguracaoController 
{

	@Autowired
	private ConfiguracaoService service;
	
	@RequestMapping(method=RequestMethod.GET, name="/configuracoes")
	public @ResponseBody Iterable<Configuracao> list()
	{
		return service.list();
	}
}