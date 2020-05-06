package com.kgc.pinyougou.mapper;

import com.kgc.pinyougou.domain.FreightTemplate;
import com.kgc.pinyougou.domain.FreightTemplateExample;
import java.util.List;

public interface FreightTemplateMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FreightTemplate record);

    int insertSelective(FreightTemplate record);

    List<FreightTemplate> selectByExample(FreightTemplateExample example);

    FreightTemplate selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FreightTemplate record);

    int updateByPrimaryKey(FreightTemplate record);
}