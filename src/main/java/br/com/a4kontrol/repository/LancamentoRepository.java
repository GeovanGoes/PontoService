/**
 * 
 */
package br.com.a4kontrol.repository;

import java.util.Date;
import java.util.List;

import br.com.a4kontrol.model.Lancamento;
import br.com.a4kontrol.model.Usuario;

import org.springframework.data.repository.CrudRepository;

/**
 * @author geovan.goes
 *
 */
public interface LancamentoRepository extends CrudRepository<Lancamento, Long>
{
	/**
	 * 
	 * @param usuario
	 * @return
	 */
	List<Lancamento> getLancamentoByUsuario(Usuario usuario);
	
	/***
	 * 
	 * @param usuario
	 * @param dataLancamento
	 * @return
	 */
	Lancamento getLancamentoByUsuarioAndDataLancamento(Usuario usuario, Date dataLancamento);
	
}
