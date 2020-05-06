package com.kgc.pinyougou.manage.controller;

import com.kgc.pinyougou.domain.Brand;
import com.kgc.pinyougou.domain.Item;
import com.kgc.pinyougou.service.BrandService;
import com.kgc.pinyougou.utils.PageResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.kgc.pinyougou.service.ItemService;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/item")
public class ItemController {

	@Reference(version = "1.0",interfaceClass = ItemService.class)
	private ItemService itemService;

	@RequestMapping("findAllItem")
	@ResponseBody
	public PageResult findAllItem(Integer page, Integer size, @RequestBody Item item){
		PageResult rsult = itemService.findAllItem(page, size, item);
		return rsult;
	}

	@RequestMapping("addItem")
	@ResponseBody
	public Integer addBrand(@RequestBody Item item){
		try {
			itemService.insertItem(item);
			return 1;
		}catch (Exception e){
			e.printStackTrace();
		}
		return -1;
	}

	@RequestMapping("findOne")
	@ResponseBody
	public Item findOne(Long id){
		return itemService.findOne(id);
	}

	@RequestMapping("updateItem")
	@ResponseBody
	public Integer updateItem(@RequestBody Item item){
		try{
			itemService.updateItem(item);
			return 1;
		}catch (Exception e){
			e.printStackTrace();
		}
		return -1;
	}

	@RequestMapping("delItem")
	@ResponseBody
	public Integer delItem(@RequestBody Long[] ids){
		try{
			itemService.deleteItem(ids);
			return 1;
		}catch (Exception e){
			e.printStackTrace();
		}
		return -1;
	}
}
