package br.com.a4kontrol;
import static org.junit.Assert.assertNotNull;
import br.com.a4kontrol.controller.DominioController;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @author geovan.goes
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DominioTest
{
	
	@Autowired
	DominioController controller;
	
	@Test
	public void obterDominio()
	{
		assertNotNull(controller.obterDominio("periodos"));
	}
}
