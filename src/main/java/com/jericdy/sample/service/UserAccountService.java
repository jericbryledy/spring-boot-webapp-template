package com.jericdy.sample.service;

import org.springframework.security.core.userdetails.User;
import com.jericdy.sample.model.UserAccount;

/**
 *
 * @author Jeric Bryle Sy Dy <jeric@jericbryledy.com>
 */
public interface UserAccountService {

	public UserAccount getUserAccount(String username);

	public User getUserAccountByCredentials(String username);

}
