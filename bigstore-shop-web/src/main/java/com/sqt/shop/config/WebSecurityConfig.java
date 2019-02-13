//package com.sqt.shop.config;
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.sqt.shop.handler.LoginSuccessHandler;
//import com.sqt.shop.service.UserDetailsServiceImpl;
//import javax.sql.DataSource;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
//
///**
// * @Description:
// * @author: sqt(男，未婚) 微信:810548252
// * @Date: Created in 2018-11-14  15:48
// */
////@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//	private static final Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class);
//	@Autowired
//	private UserDetailsServiceImpl customUserDetailsService;
//
//
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		logger.debug("==================>加载了configure");
//		http.headers().frameOptions().disable();
//		http.authorizeRequests()
//		.antMatchers("/*.html","/js/**","/css/**","/img/**","/images/**",
//			"/plugins/**","seller/add").permitAll()
//		.antMatchers("/seller/add").permitAll()
////		.antMatchers( "/admin/**").hasRole("ROLE_SELLER" )
//			//其他地址的访问均需验证权限
//		.anyRequest().authenticated()
//		.and()
//		.formLogin()
//			//指定登录页是”/login”
//			.loginPage("/login.html").permitAll()
////			.loginProcessingUrl("/bigstore/login") //默认拦截的url
//			.defaultSuccessUrl("/admin/index.html",true)
//			//登录成功后可使用loginSuccessHandler()存储用户信息，可选。
////			.successHandler(loginSuccessHandler())
//		.and()
//			.logout()
//			//退出登录后的默认网址是”/home”
//			.logoutSuccessUrl("/login.html").permitAll()
//			.invalidateHttpSession(true)
//		.and()
//			//关闭跨域
//			.csrf().disable();
//		//登录后记住用户，下次自动登录
//        //数据库中必须存在名为persistent_logins的表
//        //建表语句见code15
//		/*.rememberMe()
//		.tokenValiditySeconds(1209600)
//		//指定记住登录信息所使用的数据源
//		.tokenRepository(tokenRepository())*/;//code4
//
//	}
//
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		logger.debug("==================>加载了UserDetailsServiceImpl");
//		//指定密码加密所使用的加密器为passwordEncoder()
//		//需要将密码加密后写入数据库 //code13
//		auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());//code5
//	}
//
//
//	// Code5----------------------------------------------
//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
////
////	// Code4----------------------------------------------
////	/*@Bean
////	public JdbcTokenRepositoryImpl tokenRepository(){
////		JdbcTokenRepositoryImpl j=new JdbcTokenRepositoryImpl();
////		j.setDataSource(dataSource);
////		return j;
////	}*/
////
//	// 注入认证成功处理器----------------------------------------------
//	@Bean
//	public LoginSuccessHandler loginSuccessHandler(){
//		return new LoginSuccessHandler();//code6
//	}
//}
