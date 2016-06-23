package com.jericdy.sample.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import com.jericdy.sample.security.exception.InvalidUserCredentialsException;
import com.jericdy.sample.service.UserAccountService;

/**
 *
 * @author Jeric Bryle Sy Dy <jeric@jericbryledy.com>
 */
@Component
public class AuthenticationProviderImpl implements AuthenticationProvider {

	@Autowired
	private UserAccountService userAccountService;

	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String username = (String) auth.getPrincipal();
		String rawPassword = (String) auth.getCredentials();

		User user = userAccountService.getUserAccountByCredentials(username);

		if (user != null) {
			if (passwordEncoder.matches(rawPassword, user.getPassword())) {
				return new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), user.getAuthorities());
			}
		}

		throw new InvalidUserCredentialsException();
	}

	@Override
	public boolean supports(Class<?> auth) {
		return auth.equals(UsernamePasswordAuthenticationToken.class);
	}

}
