package com.owner.test.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

import com.owner.test.handler.MyAccessDecisionManagerHandler;
import com.owner.test.handler.MyAuthenticationEntryPoint;
import com.owner.test.handler.MyAuthenticationFailureHandler;
import com.owner.test.handler.MyAuthenticationSuccessHandler;
import com.owner.test.handler.MyCodeValidatorProcessingFilter;
import com.owner.test.handler.MyLogoutSuccessHandler;
import com.owner.test.handler.MySecurityMetadataSourceHandler;
import com.owner.test.handler.MyUserDetailsServiceHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	public UserDetailsService userDetailsService() {
	    return new MyUserDetailsServiceHandler();
	}
	
	@Bean
	public org.springframework.security.crypto.password.PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider(){
	    DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
	    authenticationProvider.setUserDetailsService(userDetailsService());
	    authenticationProvider.setPasswordEncoder(passwordEncoder());
	    return authenticationProvider;
	}
	
	@Bean
	public AccessDecisionManager accessDecisionManager() {
	    return new MyAccessDecisionManagerHandler();
	}
	
	@Bean
	public FilterInvocationSecurityMetadataSource securityMetadataSource() {
	    return new MySecurityMetadataSourceHandler();
	}
	
	@Bean
	public AuthenticationSuccessHandler authenticationSuccessHandler() {
		return new MyAuthenticationSuccessHandler();
	}
	
	@Bean
	public AuthenticationFailureHandler authenticationFailureHandler() {
		return new MyAuthenticationFailureHandler();
	}
	
	@Bean
	public LogoutSuccessHandler logoutSuccessHandler() {
		return new MyLogoutSuccessHandler();
	}
	
	@Bean
	public AuthenticationEntryPoint authenticationEntryPoint() {
		return new MyAuthenticationEntryPoint();
	}
	
	@Bean
	public AbstractAuthenticationProcessingFilter codeValidatorProcessingFilter() throws Exception {
		
		MyCodeValidatorProcessingFilter myCodeValidatorProcessingFilter = new MyCodeValidatorProcessingFilter();
		
		myCodeValidatorProcessingFilter.setAuthenticationManager(this.authenticationManagerBean());
		
		return myCodeValidatorProcessingFilter;
	}
	
	@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		.antMatchers("/user/login","/failure","/validcode*").permitAll().anyRequest().authenticated();
		
		http.formLogin().loginPage("/user/login").loginProcessingUrl("/login")
		.successHandler(authenticationSuccessHandler())
		.failureHandler(authenticationFailureHandler())
		.withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {

			@Override
			public <O extends FilterSecurityInterceptor> O postProcess(O object) {
				object.setAccessDecisionManager(accessDecisionManager());
				object.setSecurityMetadataSource(securityMetadataSource());
				return object;
			}
			
		});
		
		http.csrf().disable();
		
		http.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint());
		
		//http.addFilterBefore(codeValidatorProcessingFilter(), AbstractPreAuthenticatedProcessingFilter.class);
		
		http.addFilterAt(codeValidatorProcessingFilter(),UsernamePasswordAuthenticationFilter.class);
		
		http.logout().invalidateHttpSession(true)
		.logoutUrl("/logout").logoutSuccessHandler(logoutSuccessHandler());
		
	}
	
}
