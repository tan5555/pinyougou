package com.kgc.pinyougou.manage.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.kgc.pinyougou.domain.Brand;
import com.kgc.pinyougou.service.BrandService;
import com.kgc.pinyougou.utils.PageResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;


/**
 * @Auther: 谭海亮
 * @Date: 2020/4/24 09:56
 * @Description:
 */
@Controller
@RequestMapping("brand")
public class BrandController {

    @Reference(version = "1.0",interfaceClass = BrandService.class)
    private BrandService brandService;

    @RequestMapping("findAllBrand")
    @ResponseBody
    public List<Map> findAllBrand(){
        List<Map> map = brandService.findAllBrand();
        return map;
    }

    @RequestMapping("findPageBrand")
    @ResponseBody
    public PageResult findPageBrand(Integer page, Integer size, @RequestBody Brand brand){
        PageResult rsult = brandService.findPageBrand(page, size, brand);
        return rsult;
    }

    @RequestMapping("addBrand")
    @ResponseBody
    public Integer addBrand(@RequestBody Brand brand){
        try {
            brandService.insertBrand(brand);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }

    @RequestMapping("findOne")
    @ResponseBody
    public Brand findOne(Long id){
        return brandService.findOne(id);
    }

    @RequestMapping("updateBrand")
    @ResponseBody
    public Integer updateBrand(@RequestBody Brand brand){
        try{
            brandService.updateBrand(brand);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }

    @RequestMapping("delBrand")
    @ResponseBody
    public Integer delBrand(@RequestBody Long[] ids){
        try{
            brandService.deleteBrand(ids);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }
}
