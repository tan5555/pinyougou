package com.kgc.pinyougou.mapper;

import com.kgc.pinyougou.domain.ItemCat;
import com.kgc.pinyougou.domain.ItemCatExample;
import java.util.List;

public interface ItemCatMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ItemCat record);

    int insertSelective(ItemCat record);

    List<ItemCat> selectByExample(ItemCatExample example);

    ItemCat selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ItemCat record);

    int updateByPrimaryKey(ItemCat record);

    int bulkDelete(Long [] ids);
}