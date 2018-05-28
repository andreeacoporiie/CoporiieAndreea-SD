package com.mkyong.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.mkyong.entity.Professor;
import com.mkyong.entity.Student;
import com.mkyong.service.ProfService;
import com.mkyong.service.StudentService;

@Configuration
// http://docs.spring.io/spring-boot/docs/current/reference/html/howto-security.html
// Switch off the Spring Boot security configuration
//@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    @Autowired
    StudentService ss;
    
    @Autowired
    ProfService ps;
    
    @Bean
	public AuthenticationSuccessHandler successHandler() {
	    return new RedirectHandler();
	}
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/home", "/about").permitAll()
                .antMatchers("/admin/**").hasAnyRole("ADMIN")
                .antMatchers("/user/**").hasAnyRole("USER")
                .antMatchers("/prof/**").hasAnyRole("PROF")
                .antMatchers("/profs/**").hasAnyRole("PROF")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .successHandler(successHandler())
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

    	
    	List<Student> students = new ArrayList<Student>();
    	List<Professor> profs = new ArrayList<Professor>();
    	
    	ss.findAll().forEach(e -> students.add((Student)e));
    	ps.findAll().forEach(e -> profs.add((Professor)e));
    	
    	for (Student s: students)
    	{
    		auth.inMemoryAuthentication()
                .withUser(s.getUsername()).password(s.getPassword()).roles("USER");
    	}
    	for (Professor p: profs)
    	{
    		if (p.isAdmin()){
    			auth.inMemoryAuthentication()
                	.withUser(p.getUsername()).password(p.getPassword()).roles("ADMIN");
    		}
    		else
    			auth.inMemoryAuthentication()
            	.withUser(p.getUsername()).password(p.getPassword()).roles("PROF");
    	}
    } 

    /*
    //Spring Boot configured this already.
    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }*/

}
