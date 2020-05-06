package com.kgc.pinyougou.mapper;

import com.kgc.pinyougou.domain.Brand;
import com.kgc.pinyougou.domain.BrandExample;
import java.util.List;
import java.util.Map;

public interface BrandMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Brand record);

    int insertSelective(Brand record);

    List<Brand> selectByExample(BrandExample example);

    Brand selectByPrimaryKey(Long id);

    List<Map> selectAllBrand();

    int updateByPrimaryKeySelective(Brand record);

    int updateByPrimaryKey(Brand record);

    int bulkDelete(Long [] ids);
}