package com.kgc.pinyougou.mapper;

import com.kgc.pinyougou.domain.Areas;
import com.kgc.pinyougou.domain.AreasExample;
import java.util.List;

public interface AreasMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Areas record);

    int insertSelective(Areas record);

    List<Areas> selectByExample(AreasExample example);

    Areas selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Areas record);

    int updateByPrimaryKey(Areas record);
}