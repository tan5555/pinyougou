package com.kgc.pinyougou.manage.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
        return "/login" ;
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
    public String Home (){
        return "/admin/home" ;
    }
    /**
     * brand
     */
    @RequestMapping("/brand")
    public String brand (){
        return "/admin/brand" ;
    }
    /**
     * specification
     */
    @RequestMapping("/specification")
    public String specification (){
        return "/admin/specification" ;
    }
    /**
     * type_template
     */
    @RequestMapping("/type_template")
    public String type_template (){
        return "/admin/type_template" ;
    }
    /**
     * seller_1
     */
    @RequestMapping("/seller_1")
    public String seller_1 (){
        return "/admin/seller_1" ;
    }
     /**
     * seller
     */
    @RequestMapping("/seller")
    public String seller (){
        return "/admin/seller_2" ;
    }
     /**
     * item_cat
     */
    @RequestMapping("/item_cat")
    public String item_cat (){
        return "/admin/item_cat" ;
    }
    /**
     * goods
     */
    @RequestMapping("/goods")
    public String goods (){
        return "/admin/goods" ;
    }
    /**
     * brand
     *//*
    @RequestMapping("/brand")
    public String brand (){
        return "/admin/brand" ;
    }*/







    /**
     * page1 下页面
     */
    @PreAuthorize("hasAuthority('LEVEL1')")
    @RequestMapping("/page1/{pageName}")
    public String onePage (@PathVariable("pageName") String pageName){
        return "pages/page1/"+pageName ;
    }
    /**
     * page2 下页面
     */
    @PreAuthorize("hasAuthority('LEVEL2')")
    @RequestMapping("/page2/{pageName}")
    public String twoPage (@PathVariable("pageName") String pageName){
        return "pages/page2/"+pageName ;
    }
    /**
     * page3 下页面
     */
    @PreAuthorize("hasAuthority('LEVEL3')")
    @RequestMapping("/page3/{pageName}")
    public String threePage (@PathVariable("pageName") String pageName){
        return "pages/page3/"+pageName ;
    }

}
