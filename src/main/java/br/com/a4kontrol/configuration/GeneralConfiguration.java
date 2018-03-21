/**
 * 
 */
package br.com.a4kontrol.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

/**
 * @author geovan.goes
 *
 */
@Configuration
public class GeneralConfiguration
{
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
		builder
			.inMemoryAuthentication()
			.withUser("Geovan").password("123").roles("USER");
	}
}
