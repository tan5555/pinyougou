package com.kgc.pinyougou.manage.controller;

import com.kgc.pinyougou.domain.Brand;
import com.kgc.pinyougou.domain.Seller;
import com.kgc.pinyougou.utils.PageResult;
import io.swagger.models.auth.In;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.kgc.pinyougou.service.SellerService;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/seller")
public class SellerController {

	@Reference(version = "1.0",interfaceClass = SellerService.class)
	private SellerService sellerService;

	@RequestMapping("findPageSeller")
	@ResponseBody
	public PageResult findPageSeller(Integer page, Integer size, @RequestBody Seller seller){
		PageResult rsult = sellerService.findAllSeller(page, size, seller);
		return rsult;
	}

	@RequestMapping("findOne")
	@ResponseBody
	public Seller findOne(String sellerId){
		return sellerService.findOne(sellerId);
	}

	@RequestMapping("updateStatus")
	@ResponseBody
	public Integer updateStatus( String sellerId,String status){
		try{
			sellerService.updateStatus(sellerId,status);
			return 1;
		}catch (Exception e){
			e.printStackTrace();
		}
		return -1;
	}

	@RequestMapping("delSeller")
	@ResponseBody
	public Integer delSeller(@RequestBody String[] ids){
		try{
			sellerService.deleteSeller(ids);
			return 1;
		}catch (Exception e){
			e.printStackTrace();
		}
		return -1;
	}
}
