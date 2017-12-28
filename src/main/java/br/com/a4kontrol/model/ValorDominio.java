/**
 * 
 */
package br.com.a4kontrol.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author geovan.goes
 *
 */
@Entity
public class ValorDominio implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6244257539223596968L;

	@Id
	private Long id;

	@ManyToOne
	@JoinColumn(name = "dominio_id")
	private Dominio dominio;

	private String valor;

	private String descricao;

	/**
	 * @return the id
	 */
	public Long getId()
	{
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id)
	{
		this.id = id;
	}

	/**
	 * @return the dominio
	 */
	public Dominio getDominio()
	{
		return dominio;
	}

	/**
	 * @param dominio
	 *            the dominio to set
	 */
	public void setDominio(Dominio dominio)
	{
		this.dominio = dominio;
	}

	/**
	 * @return the valor
	 */
	public String getValor()
	{
		return valor;
	}

	/**
	 * @param valor
	 *            the valor to set
	 */
	public void setValor(String valor)
	{
		this.valor = valor;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao()
	{
		return descricao;
	}

	/**
	 * @param descricao
	 *            the descricao to set
	 */
	public void setDescricao(String descricao)
	{
		this.descricao = descricao;
	}
}
