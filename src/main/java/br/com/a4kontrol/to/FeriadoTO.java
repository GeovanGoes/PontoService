/**
 * 
 */
package br.com.a4kontrol.to;

import br.com.a4kontrol.model.Feriado;

import java.util.Date;

/**
 * @author geovan.goes
 *
 */
public class FeriadoTO
{
	private Date data;

	public FeriadoTO(Feriado feriado)
	{
		super();
		this.data = feriado.getData();
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
