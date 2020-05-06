package com.kgc.pinyougou.demo_security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Auther: 谭海亮
 * @Date: 2020/4/29 12:53
 * @Description:
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 权限配置
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 配置拦截规则
        http.authorizeRequests()
                .anyRequest()
                .authenticated()

                .and()
                .formLogin()
                .loginPage("/loginPage")
                .permitAll()

                .and()
                .logout()
                .logoutUrl("/logoutPage")
                .logoutSuccessUrl("/loginPage?logout")
                .permitAll();

    }

    /**
     * 密码加密
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

     //硬编码几个用户
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("spring").password(passwordEncoder().encode("123456")).roles("LEVEL1")
                .and()
                .withUser("summer").password("123456").roles("LEVEL2","LEVEL3")
                .and()
                .withUser("autumn").password("123456").roles("LEVEL1","LEVEL3");
    }
}
