package com.kgc.pinyougou.mapper;

import com.kgc.pinyougou.domain.Content;
import com.kgc.pinyougou.domain.ContentExample;
import java.util.List;

public interface ContentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Content record);

    int insertSelective(Content record);

    List<Content> selectByExample(ContentExample example);

    Content selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Content record);

    int updateByPrimaryKey(Content record);
}