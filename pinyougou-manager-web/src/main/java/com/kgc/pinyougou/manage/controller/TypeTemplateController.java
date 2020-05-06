package com.kgc.pinyougou.manage.controller;

import com.kgc.pinyougou.domain.TypeTemplate;
import com.kgc.pinyougou.utils.PageResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.dubbo.config.annotation.Reference;
import com.kgc.pinyougou.service.TypeTemplateService;

import java.util.List;

/**
 * controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/typeTemplate")
public class TypeTemplateController {

	@Reference(version = "1.0",interfaceClass = TypeTemplateService.class)
	private TypeTemplateService typeTemplateService;

	@RequestMapping("findAllTypeTemplate")
	@ResponseBody
	public List<TypeTemplate> findAllTypeTemplate(){
		List<TypeTemplate> rsult = typeTemplateService.findAllTypeTemplate();
		return rsult;
	}

	@RequestMapping("findPageTypeTemplate")
	@ResponseBody
	public PageResult findPageTypeTemplate(Integer page, Integer size, @RequestBody TypeTemplate TypeTemplate){
		PageResult rsult = typeTemplateService.findPageTypeTemplate(page, size, TypeTemplate);
		return rsult;
	}

	@RequestMapping("addTypeTemplate")
	@ResponseBody
	public Integer addTypeTemplate(@RequestBody TypeTemplate TypeTemplate){
		try {
			typeTemplateService.insertTypeTemplate(TypeTemplate);
			return 1;
		}catch (Exception e){
			e.printStackTrace();
		}
		return -1;
	}

	@RequestMapping("findOne")
	@ResponseBody
	public TypeTemplate findOne(Long id){
		return typeTemplateService.findOne(id);
	}

	@RequestMapping("updateTypeTemplate")
	@ResponseBody
	public Integer updateTypeTemplate(@RequestBody TypeTemplate TypeTemplate){
		try{
			typeTemplateService.updateTypeTemplate(TypeTemplate);
			return 1;
		}catch (Exception e){
			e.printStackTrace();
		}
		return -1;
	}

	@RequestMapping("delTypeTemplate")
	@ResponseBody
	public Integer delTypeTemplate(@RequestBody Long[] ids){
		try{
			typeTemplateService.deleteTypeTemplate(ids);
			return 1;
		}catch (Exception e){
			e.printStackTrace();
		}
		return -1;
	}
}
