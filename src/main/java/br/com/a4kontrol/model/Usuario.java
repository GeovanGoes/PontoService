package br.com.a4kontrol.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Usuario implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2271214325142017522L;

	@Id
	@GeneratedValue
	private Long id;
	
	private String userName;
	
	@OneToMany
	private List<Configuracao> configuracoes;
	
	@OneToMany
	private List<Feriado> feriados;
	
	@OneToMany
	private List<Lancamento> lancamentos;

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
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the configuracoes
	 */
	public List<Configuracao> getConfiguracoes() {
		return configuracoes;
	}

	/**
	 * @param configuracoes the configuracoes to set
	 */
	public void setConfiguracoes(List<Configuracao> configuracoes) {
		this.configuracoes = configuracoes;
	}

	/**
	 * @return the feriados
	 */
	public List<Feriado> getFeriados() {
		return feriados;
	}

	/**
	 * @param feriados the feriados to set
	 */
	public void setFeriados(List<Feriado> feriados) {
		this.feriados = feriados;
	}

	/**
	 * @return the lancamentos
	 */
	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	/**
	 * @param lancamentos the lancamentos to set
	 */
	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}	
}