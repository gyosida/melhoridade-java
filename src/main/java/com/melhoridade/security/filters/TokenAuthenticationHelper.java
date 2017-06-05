package com.melhoridade.security.filters;

import java.util.Collections;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenAuthenticationHelper {

	static final String SIGNING_KEY = "secret"; // TODO provide it from a config file
	static final String AUTHENTICATION_PREFIX = "Bearer";
	static final String AUTHORIZATION_TOKEN_KEY = "Authorization";
	static final long EXPIRATION_TIME = TimeUnit.DAYS.toMillis(10);

	static void addAuthentication(HttpServletResponse httpServletResponse, String email) {
		String token = Jwts.builder()
							.setSubject(email)
							.setExpiration(expirationDate())
							.signWith(SignatureAlgorithm.HS512, signingKey())
							.compact();
		httpServletResponse.addHeader(AUTHORIZATION_TOKEN_KEY, AUTHENTICATION_PREFIX + " " + token);
		
	}

	private static Date expirationDate() {
		return new Date(System.currentTimeMillis() + EXPIRATION_TIME);
	}

	private static String signingKey() {
		return SIGNING_KEY;
	}
	
	static Authentication getAuthentication(HttpServletRequest httpServletRequest) {
		String token = httpServletRequest.getHeader(AUTHORIZATION_TOKEN_KEY);
		if (token != null) {
			String email = Jwts.parser()
			.setSigningKey(signingKey())
			.parseClaimsJws(token.replace(AUTHENTICATION_PREFIX, ""))
			.getBody()
			.getSubject();
			if (email != null) {
				return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());
			}
		}
		return null;
	}

}
