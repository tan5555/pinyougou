package com.kgc.pinyougou.mapper;

import com.kgc.pinyougou.domain.SpecificationOption;
import com.kgc.pinyougou.domain.SpecificationOptionExample;
import java.util.List;

public interface SpecificationOptionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(List<SpecificationOption> specificationOptionList);

    int insertSelective(SpecificationOption record);

    List<SpecificationOption> selectByExample(SpecificationOptionExample example);

    SpecificationOption selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SpecificationOption record);

    int updateByPrimaryKey(SpecificationOption record);

    int bulkDelete(Long [] ids);

    //通过specId删除
    int deleteBySpecId(Long id);
}