/**
 * 
 */
package br.com.a4kontrol.controller;

import br.com.a4kontrol.service.LancamentoService;
import br.com.a4kontrol.to.ResultBaseFactoryTO;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
	public ResultBaseFactoryTO obterPorUsuario()
	{
		return lancamentoService.obterPorUsuario();
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResultBaseFactoryTO inserir(@DateTimeFormat(pattern="yyyy-MM-dd HH:mm") Date data)
	{
		return lancamentoService.inserir(data);
	}
}
