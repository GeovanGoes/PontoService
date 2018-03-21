package br.com.a4kontrol.service;

import br.com.a4kontrol.authentication.util.SessionUtil;
import br.com.a4kontrol.model.Configuracao;
import br.com.a4kontrol.model.Usuario;
import br.com.a4kontrol.repository.ConfiguracaoRepository;
import br.com.a4kontrol.to.ConfiguracaoTO;
import br.com.a4kontrol.to.ResultBaseFactoryTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 * 
 * @author geovan.goes
 *
 */
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
	public ResultBaseFactoryTO getConfiguracoes()
	{
		ResultBaseFactoryTO resultBaseFactoryTO = new ResultBaseFactoryTO();
		
		Usuario usuario = usuarioService.getUsuario(SessionUtil.getUserNameAutheticatedUser());
			
		List<Configuracao> configuracaoByUsuario = repository.getConfiguracaoByUsuario(usuario);
			
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("result", configuracaoByUsuario);
		resultBaseFactoryTO.setSuccess(result);
		
		return resultBaseFactoryTO;
	}
	
	/***
	 * 
	 * @param configuracao
	 * @return
	 */
	public ResultBaseFactoryTO salvarConfiguracao(ConfiguracaoTO configuracaoTO)
	{
		ResultBaseFactoryTO resultBaseFactoryTO = new ResultBaseFactoryTO();
		
		Usuario usuario = usuarioService.getUsuario(SessionUtil.getUserNameAutheticatedUser());
		
		if (usuario != null)
		{
			Configuracao configuracaoExistente = repository.getConfiguracaoByChaveAndUsuario(configuracaoTO.getChave(), usuario);	
			if (configuracaoExistente != null)
			{
				configuracaoExistente.setValor(configuracaoTO.getValor());
				repository.save(configuracaoExistente);
				resultBaseFactoryTO.setSuccess(new HashMap<String, Object>());
			}
			else
			{
				Configuracao novaConfiguracao = new Configuracao(configuracaoTO.getChave(), configuracaoTO.getValor(), usuario);
				repository.save(novaConfiguracao);
				resultBaseFactoryTO.setSuccess(new HashMap<String, Object>());
			}
		}
		else
		{
			resultBaseFactoryTO.addErrorMessage("falha-salvar-configuracao", "Não foi possível salvar a configuração. " + configuracaoTO.getChave());
		}
		
		return resultBaseFactoryTO;
	}
}
