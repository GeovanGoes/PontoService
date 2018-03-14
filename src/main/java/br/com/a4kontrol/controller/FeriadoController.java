/**
 * 
 */
package br.com.a4kontrol.controller;

import br.com.a4kontrol.service.FeriadoService;
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
@RequestMapping(value = "/feriados")
public class FeriadoController
{
	@Autowired
	private FeriadoService service;

	/***
	 * 
	 * @param userId
	 * @param date
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResultBaseFactoryTO inserirFeriado(@DateTimeFormat(pattern="yyyy-MM-dd") Date date)
	{		
		return service.inserir(date);
	}

	/***
	 * 
	 * @param userName
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResultBaseFactoryTO obterFeriados()
	{
		return service.getAll();
	}
}
