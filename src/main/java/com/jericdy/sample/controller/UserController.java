package com.jericdy.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.jericdy.sample.dao.UserDao;

/**
 *
 * @author Jeric Bryle Sy Dy <jeric@jericbryledy.com>
 */
@Controller
@Secured("ROLE_ADMIN")
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserDao userDao;

	@RequestMapping("/")
	public ModelAndView users() {
		ModelAndView mv = new ModelAndView("users");

		mv.addObject("users", userDao.findAll());

		return mv;
	}

}
