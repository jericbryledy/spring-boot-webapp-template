package com.jericdy.sample.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.jericdy.sample.dao.UserDao;
import com.jericdy.sample.model.UserAccount;
import com.jericdy.sample.orm.User;
import com.jericdy.sample.service.UserAccountService;

/**
 *
 * @author Jeric Bryle Sy Dy <jeric@jericbryledy.com>
 */
@Service
public class UserAccountServiceImpl implements UserAccountService {

	@Autowired
	private UserDao userDao;

	@Override
	@Transactional(readOnly = true)
	public UserAccount getUserAccount(String username) {
		UserAccount userAccount = null;
		User user = userDao.findByUsername(username);

		if (user != null) {
			userAccount = new UserAccount(user);
		}

		return userAccount;
	}

	@Override
	@Transactional(readOnly = true)
	public org.springframework.security.core.userdetails.User getUserAccountByCredentials(String username) {
		org.springframework.security.core.userdetails.User userAccount = null;
		User user = userDao.findByUsername(username);

		if (user != null) {
			userAccount = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPasswordHash(), user.getRoleCollection());
		}

		return userAccount;
	}

}
