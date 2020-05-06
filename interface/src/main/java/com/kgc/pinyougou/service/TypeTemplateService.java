package com.kgc.pinyougou.service;

import com.kgc.pinyougou.domain.TypeTemplate;
import com.kgc.pinyougou.utils.PageResult;

import java.util.List;

/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface TypeTemplateService {

	List<TypeTemplate> findAllTypeTemplate();

	/**
	 * @Author Admin
	 * @description:  //TODO
	 * @param:
	 * @param pageNum   分页页数
	 * @param pageSize  分页记录数
	 * @return: com.kgc.pinyougou.utils.PageResult
	 * @time: 2020/4/25 22:11
	 */
	PageResult findPageTypeTemplate(Integer pageNum, Integer pageSize, TypeTemplate typeTemplate);

	Integer insertTypeTemplate(TypeTemplate typeTemplate);

	TypeTemplate findOne(Long id);

	Integer updateTypeTemplate(TypeTemplate typeTemplate);

	Integer deleteTypeTemplate(Long [] ids);
}
