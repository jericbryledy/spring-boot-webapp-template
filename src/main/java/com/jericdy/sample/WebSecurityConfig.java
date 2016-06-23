package com.jericdy.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import com.jericdy.sample.security.AuthenticationProviderImpl;

/**
 *
 * @author Jeric Bryle Sy Dy <jeric@jericbryledy.com>
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, proxyTargetClass = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Value("${login.success.url:/}")
	private String loginSuccessUrl;

	@Value("${logout.success.url:/}")
	private String logoutSuccessUrl;

	@Autowired
	private AuthenticationProviderImpl authenticationProvider;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authenticationProvider(authenticationProvider)
				.authorizeRequests()
				.antMatchers("/", "/css/*", "/js/*", "/images/*", "/test").permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.loginPage("/login")
				.successHandler(new SimpleUrlAuthenticationSuccessHandler(loginSuccessUrl))
				.permitAll()
				.and()
				.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl(logoutSuccessUrl)
				.permitAll();
	}

}
