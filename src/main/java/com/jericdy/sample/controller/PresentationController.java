package com.jericdy.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.jericdy.sample.model.UserAccount;
import com.jericdy.sample.service.UserAccountService;

/**
 *
 * @author Jeric Bryle Sy Dy <jeric@jericbryledy.com>
 */
@Controller
public class PresentationController {

	@Autowired
	private UserAccountService userAccountService;

	@Secured({"ROLE_ADMIN", "ROLE_TEACHER"})
	@RequestMapping("/presentation")
	public ModelAndView presentationList() {
		ModelAndView mv = new ModelAndView("presentation/list");

		UserAccount user = userAccountService.getUserAccount((String) SecurityContextHolder.getContext().getAuthentication().getPrincipal());

		mv.addObject("user", user);

		return mv;
	}

}
