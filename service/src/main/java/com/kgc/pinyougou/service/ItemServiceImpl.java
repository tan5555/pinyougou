package com.kgc.pinyougou.service;

import com.kgc.pinyougou.domain.Item;
import com.kgc.pinyougou.domain.ItemExample;
import com.kgc.pinyougou.mapper.ItemMapper;
import com.kgc.pinyougou.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Component;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service(version = "1.0",interfaceClass = ItemService.class)
@Component
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemMapper itemMapper;

	@Override
	public PageResult findAllItem(Integer pageNum, Integer pageSize, Item item) {
		PageHelper.startPage(pageNum, pageSize);

		ItemExample example=new ItemExample();
		ItemExample.Criteria criteria = example.createCriteria();

		if(item!=null){
			if(item.getTitle()!=null && item.getTitle().length()>0){
				criteria.andTitleLike("%"+item.getTitle()+"%");
			}
			if(item.getSellPoint()!=null && item.getSellPoint().length()>0){
				criteria.andSellPointLike("%"+item.getSellPoint()+"%");
			}
			if(item.getBarcode()!=null && item.getBarcode().length()>0){
				criteria.andBarcodeLike("%"+item.getBarcode()+"%");
			}
			if(item.getImage()!=null && item.getImage().length()>0){
				criteria.andImageLike("%"+item.getImage()+"%");
			}
			if(item.getStatus()!=null && item.getStatus().length()>0){
				criteria.andStatusLike("%"+item.getStatus()+"%");
			}
			if(item.getItemSn()!=null && item.getItemSn().length()>0){
				criteria.andItemSnLike("%"+item.getItemSn()+"%");
			}
			if(item.getIsDefault()!=null && item.getIsDefault().length()>0){
				criteria.andIsDefaultLike("%"+item.getIsDefault()+"%");
			}
			if(item.getSellerId()!=null && item.getSellerId().length()>0){
				criteria.andSellerIdLike("%"+item.getSellerId()+"%");
			}
			if(item.getCartThumbnail()!=null && item.getCartThumbnail().length()>0){
				criteria.andCartThumbnailLike("%"+item.getCartThumbnail()+"%");
			}
			if(item.getCategory()!=null && item.getCategory().length()>0){
				criteria.andCategoryLike("%"+item.getCategory()+"%");
			}
			if(item.getBrand()!=null && item.getBrand().length()>0){
				criteria.andBrandLike("%"+item.getBrand()+"%");
			}
			if(item.getSpec()!=null && item.getSpec().length()>0){
				criteria.andSpecLike("%"+item.getSpec()+"%");
			}
			if(item.getSeller()!=null && item.getSeller().length()>0){
				criteria.andSellerLike("%"+item.getSeller()+"%");
			}

		}

		Page<Item> page= (Page<Item>)itemMapper.selectByExample(example);
		return new PageResult(page.getTotal(), page.getResult());
	}

	@Override
	public Integer insertItem(Item item) {
		return itemMapper.insert(item);
	}

	@Override
	public Item findOne(Long id) {
		return itemMapper.selectByPrimaryKey(id);
	}

	@Override
	public Integer updateItem(Item item) {
		return itemMapper.updateByPrimaryKey(item);
	}

	@Override
	public Integer deleteItem(Long [] ids) {
		itemMapper.bulkDelete(ids);
		return null;
	}
	
}
