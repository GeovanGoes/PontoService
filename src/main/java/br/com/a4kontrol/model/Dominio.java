/**
 * 
 */
package br.com.a4kontrol.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author geovan.goes
 *
 */
@Entity
public class Dominio implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7196357639045025681L;

	@Id
	@GeneratedValue
	@Column(name="dominio_id")
	private Long id;
	
	private String nome;

	
	public Dominio()
	{
		
	}
	
	public Dominio(String nome)
	{
		this.nome = nome;
	}
	
	/**
	 * @return the id
	 */
	public Long getId()
	{
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id)
	{
		this.id = id;
	}

	/**
	 * @return the nome
	 */
	public String getNome()
	{
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome)
	{
		this.nome = nome;
	}
}