package com.melhoridade.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.melhoridade.entities.UserAccount;
import com.melhoridade.services.AuthService;

@Component
public class AuthProviderService implements AuthenticationProvider {

	@Autowired
	private AuthService authService;
	
	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		String username = auth.getName();
		String password = auth.getCredentials().toString();
		
		UserAccount userAccount = authService.authenticate(username, password);
		if (userAccount != null) {
			return new UsernamePasswordAuthenticationToken(username, password, userAccount.getAuthorities());
		}		
		throw new UsernameNotFoundException("usuario e/ou senha invalidos");
	}

	@Override
	public boolean supports(Class<?> auth) {
		return auth.equals(UsernamePasswordAuthenticationToken.class);
	}
	
}
