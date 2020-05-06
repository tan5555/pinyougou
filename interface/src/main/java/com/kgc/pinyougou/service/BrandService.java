package com.kgc.pinyougou.service;

import com.kgc.pinyougou.domain.Brand;
import com.kgc.pinyougou.utils.PageResult;

import java.util.List;
import java.util.Map;

/**
 * @Auther: 谭海亮
 * @Date: 2020/4/23 22:06
 * @Description:
 */

public interface BrandService {

    List<Map> findAllBrand();

    /**
     * @Author Admin
     * @description:  //TODO
     * @param:
     * @param pageNum   分页页数
     * @param pageSize  分页记录数
     * @return: com.kgc.pinyougou.utils.PageResult
     * @time: 2020/4/25 22:11
     */
    PageResult findPageBrand(Integer pageNum, Integer pageSize, Brand brand);

    Integer insertBrand(Brand brand);

    Brand findOne(Long id);

    Integer updateBrand(Brand brand);

    Integer deleteBrand(Long [] ids);
}
