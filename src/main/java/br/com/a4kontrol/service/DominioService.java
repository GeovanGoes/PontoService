/**
 * 
 */
package br.com.a4kontrol.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.a4kontrol.model.Dominio;
import br.com.a4kontrol.model.ValorDominio;
import br.com.a4kontrol.repository.DominioRepository;
import br.com.a4kontrol.repository.ValorDominioRepository;
import br.com.a4kontrol.to.ResultBaseFactoryTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author geovan.goes
 *
 */
@Service
public class DominioService
{
	@Autowired
	DominioRepository repository;
	
	@Autowired
	ValorDominioRepository valorDominioRepository;
	
	/***
	 * 
	 * @return
	 */
	public ResultBaseFactoryTO incializarDominios()
	{
		ResultBaseFactoryTO resultBaseFactoryTO = new ResultBaseFactoryTO();
		Dominio periodos = new Dominio("periodos");
		repository.save(periodos);
		
		ValorDominio mensal = new ValorDominio(periodos, "Mensal");
		valorDominioRepository.save(mensal);
		ValorDominio bimensal = new ValorDominio(periodos, "Bimestral");
		valorDominioRepository.save(bimensal);
		ValorDominio trimensal = new ValorDominio(periodos, "Trimestral");
		valorDominioRepository.save(trimensal);
		ValorDominio quadrimensal = new ValorDominio(periodos, "Quadrimestral");
		valorDominioRepository.save(quadrimensal);		
		
		resultBaseFactoryTO.setSuccess(new HashMap<String, Object>());
		
		return resultBaseFactoryTO;
	}
	
	/***
	 * 
	 * @param nomeDominio
	 * @return
	 */
	public ResultBaseFactoryTO getDominio(String nomeDominio)
	{
		ResultBaseFactoryTO resultBaseFactoryTO = new ResultBaseFactoryTO();
		Dominio dominioByNome = repository.getDominioByNome(nomeDominio);
		if (dominioByNome != null)
		{
			List<ValorDominio> valorDominioByDominio = valorDominioRepository.getValorDominioByDominio(dominioByNome);
			if (valorDominioByDominio != null && !valorDominioByDominio.isEmpty())
			{
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("result", valorDominioByDominio);
				resultBaseFactoryTO.setSuccess(map);
			}
			else
			{
				resultBaseFactoryTO.addErrorMessage("falha-lista-dominio", "Não foi possível listar os valores para o domínio " + nomeDominio);
			}
		}
		else
		{
			resultBaseFactoryTO.addErrorMessage("falha-lista-dominio", "Não foi possível listar os valores para o domínio " + nomeDominio);
		}
		
		return resultBaseFactoryTO;
	}
	
}
