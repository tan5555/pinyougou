package com.kgc.pinyougou.mapper;

import com.kgc.pinyougou.domain.Item;
import com.kgc.pinyougou.domain.ItemExample;
import java.util.List;

public interface ItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Item record);

    int insertSelective(Item record);

    List<Item> selectByExample(ItemExample example);

    Item selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKey(Item record);

    int bulkDelete(Long [] ids);
}