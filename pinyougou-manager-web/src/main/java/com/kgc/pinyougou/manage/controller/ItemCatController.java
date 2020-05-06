package com.kgc.pinyougou.manage.controller;

import com.kgc.pinyougou.domain.ItemCat;
import com.kgc.pinyougou.utils.PageResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.kgc.pinyougou.service.ItemCatService;

import java.util.List;

/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/itemCat")
public class ItemCatController {

	@Reference(version = "1.0",interfaceClass = ItemCatService.class)
	private ItemCatService itemCatService;

	@RequestMapping("findAllItemCat")
	@ResponseBody
	public PageResult findAllItemCat(Integer page, Integer size, @RequestBody ItemCat itemCat){
		PageResult rsult = itemCatService.findAllItemCat(page, size, itemCat);
		return rsult;
	}

	@RequestMapping("findByParentId")
	@ResponseBody
	public List<ItemCat> findByParentId(Long parentId){
		return itemCatService.findByParentId(parentId);
	}

	@RequestMapping("addItemCat")
	@ResponseBody
	public Integer addItemCat(@RequestBody ItemCat itemCat){
		try {
			itemCatService.insertItemCat(itemCat);
			return 1;
		}catch (Exception e){
			e.printStackTrace();
		}
		return -1;
	}

	@RequestMapping("findOne")
	@ResponseBody
	public ItemCat findOne(Long id){
		return itemCatService.findOne(id);
	}

	@RequestMapping("updateBrand")
	@ResponseBody
	public Integer updateItemCat(@RequestBody ItemCat itemCat){
		try{
			itemCatService.updateItemCat(itemCat);
			return 1;
		}catch (Exception e){
			e.printStackTrace();
		}
		return -1;
	}

	@RequestMapping("delItemCat")
	@ResponseBody
	public Integer delItemCat(@RequestBody Long[] ids){
		try{
			itemCatService.deleteItemCat(ids);
			return 1;
		}catch (Exception e){
			e.printStackTrace();
		}
		return -1;
	}
	
}
