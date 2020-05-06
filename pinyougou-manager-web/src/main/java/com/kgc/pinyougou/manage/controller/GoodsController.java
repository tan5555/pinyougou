package com.kgc.pinyougou.manage.controller;

import com.kgc.pinyougou.domain.Brand;
import com.kgc.pinyougou.domain.Goods;
import com.kgc.pinyougou.service.GoodsService;
import com.kgc.pinyougou.utils.PageResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

	@Reference(version = "1.0",interfaceClass = GoodsService.class)
	private GoodsService goodsService;

	@RequestMapping("findAllGoods")
	@ResponseBody
	public PageResult findAllBrand(Integer page, Integer size, @RequestBody Goods goods){
		PageResult rsult = goodsService.findAllGoods(page, size, goods);
		return rsult;
	}

	@RequestMapping("addGoods")
	@ResponseBody
	public Integer addGoods(@RequestBody Goods goods){
		try {
			goodsService.insertGoods(goods);
			return 1;
		}catch (Exception e){
			e.printStackTrace();
		}
		return -1;
	}

	@RequestMapping("findOne")
	@ResponseBody
	public Goods findOne(Long id){
		return goodsService.findOne(id);
	}

	@RequestMapping("updateGoods")
	@ResponseBody
	public Integer updateGoods(@RequestBody Goods goods){
		try{
			goodsService.updateGoods(goods);
			return 1;
		}catch (Exception e){
			e.printStackTrace();
		}
		return -1;
	}

	@RequestMapping("delGoods")
	@ResponseBody
	public Integer delBrand(@RequestBody Long[] ids){
		try{
			goodsService.deleteGoods(ids);
			return 1;
		}catch (Exception e){
			e.printStackTrace();
		}
		return -1;
	}
	
}
