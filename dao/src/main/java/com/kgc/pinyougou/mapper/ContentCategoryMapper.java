package com.kgc.pinyougou.mapper;

import com.kgc.pinyougou.domain.ContentCategory;
import com.kgc.pinyougou.domain.ContentCategoryExample;
import java.util.List;

public interface ContentCategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ContentCategory record);

    int insertSelective(ContentCategory record);

    List<ContentCategory> selectByExample(ContentCategoryExample example);

    ContentCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ContentCategory record);

    int updateByPrimaryKey(ContentCategory record);
}