package com.kgc.pinyougou.demo_security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: 谭海亮
 * @Date: 2020/4/30 10:06
 * @Description:
 */
@Controller
public class HomeController {

    @RequestMapping(value = {"/","/home"})
    public String getHome1(){

        return "brand";
    }

    @ResponseBody
    @RequestMapping("api")
    public String getAPI(){
        return "Hello";
    }
}
