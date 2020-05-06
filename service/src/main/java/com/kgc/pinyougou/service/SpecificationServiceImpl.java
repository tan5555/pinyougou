package com.kgc.pinyougou.service;

import com.kgc.pinyougou.domain.Specification;
import com.kgc.pinyougou.domain.SpecificationExample;
import com.kgc.pinyougou.domain.SpecificationOption;
import com.kgc.pinyougou.domain.SpecificationOptionExample;
import com.kgc.pinyougou.mapper.SpecificationMapper;
import com.kgc.pinyougou.mapper.SpecificationOptionMapper;
import com.kgc.pinyougou.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service(version = "1.0",interfaceClass = SpecificationService.class)
@Component
public class SpecificationServiceImpl implements SpecificationService {

	@Autowired(required = false)
	private SpecificationMapper specificationMapper;
	@Autowired(required = false)
	private SpecificationOptionMapper specificationOptionMapper;

	@Override
	public List<Map> findAllSpecification() {
		List<Map> map = specificationMapper.selectAllSpecification();
		return map;
	}

	@Override
	public PageResult findPageSpecification(Integer pageNum, Integer pageSize, Specification specification) {
		PageHelper.startPage(pageNum, pageSize);

		SpecificationExample example=new SpecificationExample();
		SpecificationExample.Criteria criteria = example.createCriteria();

		if(specification!=null){
			if(specification.getSpecName()!=null && specification.getSpecName().length()>0){
				criteria.andSpecNameLike("%"+specification.getSpecName()+"%");
			}

		}

		Page<Specification> page= (Page<Specification>)specificationMapper.selectByExample(example);
		return new PageResult(page.getTotal(), page.getResult());
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Integer insertSpecification(Specification specification) {
			specificationMapper.insert(specification);

			List<SpecificationOption> specificationOptionList = specification.getSpecificationOptionList();
			for (SpecificationOption specificationOption : specificationOptionList) {
				specificationOption.setSpecId(specification.getId());
			}
			specificationOptionMapper.insert(specificationOptionList);

			return 1;

	}

	@Override
	public Specification findOne(Long id) {
		Specification specification = specificationMapper.selectByPrimaryKey(id);

		SpecificationOptionExample example = new SpecificationOptionExample();
		SpecificationOptionExample.Criteria criteria = example.createCriteria();
		criteria.andSpecIdEqualTo(id);

		List<SpecificationOption> specificationOptionList = specificationOptionMapper.selectByExample(example);

		specification.setSpecificationOptionList(specificationOptionList);

		return specification;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Integer updateSpecification(Specification specification) {
		try{
			specificationMapper.updateByPrimaryKey(specification);

			//1.删除规格选项
			specificationOptionMapper.deleteBySpecId(specification.getId());

			//2.插入规格选项
			List<SpecificationOption> specificationOptionList = specification.getSpecificationOptionList();
			for (SpecificationOption specificationOption : specificationOptionList) {
				specificationOption.setSpecId(specification.getId());
			}
			specificationOptionMapper.insert(specificationOptionList);

			return 1;
		}catch (Exception e){
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Integer deleteSpecification(Long [] ids) {

		specificationOptionMapper.bulkDelete(ids);

		specificationMapper.bulkDelete(ids);
		return null;
	}
}
