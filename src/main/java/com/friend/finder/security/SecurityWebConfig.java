package com.friend.finder.security;

import com.friend.finder.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityWebConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private AccountService accountService;

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers(
//                        "/login",
//                        "/login-page",
//                        "/signUp-page",
//                        "/signUp",
//                        "/").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login-page")
//                .permitAll()
//                .and()
//                .logout()
//                .invalidateHttpSession(true)
//                .clearAuthentication(true)
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .logoutSuccessUrl("/login?logout")
//                .permitAll();
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/login", "/signUp").permitAll()
                .and().authorizeRequests().antMatchers("/timeline-about").hasRole("USER")
                .and().authorizeRequests().antMatchers("/chat").hasRole("USER")
                .and().formLogin()
                .loginPage("/login-page")
                .loginProcessingUrl("/check-login")
                .defaultSuccessUrl("/timeline-about").permitAll()
                .and().logout().logoutUrl("/logout");
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService((UserDetailsService) accountService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
}
