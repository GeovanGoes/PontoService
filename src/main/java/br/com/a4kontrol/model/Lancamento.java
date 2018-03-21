package br.com.a4kontrol.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Lancamento implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8874472549895861322L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	private Date dataLancamento;

	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
	/***
	 * 
	 */
	public Lancamento()
	{
		
	}
	
	/***
	 * 
	 * @param data
	 * @param usuario
	 */
	public Lancamento(Date data, Usuario usuario)
	{
		this.dataLancamento = data;
		this.usuario = usuario;
	}
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the dataLancamento
	 */
	public Date getDataLancamento() {
		return dataLancamento;
	}

	/**
	 * @param dataLancamento the dataLancamento to set
	 */
	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}	
}
