/**
 * 
 */
package br.com.a4kontrol.controller;

import br.com.a4kontrol.service.LancamentoService;
import br.com.a4kontrol.to.ResultBaseFactoryTO;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author geovan.goes
 *
 */
@RestController
@RequestMapping(value = "/lancamentos")
public class LancamentosController
{

	@Autowired
	LancamentoService lancamentoService;

	@RequestMapping(method = RequestMethod.GET)
	public ResultBaseFactoryTO obterPorUsuario(String userName)
	{
		return lancamentoService.obterPorUsuario(userName);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResultBaseFactoryTO inserir(String userName, Date data)
	{
		return lancamentoService.inserir(userName, data);
	}
}
