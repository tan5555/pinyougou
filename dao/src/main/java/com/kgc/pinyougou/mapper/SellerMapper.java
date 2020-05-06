package com.kgc.pinyougou.mapper;

import com.kgc.pinyougou.domain.Seller;
import com.kgc.pinyougou.domain.SellerExample;
import java.util.List;

public interface SellerMapper {
    int deleteByPrimaryKey(String sellerId);

    int insert(Seller record);

    int insertSelective(Seller record);

    List<Seller> selectByExample(SellerExample example);

    Seller selectByPrimaryKey(String sellerId);

    int updateByPrimaryKeySelective(Seller record);

    int updateByPrimaryKey(Seller record);

    int bulkDelete(String [] ids);
}