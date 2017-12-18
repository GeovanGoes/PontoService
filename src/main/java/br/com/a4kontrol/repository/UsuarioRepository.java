/**
 * 
 */
package br.com.a4kontrol.repository;

import br.com.a4kontrol.model.Usuario;

import org.springframework.data.repository.CrudRepository;

/**
 * @author geovan.goes
 *
 */
public interface UsuarioRepository extends CrudRepository<Usuario, Long>
{
	Usuario getByUserName(String userName);
}
