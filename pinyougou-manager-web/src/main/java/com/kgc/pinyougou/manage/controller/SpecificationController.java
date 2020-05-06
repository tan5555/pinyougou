package com.kgc.pinyougou.manage.controller;

import com.kgc.pinyougou.domain.Specification;
import com.kgc.pinyougou.service.SpecificationOptionService;
import com.kgc.pinyougou.utils.PageResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.kgc.pinyougou.service.SpecificationService;

import java.util.List;
import java.util.Map;

/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/specification")
public class SpecificationController {

	@Reference(version = "1.0",interfaceClass = SpecificationService.class)
	private SpecificationService specificationService;

	@RequestMapping("findAllSpecification")
	@ResponseBody
	public List<Map> findAllSpecification(){
		List<Map> map = specificationService.findAllSpecification();
		return map;
	}

	@RequestMapping("findPageSpecification")
	@ResponseBody
	public PageResult findPageSpecification(Integer page, Integer size, @RequestBody Specification specification){
		PageResult rsult = specificationService.findPageSpecification(page, size, specification);
		return rsult;
	}

	@RequestMapping("addSpecification")
	@ResponseBody
	public Integer addSpecification(@RequestBody Specification specification){
		try {
			specificationService.insertSpecification(specification);

			return 1;
		}catch (Exception e){
			e.printStackTrace();
			return -1;
		}


	}

	@RequestMapping("findOne")
	@ResponseBody
	public Specification findOne(Long id){
		return specificationService.findOne(id);
	}

	@RequestMapping("updateSpecification")
	@ResponseBody
	public Integer updateSpecification(@RequestBody Specification specification){
		try {
			specificationService.updateSpecification(specification);

			return 1;
		}catch (Exception e){
			e.printStackTrace();
		}

		return -1;
	}

	@RequestMapping("delSpecification")
	@ResponseBody
	public Integer delSpecification(@RequestBody Long[] ids){
		try{
			specificationService.deleteSpecification(ids);
			return 1;
		}catch (Exception e){
			e.printStackTrace();
		}
		return -1;
	}
}
