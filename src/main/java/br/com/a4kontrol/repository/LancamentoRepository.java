/**
 * 
 */
package br.com.a4kontrol.repository;

import br.com.a4kontrol.model.Lancamento;

import org.springframework.data.repository.CrudRepository;

/**
 * @author geovan.goes
 *
 */
public interface LancamentoRepository extends CrudRepository<Lancamento, Long>
{
}
