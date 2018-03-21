/**
 * 
 */
package br.com.a4kontrol.authentication.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author geovan.goes
 *
 */
public class SessionUtil
{
	
	public static String getUserNameAutheticatedUser()
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return auth.getName();
	}
}
