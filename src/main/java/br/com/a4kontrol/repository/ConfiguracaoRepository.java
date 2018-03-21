package br.com.a4kontrol.repository;

import java.util.List;

import br.com.a4kontrol.model.Configuracao;
import br.com.a4kontrol.model.Usuario;

import org.springframework.data.repository.CrudRepository;

/***
 * 
 * @author geovan.goes
 *
 */
public interface ConfiguracaoRepository extends CrudRepository<Configuracao, String>
{
	/***
	 * 
	 * @param chave
	 * @param usuario
	 * @return
	 */
	Configuracao getConfiguracaoByChaveAndUsuario(String chave, Usuario usuario);
	
	/***
	 * 
	 * @param usuario
	 * @return
	 */
	List<Configuracao> getConfiguracaoByUsuario(Usuario usuario);
}
