package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private UserDetailsService userDetailsService;   
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	 http
         .authorizeHttpRequests(authorize -> authorize
             .anyRequest().permitAll()
         ).csrf(AbstractHttpConfigurer::disable)
         .formLogin(formLogin ->
         formLogin
         .loginPage("/formlogin")//實際顯示登入頁面
         .loginProcessingUrl("/login") //設定登入頁面的url並呼叫 CustomUserDetailsService 不會呼叫自訂 /login             
       	.usernameParameter("username")//登入表單form中使用者名稱輸入框input的name名，不修改的話預設是username
         .passwordParameter("password")//form中密碼輸入框input的name名，不修改的話預設是password
         .defaultSuccessUrl("/")    //成功登入之後導向 
       )
     .logout(logout ->
         logout
             .logoutUrl("/api/logout")
             .permitAll()
     );
     return http.build();
    }
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }  
}
