package com.jericdy.sample.security.exception;

import org.springframework.security.core.AuthenticationException;

/**
 *
 * @author Jeric Bryle Sy Dy <jeric@jericbryledy.com>
 */
public class InvalidUserCredentialsException extends AuthenticationException {

	public InvalidUserCredentialsException() {
		super("Invalid User Credentials");
	}

}
