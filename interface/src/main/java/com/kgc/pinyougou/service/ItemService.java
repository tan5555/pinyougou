package com.kgc.pinyougou.service;

import com.kgc.pinyougou.domain.Item;
import com.kgc.pinyougou.utils.PageResult;

/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface ItemService {

	/**
	 * @Author Admin
	 * @description:  //TODO
	 * @param:
	 * @param pageNum   分页页数
	 * @param pageSize  分页记录数
	 * @return: com.kgc.pinyougou.utils.PageResult
	 * @time: 2020/4/25 22:11
	 */
	PageResult findAllItem(Integer pageNum, Integer pageSize, Item item);

	Integer insertItem(Item item);

	Item findOne(Long id);

	Integer updateItem(Item item);

	Integer deleteItem(Long [] ids);
}
