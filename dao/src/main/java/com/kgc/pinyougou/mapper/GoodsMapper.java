package com.kgc.pinyougou.mapper;

import com.kgc.pinyougou.domain.Goods;
import com.kgc.pinyougou.domain.GoodsExample;
import java.util.List;

public interface GoodsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Goods record);

    int insertSelective(Goods record);

    List<Goods> selectByExample(GoodsExample example);

    Goods selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    int bulkDelete(Long [] ids);
}