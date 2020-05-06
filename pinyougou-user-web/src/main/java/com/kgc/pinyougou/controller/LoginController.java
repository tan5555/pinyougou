package com.kgc.pinyougou.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: 谭海亮
 * @Date: 2020/4/29 13:29
 * @Description:
 */
@Controller
public class LoginController {

    /**
     * 首页
     */
    @RequestMapping(value = {"/admin","/admin/index","/admin/index.html"})
    public String index (){
        return "/admin/index" ;
    }
    /**
     * 登录页
     */
    @RequestMapping("/login")
    public String loginPage (){
        return "/shoplogin" ;
    }
    /**
     * 用户名
     */
    @RequestMapping("/login/name")
    @ResponseBody
    public Map name (){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        Map<Object, Object> map = new HashMap<>();
        map.put("loginName",name);
        return map;
    }
    /**
     * Home
     */
    @RequestMapping("/home")
    public String home (){
        return "/admin/home" ;
    }
    /**
     * register 注册
     */
    @RequestMapping("/register")
    public String register (){
        return "/register" ;
    }
    /**
     * sampling 注册协议
     */
    @RequestMapping("/sampling")
    public String sampling (){
        return "/sampling" ;
    }
    /**
     * cooperation
     */
    @RequestMapping("/cooperation")
    public String cooperation (){
        return "/cooperation" ;
    }
    /**
     * seller
     */
    @RequestMapping("/seller")
    public String type_template (){
        return "/admin/seller" ;
    }
    /**
     * password
     */
    @RequestMapping("/password")
    public String seller_1 (){
        return "/admin/password" ;
    }
     /**
     * goods_edit
     */
    @RequestMapping("/goods_edit")
    public String seller (){
        return "/admin/goods_edit" ;
    }
     /**
     * goods
     */
    @RequestMapping("/goods")
    public String brand (){
        return "/admin/goods" ;
    }

}
