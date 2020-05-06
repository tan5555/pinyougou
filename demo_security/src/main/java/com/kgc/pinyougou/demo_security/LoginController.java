package com.kgc.pinyougou.demo_security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: 谭海亮
 * @Date: 2020/4/30 12:25
 * @Description:
 */
@Controller
public class LoginController {

    @RequestMapping(value = {"/loginPage"})
    public String loginPage(){

        return "loginPage";
    }

    @RequestMapping(value = {"/logoutPage"})
    public String logoutPage(){

        return "logoutPage";
    }
}
