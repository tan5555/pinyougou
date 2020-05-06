package com.kgc.pinyougou.service;

import com.kgc.pinyougou.domain.Specification;
import com.kgc.pinyougou.utils.PageResult;

import java.util.List;
import java.util.Map;

/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface SpecificationService {

	List<Map> findAllSpecification();

	/**
	 * @Author Admin
	 * @description:  //TODO
	 * @param:
	 * @param pageNum   分页页数
	 * @param pageSize  分页记录数
	 * @return: com.kgc.pinyougou.utils.PageResult
	 * @time: 2020/4/25 22:11
	 */
	PageResult findPageSpecification(Integer pageNum, Integer pageSize, Specification specification);

	Integer insertSpecification(Specification specification);

	Specification findOne(Long id);

	Integer updateSpecification(Specification specification);

	Integer deleteSpecification(Long [] ids);
}
