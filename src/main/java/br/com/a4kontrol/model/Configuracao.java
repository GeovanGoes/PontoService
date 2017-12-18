package br.com.a4kontrol.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

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
