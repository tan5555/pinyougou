package com.kgc.pinyougou.mapper;

import com.kgc.pinyougou.domain.GoodsDesc;
import com.kgc.pinyougou.domain.GoodsDescExample;
import java.util.List;

public interface GoodsDescMapper {
    int deleteByPrimaryKey(Long goodsId);

    int insert(GoodsDesc record);

    int insertSelective(GoodsDesc record);

    List<GoodsDesc> selectByExample(GoodsDescExample example);

    GoodsDesc selectByPrimaryKey(Long goodsId);

    int updateByPrimaryKeySelective(GoodsDesc record);

    int updateByPrimaryKey(GoodsDesc record);

    int bulkDelete(Long [] ids);
}