package com.jericdy.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.jericdy.sample.dao.UserDao;
import com.jericdy.sample.model.UserAccount;
import com.jericdy.sample.service.UserAccountService;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author Jeric Bryle Sy Dy <jeric@jericbryledy.com>
 */
@Controller
@Secured("ROLE_ADMIN")
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserAccountService userAccountService;

	@Autowired
	private UserDao userDao;

	@RequestMapping("/list")
	public ModelAndView users() {
		ModelAndView mv = new ModelAndView("user/list");

		UserAccount user = userAccountService.getUserAccount((String) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
		mv.addObject("user", user);

		mv.addObject("users", userDao.findAll());

		return mv;
	}

}
