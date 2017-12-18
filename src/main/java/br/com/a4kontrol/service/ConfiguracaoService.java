package br.com.a4kontrol.service;

import br.com.a4kontrol.model.Configuracao;
import br.com.a4kontrol.model.Usuario;
import br.com.a4kontrol.repository.ConfiguracaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfiguracaoService 
{

	@Autowired
	private ConfiguracaoRepository repository;
	
	@Autowired
	private UsuarioService usuarioService;
	
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
	
	/***
	 * 
	 * @param userId
	 * @param configuracao
	 * @return
	 */
	public boolean save (Long userId, Configuracao configuracao)
	{
		if (configuracao != null)
		{
			Usuario usuario = usuarioService.getUsuario(userId);
			
			if (usuario != null)
			{
				usuario.getConfiguracoes().add(configuracao);
				usuarioService.update(usuario);
				return true;
			}
			return false;
		}
		return false;
	}
}
