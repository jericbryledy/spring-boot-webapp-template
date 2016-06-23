package com.jericdy.sample.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import com.jericdy.sample.orm.User;

/**
 *
 * @author Jeric Bryle Sy Dy <jeric@jericbryledy.com>
 */
@Transactional
public interface UserDao extends CrudRepository<User, Long> {

	public List<User> findAll();

	public User findByUsername(String username);

	public User findByUsernameAndPasswordHash(String username, String passwordHash);

}
