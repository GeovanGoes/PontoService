package br.com.a4kontrol.service;

import br.com.a4kontrol.model.Configuracao;
import br.com.a4kontrol.repository.ConfiguracaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfiguracaoService 
{

	@Autowired
	private ConfiguracaoRepository repository;
	
	/***
	 * 
	 * @return
	 */
	public Iterable<Configuracao> list()
	{
		return repository.findAll();
	}
	
	/***
	 * 
	 * @param configuracao
	 * @return
	 */
	public Configuracao save (Configuracao configuracao)
	{
		return repository.save(configuracao);
	}
}
