package com.kgc.pinyougou.service;

import com.kgc.pinyougou.domain.ItemCat;
import com.kgc.pinyougou.utils.PageResult;

import java.util.List;

/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface ItemCatService {

	/**
	 * @Author Admin
	 * @description:  //TODO
	 * @param:
	 * @param pageNum   分页页数
	 * @param pageSize  分页记录数
	 * @return: com.kgc.pinyougou.utils.PageResult
	 * @time: 2020/4/25 22:11
	 */
	PageResult findAllItemCat(Integer pageNum, Integer pageSize, ItemCat itemCat);

	List<ItemCat> findByParentId(Long id);

	Integer insertItemCat(ItemCat itemCat);

	ItemCat findOne(Long id);

	Integer updateItemCat(ItemCat itemCat);

	Integer deleteItemCat(Long [] ids);
}
