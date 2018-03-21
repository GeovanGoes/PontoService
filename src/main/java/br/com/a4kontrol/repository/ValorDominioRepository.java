/**
 * 
 */
package br.com.a4kontrol.repository;

import java.util.List;

import br.com.a4kontrol.model.Dominio;
import br.com.a4kontrol.model.ValorDominio;

import org.springframework.data.repository.CrudRepository;

/**
 * @author geovan.goes
 *
 */
public interface ValorDominioRepository extends CrudRepository<ValorDominio, Long>
{
	/***
	 * 
	 * @param dominio
	 * @return
	 */
	List<ValorDominio> getValorDominioByDominio(Dominio dominio);
}
