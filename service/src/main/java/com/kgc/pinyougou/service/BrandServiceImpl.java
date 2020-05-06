package com.kgc.pinyougou.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kgc.pinyougou.domain.Brand;
import com.kgc.pinyougou.domain.BrandExample;
import com.kgc.pinyougou.mapper.BrandMapper;
import com.kgc.pinyougou.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Auther: 谭海亮
 * @Date: 2020/4/23 22:13
 * @Description:
 */
@Service(version = "1.0",interfaceClass = BrandService.class)
@Component
public class BrandServiceImpl implements BrandService {

    @Autowired(required = false)
    private BrandMapper brandMapper;

    @Override
    public List<Map> findAllBrand() {
        List<Map> map = brandMapper.selectAllBrand();
        return map;
    }

    @Override
    public PageResult findPageBrand(Integer pageNum, Integer pageSize, Brand brand) {
        PageHelper.startPage(pageNum,pageSize);

        BrandExample brandExample = new BrandExample();
        BrandExample.Criteria criteria = brandExample.createCriteria();
        if (brand.getFirstChar()!=null && brand.getFirstChar().length()>0){
            criteria.andFirstCharEqualTo(brand.getFirstChar().toUpperCase());
        }
        if (brand.getName()!=null && brand.getName().length()>0){
            criteria.andNameLike("%"+brand.getName()+"%");
        }

        Page<Brand> page = (Page<Brand>) brandMapper.selectByExample(brandExample);
        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public Integer insertBrand(Brand brand) {
        return brandMapper.insert(brand);
    }

    @Override
    public Brand findOne(Long id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer updateBrand(Brand brand) {
        return brandMapper.updateByPrimaryKey(brand);
    }

    @Override
    public Integer deleteBrand(Long [] ids) {
        brandMapper.bulkDelete(ids);
        return null;
    }


}
