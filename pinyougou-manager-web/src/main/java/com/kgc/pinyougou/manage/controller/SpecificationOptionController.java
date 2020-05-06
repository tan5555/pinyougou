package com.kgc.pinyougou.manage.controller;

import com.kgc.pinyougou.domain.SpecificationOption;
import com.kgc.pinyougou.utils.PageResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.kgc.pinyougou.service.SpecificationOptionService;

import java.util.List;

/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/specificationOption")
public class SpecificationOptionController {

	@Reference(version = "1.0",interfaceClass = SpecificationOptionService.class)
	private SpecificationOptionService specificationOptionService;

	@RequestMapping("findAllSpecificationOption")
	@ResponseBody
	public PageResult findAllSpecificationOption(Integer page, Integer size, @RequestBody SpecificationOption specificationOption){
		PageResult rsult = specificationOptionService.findAllSpecificationOption(page, size, specificationOption);
		return rsult;
	}

	@RequestMapping("addSpecificationOption")
	@ResponseBody
	public Integer addSpecificationOption(@RequestBody List<SpecificationOption> specificationOption, Long specId){
		try {
			specificationOptionService.insertSpecificationOption(specificationOption,specId);
			return 1;
		}catch (Exception e){
			e.printStackTrace();
		}
		return -1;
	}

	@RequestMapping("findOne")
	@ResponseBody
	public SpecificationOption findOne(Long id){
		return specificationOptionService.findOne(id);
	}

	@RequestMapping("updateSpecificationOption")
	@ResponseBody
	public Integer updateSpecificationOption(@RequestBody SpecificationOption specificationOption){
		try{
			specificationOptionService.updateSpecificationOption(specificationOption);
			return 1;
		}catch (Exception e){
			e.printStackTrace();
		}
		return -1;
	}

	@RequestMapping("delSpecificationOption")
	@ResponseBody
	public Integer delSpecificationOption(@RequestBody Long[] ids){
		try{
			specificationOptionService.deleteSpecificationOption(ids);
			return 1;
		}catch (Exception e){
			e.printStackTrace();
		}
		return -1;
	}
}
