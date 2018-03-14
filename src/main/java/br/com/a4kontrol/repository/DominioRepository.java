/**
 * 
 */
package br.com.a4kontrol.repository;

import br.com.a4kontrol.model.Dominio;

import org.springframework.data.repository.CrudRepository;

/**
 * @author geovan.goes
 *
 */
public interface DominioRepository extends CrudRepository<Dominio, Long>
{
	/***
	 * 
	 * @param nome
	 * @return
	 */
	Dominio getDominioByNome(String nome);
}
