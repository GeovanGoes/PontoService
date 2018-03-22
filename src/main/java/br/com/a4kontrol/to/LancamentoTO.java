package br.com.a4kontrol.to;

import br.com.a4kontrol.model.Lancamento;

import java.util.Date;

public class LancamentoTO 
{
	private Date data;

	public LancamentoTO(Lancamento lancamento)
	{
		super();
		this.data = lancamento.getDataLancamento();
	}

	/**
	 * @return the data
	 */
	public Date getData()
	{
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Date data)
	{
		this.data = data;
	}
}
