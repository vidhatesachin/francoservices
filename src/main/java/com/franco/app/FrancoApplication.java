package com.franco.app;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.web.cors.CorsUtils;


/**
 * @author Sachin Vidhate
 */
@SpringBootApplication
@EnableCaching
public class FrancoApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(FrancoApplication.class, args);
	}
	
	@Override
	 protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	  return application.sources(FrancoApplication.class);
	}
	
	@Configuration
	class RepositoryConfig extends RepositoryRestConfigurerAdapter {
	    @Override
	    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
	    	config.setReturnBodyOnUpdate(true);
	    }
	}
}


@EnableWebSecurity
@Configuration
class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
	      .csrf().disable();
		http
        .authorizeRequests()
        .requestMatchers(CorsUtils	::isCorsRequest).permitAll()
        //.anyRequest().authenticated()
        .and().httpBasic()
        .and().addFilterBefore(new WebSecurityCorsFilter(), ChannelProcessingFilter.class);
		
	}

}

class WebSecurityCorsFilter implements Filter {
	
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse res = (HttpServletResponse) response;
        res.setHeader("Access-Control-Allow-Origin", "*");
        res.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
        res.setHeader("Access-Control-Max-Age", "3600");
        res.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type, Accept, x-requested-with, Cache-Control");
        chain.doFilter(request, res);
    }
    public void destroy() {
    }
}