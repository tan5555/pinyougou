package com.kgc.pinyougou.service;

import com.kgc.pinyougou.domain.Goods;
import com.kgc.pinyougou.utils.PageResult;

/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface GoodsService {

	/**
	 * @Author Admin
	 * @description:  //TODO
	 * @param:
	 * @param pageNum   分页页数
	 * @param pageSize  分页记录数
	 * @return: com.kgc.pinyougou.utils.PageResult
	 * @time: 2020/4/25 22:11
	 */
	PageResult findAllGoods(Integer pageNum, Integer pageSize, Goods goods);

	Integer insertGoods(Goods goods);

	Goods findOne(Long id);

	Integer updateGoods(Goods goods);

	Integer deleteGoods(Long [] ids);
}
