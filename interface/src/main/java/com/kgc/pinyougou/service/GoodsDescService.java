package com.kgc.pinyougou.service;

import com.kgc.pinyougou.domain.GoodsDesc;
import com.kgc.pinyougou.utils.PageResult;

/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface GoodsDescService {

	/**
	 * @Author Admin
	 * @description:  //TODO
	 * @param:
	 * @param pageNum   分页页数
	 * @param pageSize  分页记录数
	 * @return: com.kgc.pinyougou.utils.PageResult
	 * @time: 2020/4/25 22:11
	 */
	PageResult findAllGoodsDesc(Integer pageNum, Integer pageSize, GoodsDesc goodsDesc);

	Integer insertGoodsDesc(GoodsDesc goodsDesc);

	GoodsDesc findOne(Long id);

	Integer updateGoodsDesc(GoodsDesc goodsDesc);

	Integer deleteGoodsDesc(Long [] ids);
}
