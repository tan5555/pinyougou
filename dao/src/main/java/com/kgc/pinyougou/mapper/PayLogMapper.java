package com.kgc.pinyougou.mapper;

import com.kgc.pinyougou.domain.PayLog;
import com.kgc.pinyougou.domain.PayLogExample;
import java.util.List;

public interface PayLogMapper {
    int deleteByPrimaryKey(String outTradeNo);

    int insert(PayLog record);

    int insertSelective(PayLog record);

    List<PayLog> selectByExample(PayLogExample example);

    PayLog selectByPrimaryKey(String outTradeNo);

    int updateByPrimaryKeySelective(PayLog record);

    int updateByPrimaryKey(PayLog record);
}