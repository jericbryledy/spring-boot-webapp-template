package com.jericdy.sample.model;

import com.jericdy.sample.orm.User;

/**
 *
 * @author Jeric Bryle Sy Dy <jeric@jericbryledy.com>
 */
public class UserAccount {

	private String username;
	private String password;
	private String email;
	private String givenName;
	private String lastName;

	public UserAccount(User user) {
		username = user.getUsername();
		email = user.getEmail();
		givenName = user.getGivenName();
		lastName = user.getLastName();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
