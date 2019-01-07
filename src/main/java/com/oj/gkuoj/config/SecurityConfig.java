package com.oj.gkuoj.config;

import com.oj.gkuoj.config.filter.ValidateCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

/**
 * @author m969130721@163.com
 * @date 19-1-2 下午4:03
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    //token加密salt
    private static final String KEY = "m969130721@163.com";

    @Bean
    public PasswordEncoder getPasswordEncode() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserDetailsService userDetailsService;


    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
//        tokenRepository.setCreateTableOnStartup(true);
        return tokenRepository;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(new ValidateCodeFilter(), UsernamePasswordAuthenticationFilter.class)
                .formLogin()
                .loginPage("/user/loginPage")
                .loginProcessingUrl("/user/loginProcess")
                .successForwardUrl("/index")
                .failureUrl("/user/loginError")
                .permitAll()
                .and()
                .logout().logoutUrl("/user/logout").logoutSuccessUrl("/index").permitAll()
                .and()
                .rememberMe()
                .tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(3600 * 24)
                .userDetailsService(userDetailsService)
                .and()
                .authorizeRequests()
                .antMatchers("/css/**", "/js/**", "/fonts/**",
                        "/img/**", "/vendors/**", "/user/registerPage", "/validate/**", "/index")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .headers().frameOptions().sameOrigin()
                .and()
                .csrf().disable();

    }
}
