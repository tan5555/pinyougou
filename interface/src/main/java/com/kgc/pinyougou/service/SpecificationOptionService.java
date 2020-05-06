package com.kgc.pinyougou.service;

import com.kgc.pinyougou.domain.SpecificationOption;
import com.kgc.pinyougou.utils.PageResult;

import java.util.List;

/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface SpecificationOptionService {

	/**
	 * @Author Admin
	 * @description:  //TODO
	 * @param:
	 * @param pageNum   分页页数
	 * @param pageSize  分页记录数
	 * @return: com.kgc.pinyougou.utils.PageResult
	 * @time: 2020/4/25 22:11
	 */
	PageResult findAllSpecificationOption(Integer pageNum, Integer pageSize, SpecificationOption specificationOption);

	Integer insertSpecificationOption(List<SpecificationOption> specificationOptionList, Long specId);

	SpecificationOption findOne(Long id);

	Integer updateSpecificationOption(SpecificationOption specificationOption);

	Integer deleteSpecificationOption(Long [] ids);
}
