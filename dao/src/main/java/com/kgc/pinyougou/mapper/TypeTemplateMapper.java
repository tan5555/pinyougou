package com.kgc.pinyougou.mapper;

import com.kgc.pinyougou.domain.TypeTemplate;
import com.kgc.pinyougou.domain.TypeTemplateExample;
import java.util.List;

public interface TypeTemplateMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TypeTemplate record);

    int insertSelective(TypeTemplate record);

    List<TypeTemplate> selectByExample(TypeTemplateExample example);

    TypeTemplate selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TypeTemplate record);

    int updateByPrimaryKey(TypeTemplate record);

    int bulkDelete(Long [] ids);
}