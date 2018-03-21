/**
 * 
 */
package br.com.a4kontrol.repository;

import br.com.a4kontrol.model.Feriado;
import br.com.a4kontrol.model.Usuario;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * @author geovan.goes
 *
 */
public interface FeriadoRepository extends CrudRepository<Feriado, Long>
{
	/***
	 * 
	 * @param data
	 * @param usuario
	 * @return
	 */
	Feriado getFeriadoByDataAndUsuario(Date data, Usuario usuario);
	
	/***
	 * 
	 * @param usuario
	 * @return
	 */
	List<Feriado> getFeriadosByUsuario(Usuario usuario);
}
