//package com.lohika.apm.portal.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
//
//@EnableWebSecurity
//public class SpringSecurityWebAppConfig extends WebSecurityConfigurerAdapter {
//
//    @Value("${security.user.name}")
//    private String userName;
//    @Value("${security.user.password}")
//    private String userPassword;
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        System.out.println("-userName = " + userName);
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withUsername(userName).password(userPassword).roles("USER").build());
//        return manager;
//    }
//
//
////    protected void configure(HttpSecurity http) throws Exception {
////        http
////                .authorizeRequests()
////                .antMatchers("/", "/home").permitAll()
////                .anyRequest().authenticated()
////                .and()
////                .formLogin()
////                .loginPage("/login")
////                .permitAll()
////                .and()
////                .logout()
////                .permitAll();
////    }
//
//}