package com.kgc.pinyougou.service;

import com.github.pagehelper.Page;
import com.kgc.pinyougou.domain.SpecificationOption;
import com.kgc.pinyougou.domain.SpecificationOptionExample;
import com.kgc.pinyougou.mapper.SpecificationOptionMapper;
import com.kgc.pinyougou.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service(version = "1.0",interfaceClass = SpecificationOptionService.class)
@Component
public class SpecificationOptionServiceImpl implements SpecificationOptionService {

	@Autowired
	private SpecificationOptionMapper specificationOptionMapper;

	@Override
	public PageResult findAllSpecificationOption(Integer pageNum, Integer pageSize, SpecificationOption specificationOption) {
		PageHelper.startPage(pageNum, pageSize);

		SpecificationOptionExample example=new SpecificationOptionExample();
		SpecificationOptionExample.Criteria criteria = example.createCriteria();

		if(specificationOption!=null){
			if(specificationOption.getOptionName()!=null && specificationOption.getOptionName().length()>0){
				criteria.andOptionNameLike("%"+specificationOption.getOptionName()+"%");
			}

		}

		Page<SpecificationOption> page= (Page<SpecificationOption>)specificationOptionMapper.selectByExample(example);
		return new PageResult(page.getTotal(), page.getResult());
	}

	@Override
	public Integer insertSpecificationOption(List<SpecificationOption> specificationOptionList, Long specId) {
		for (SpecificationOption specificationOption : specificationOptionList) {
			specificationOption.setSpecId(specId);
		}
		return specificationOptionMapper.insert(specificationOptionList);
	}

	@Override
	public SpecificationOption findOne(Long id) {
		return specificationOptionMapper.selectByPrimaryKey(id);
	}

	@Override
	public Integer updateSpecificationOption(SpecificationOption specificationOption) {
		return specificationOptionMapper.updateByPrimaryKey(specificationOption);
	}

	@Override
	public Integer deleteSpecificationOption(Long [] ids) {
		specificationOptionMapper.bulkDelete(ids);
		return null;
	}
}
