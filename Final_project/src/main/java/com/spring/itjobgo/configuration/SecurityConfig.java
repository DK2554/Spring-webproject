package com.spring.itjobgo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/* 스프링 시큐리티 Configuration */

//자바빈 만드는 클래스
@Configuration
//WebSecurityConfigurerAdapter상속받은 클래스에 @EnableWebSecurity 어노테이션을 달면
//SpringSecurityFilterChain이 자동으로 포함됨!
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Override
	public void configure(final AuthenticationManagerBuilder auth) throws Exception{
		//AuthenticationManagerBuilder 인증객체를 만들 수 있도록 제공 --> 사용자를 인증하는 방법
		//@EnableWebSecurity, @EnableWebMvcSecurity, @EnableGlobalMethodSecurity, @EnableGlobalAuthentication 선언된 곳에서만 사용이 가능
		//@EnableWebSecurity을 썻으므로 주입 방식보다 Override방식이 위험을 줄일 수 있음
		auth.inMemoryAuthentication().withUser("user@kh.com").password("1234").roles("USER");
		
	}
	
	@Override
	protected void configure(final HttpSecurity http) throws Exception{
		//HttpSecurity통해서 인증 매커니즘 구현 가능
		
		http.csrf().disable().authorizeRequests()
		//토큰을 활용하는 경우 모든 요청에 대해 접근 가능하도록
		.anyRequest().permitAll()
		//토큰 인증은 세션 필요없음-->세션사용 안함
		 .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		 //form 기반 로그인 비활성화
		 .and().formLogin().disable();
		
	}
	
	//암호화
	@Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
	

}
