package com.kgc.pinyougou.mapper;

import com.kgc.pinyougou.domain.Specification;
import com.kgc.pinyougou.domain.SpecificationExample;
import java.util.List;
import java.util.Map;

public interface SpecificationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Specification record);

    int insertSelective(Specification record);

    List<Specification> selectByExample(SpecificationExample example);

    Specification selectByPrimaryKey(Long id);

    List<Map> selectAllSpecification();

    int updateByPrimaryKeySelective(Specification record);

    int updateByPrimaryKey(Specification record);

    int bulkDelete(Long [] ids);
}