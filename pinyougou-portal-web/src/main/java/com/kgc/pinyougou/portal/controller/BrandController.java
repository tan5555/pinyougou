package com.kgc.pinyougou.portal.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.kgc.pinyougou.domain.Brand;
import com.kgc.pinyougou.service.BrandService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * @Auther: 谭海亮
 * @Date: 2020/4/24 09:56
 * @Description:
 */
@Controller
public class BrandController {

    @Reference(version = "1.0",interfaceClass = BrandService.class)
    private BrandService brandService;

    @RequestMapping("find")
    @ResponseBody
    public List<Brand> get(){
        List<Brand> all = brandService.findAll();
        return all;
    }

    @RequestMapping("user")
    public String index(){
        return "index";
    }

}
