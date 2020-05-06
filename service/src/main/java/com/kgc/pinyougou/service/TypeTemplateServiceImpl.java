package com.kgc.pinyougou.service;

import com.kgc.pinyougou.domain.TypeTemplate;
import com.kgc.pinyougou.domain.TypeTemplateExample;
import com.kgc.pinyougou.mapper.TypeTemplateMapper;
import com.kgc.pinyougou.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service(version = "1.0",interfaceClass = TypeTemplateService.class)
@Component
public class TypeTemplateServiceImpl implements TypeTemplateService {

	@Autowired(required = false)
	private TypeTemplateMapper typeTemplateMapper;

	@Override
	public List<TypeTemplate> findAllTypeTemplate() {
		return typeTemplateMapper.selectByExample(null);
	}

	@Override
	public PageResult findPageTypeTemplate(Integer pageNum, Integer pageSize, TypeTemplate typeTemplate) {
		PageHelper.startPage(pageNum, pageSize);

		TypeTemplateExample example=new TypeTemplateExample();
		TypeTemplateExample.Criteria criteria = example.createCriteria();

		if(typeTemplate!=null){
			if(typeTemplate.getName()!=null && typeTemplate.getName().length()>0){
				criteria.andNameLike("%"+typeTemplate.getName()+"%");
			}
		}

		Page<TypeTemplate> page= (Page<TypeTemplate>)typeTemplateMapper.selectByExample(example);
		return new PageResult(page.getTotal(), page.getResult());
	}

	@Override
	public Integer insertTypeTemplate(TypeTemplate typeTemplate) {
		return typeTemplateMapper.insert(typeTemplate);
	}

	@Override
	public TypeTemplate findOne(Long id) {
		return typeTemplateMapper.selectByPrimaryKey(id);
	}

	@Override
	public Integer updateTypeTemplate(TypeTemplate typeTemplate) {
		return typeTemplateMapper.updateByPrimaryKey(typeTemplate);
	}

	@Override
	public Integer deleteTypeTemplate(Long [] ids) {
		typeTemplateMapper.bulkDelete(ids);
		return null;
	}
}
