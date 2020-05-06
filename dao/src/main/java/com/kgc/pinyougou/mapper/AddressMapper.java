package com.kgc.pinyougou.mapper;

import com.kgc.pinyougou.domain.Address;
import com.kgc.pinyougou.domain.AddressExample;
import java.util.List;

public interface AddressMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Address record);

    int insertSelective(Address record);

    List<Address> selectByExample(AddressExample example);

    Address selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);
}