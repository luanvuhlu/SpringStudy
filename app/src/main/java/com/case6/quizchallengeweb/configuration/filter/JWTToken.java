package com.case6.quizchallengeweb.configuration.filter;

import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class JWTToken extends UsernamePasswordAuthenticationToken {

	public JWTToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
		super(principal, credentials, authorities);
	}

	public JWTToken(Object principal, Object credentials) {
		super(principal, credentials);
	}

}
