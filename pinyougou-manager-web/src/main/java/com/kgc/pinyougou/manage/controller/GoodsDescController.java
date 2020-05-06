package com.kgc.pinyougou.manage.controller;

import com.kgc.pinyougou.domain.Brand;
import com.kgc.pinyougou.domain.GoodsDesc;
import com.kgc.pinyougou.service.GoodsDescService;
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
@RequestMapping("/goodsDesc")
public class GoodsDescController {

	@Reference(version = "1.0",interfaceClass = GoodsDescService.class)
	private GoodsDescService goodsDescService;

	@RequestMapping("findAllGoodsDesc")
	@ResponseBody
	public PageResult findAllGoodsDesc(Integer page, Integer size, @RequestBody GoodsDesc goodsDesc){
		PageResult rsult = goodsDescService.findAllGoodsDesc(page, size, goodsDesc);
		return rsult;
	}

	@RequestMapping("addGoodsDesc")
	@ResponseBody
	public Integer addBrand(@RequestBody GoodsDesc goodsDesc){
		try {
			goodsDescService.insertGoodsDesc(goodsDesc);
			return 1;
		}catch (Exception e){
			e.printStackTrace();
		}
		return -1;
	}

	@RequestMapping("findOne")
	@ResponseBody
	public GoodsDesc findOne(Long id){
		return goodsDescService.findOne(id);
	}

	@RequestMapping("updateGoodsDesc")
	@ResponseBody
	public Integer updateGoodsDesc(@RequestBody GoodsDesc goodsDesc){
		try{
			goodsDescService.updateGoodsDesc(goodsDesc);
			return 1;
		}catch (Exception e){
			e.printStackTrace();
		}
		return -1;
	}

	@RequestMapping("delGoodsDesc")
	@ResponseBody
	public Integer delGoodsDesc(@RequestBody Long[] ids){
		try{
			goodsDescService.deleteGoodsDesc(ids);
			return 1;
		}catch (Exception e){
			e.printStackTrace();
		}
		return -1;
	}
}
