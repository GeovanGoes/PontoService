package br.com.a4kontrol.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Configuracao 
{
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