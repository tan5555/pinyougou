package com.kgc.pinyougou.mapper;

import com.kgc.pinyougou.domain.Provinces;
import com.kgc.pinyougou.domain.ProvincesExample;
import java.util.List;

public interface ProvincesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Provinces record);

    int insertSelective(Provinces record);

    List<Provinces> selectByExample(ProvincesExample example);

    Provinces selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Provinces record);

    int updateByPrimaryKey(Provinces record);
}