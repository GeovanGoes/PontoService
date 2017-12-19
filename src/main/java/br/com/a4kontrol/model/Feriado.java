package br.com.a4kontrol.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Feriado implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4444928426262316001L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	private Date data;
	
	@ManyToOne
	private Usuario usuario;
	
	public Feriado(Date data) {
		super();
		this.data = data;
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
	 * @return the data
	 */
	public Date getData() {
		return data;
	}


	/**
	 * @param data the data to set
	 */
	public void setData(Date data) {
		this.data = data;
	}
}
