package com.kgc.pinyougou.service;

import com.kgc.pinyougou.domain.ItemCat;
import com.kgc.pinyougou.domain.ItemCatExample;
import com.kgc.pinyougou.mapper.ItemCatMapper;
import com.kgc.pinyougou.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service(version = "1.0",interfaceClass = ItemCatService.class)
@Component
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired(required = false)
	private ItemCatMapper itemCatMapper;

	@Override
	public PageResult findAllItemCat(Integer pageNum, Integer pageSize, ItemCat itemCat) {
		PageHelper.startPage(pageNum, pageSize);

		ItemCatExample example=new ItemCatExample();
		ItemCatExample.Criteria criteria = example.createCriteria();

		if(itemCat!=null){
			if(itemCat.getName()!=null && itemCat.getName().length()>0){
				criteria.andNameLike("%"+itemCat.getName()+"%");
			}

		}

		Page<ItemCat> page= (Page<ItemCat>)itemCatMapper.selectByExample(example);
		return new PageResult(page.getTotal(), page.getResult());
	}

	@Override
	public List<ItemCat> findByParentId(Long id) {
		ItemCatExample example = new ItemCatExample();
		ItemCatExample.Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(id);
		List<ItemCat> itemCatList = itemCatMapper.selectByExample(example);
		return itemCatList;

	}

	@Override
	public Integer insertItemCat(ItemCat itemCat) {
		return itemCatMapper.insert(itemCat);
	}

	@Override
	public ItemCat findOne(Long id) {
		return itemCatMapper.selectByPrimaryKey(id);
	}

	@Override
	public Integer updateItemCat(ItemCat itemCat) {
		return itemCatMapper.updateByPrimaryKey(itemCat);
	}

	@Override
	public Integer deleteItemCat(Long [] ids) {
		itemCatMapper.bulkDelete(ids);
		return null;
	}
}
