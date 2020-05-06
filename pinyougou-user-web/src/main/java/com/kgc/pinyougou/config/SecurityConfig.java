package com.kgc.pinyougou.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
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
@EnableGlobalMethodSecurity(prePostEnabled = true)//开启全局注解
@EnableWebSecurity//开启服务
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 权限配置
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 配置拦截规则
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/css/**","/img/**","/js/**","/plugins/**","/register","/sampling","/cooperation","/seller/**").permitAll()//都可以访问
                .antMatchers("/admin/**").hasRole("LEVEL1")//需要相应的角色才能访问
                .antMatchers("/page2/**").hasAuthority("LEVEL2")
                .antMatchers("/page3/**").hasAuthority("LEVEL3")

                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
        // 配置登录功能
        http.formLogin()
                .loginPage("/login")  //  登录页
                .defaultSuccessUrl("/admin") // 登入成功后，跳转至指定页面
                .failureUrl("/login")
                .permitAll() ;
        //关闭跨站请求伪造保护
        //http.csrf().disable();
        //支持内置框架iframe
        http.headers().frameOptions().sameOrigin();
        // 注销成功跳转首页
        http.logout()
                //自定义退出配置
                //.logoutUrl()
                .logoutSuccessUrl("/login");//不配置默认登录页，指定退出到指定页
        //开启记住我功能
        http.rememberMe().rememberMeParameter("remeber");
    }


    @Autowired
    private UserDetailServiceImpl userDetailService;
    /**
     * 自定义认证数据源
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }
    @Bean
    public UserDetailServiceImpl userDetailService (){
        return new UserDetailServiceImpl () ;
    }
     /**
     * 密码加密
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

     //硬编码几个用户
/*    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("spring").password(passwordEncoder().encode("123456")).roles("LEVEL1");
        auth.inMemoryAuthentication()
                .withUser("summer").password(passwordEncoder().encode("123456")).roles("LEVEL2");
        auth.inMemoryAuthentication()
                .withUser("autumn").password(passwordEncoder().encode("123456")).roles("LEVEL3");
    }*/

}
