package br.com.a4kontrol.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Configuracao implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8329876932030113966L;

	@Id
	private String chave;
	private String valor;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	public Configuracao(){}
	
	public Configuracao(String chave, String valor, Usuario usuario)
	{
		super();
		this.chave = chave;
		this.valor = valor;
		this.usuario = usuario;
	}

	public String getChave()
	{
		return chave;
	}

	public void setChave(String chave)
	{
		this.chave = chave;
	}

	public String getValor()
	{
		return valor;
	}

	public void setValor(String valor)
	{
		this.valor = valor;
	}
}
