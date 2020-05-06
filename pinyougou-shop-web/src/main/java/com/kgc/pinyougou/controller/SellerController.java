package com.kgc.pinyougou.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.kgc.pinyougou.domain.Seller;
import com.kgc.pinyougou.service.SellerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @Auther: 谭海亮
 * @Date: 2020/5/1 13:06
 * @Description:
 */
@Controller
@RequestMapping("seller")
public class SellerController {

    @Reference(version = "1.0",interfaceClass =SellerService.class)
    private SellerService sellerService;

    @RequestMapping("addSeller")
    @ResponseBody
    public Integer addSeller(@RequestBody Seller seller){
        try{
            seller.setStatus("0");
            seller.setCreateTime(new Date());
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            seller.setPassword(passwordEncoder.encode(seller.getPassword()));
            sellerService.insertSeller(seller);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }


}
