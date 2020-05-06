package com.kgc.pinyougou.service;

import com.kgc.pinyougou.domain.GoodsDesc;
import com.kgc.pinyougou.domain.GoodsDescExample;
import com.kgc.pinyougou.mapper.GoodsDescMapper;
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
@Service(version = "1.0",interfaceClass = GoodsDescService.class)
@Component
public class GoodsDescServiceImpl implements GoodsDescService {

	@Autowired
	private GoodsDescMapper goodsDescMapper;

	@Override
	public PageResult findAllGoodsDesc(Integer pageNum, Integer pageSize, GoodsDesc goodsDesc) {
		PageHelper.startPage(pageNum,pageSize);

		GoodsDescExample goodsDescExample = new GoodsDescExample();
		GoodsDescExample.Criteria criteria = goodsDescExample.createCriteria();
		if(goodsDesc.getIntroduction()!=null && goodsDesc.getIntroduction().length()>0){
			criteria.andIntroductionLike("%"+goodsDesc.getIntroduction()+"%");
		}
		if(goodsDesc.getSpecificationItems()!=null && goodsDesc.getSpecificationItems().length()>0){
			criteria.andSpecificationItemsLike("%"+goodsDesc.getSpecificationItems()+"%");
		}
		if(goodsDesc.getCustomAttributeItems()!=null && goodsDesc.getCustomAttributeItems().length()>0){
			criteria.andCustomAttributeItemsLike("%"+goodsDesc.getCustomAttributeItems()+"%");
		}
		if(goodsDesc.getItemImages()!=null && goodsDesc.getItemImages().length()>0){
			criteria.andItemImagesLike("%"+goodsDesc.getItemImages()+"%");
		}
		if(goodsDesc.getPackageList()!=null && goodsDesc.getPackageList().length()>0){
			criteria.andPackageListLike("%"+goodsDesc.getPackageList()+"%");
		}
		if(goodsDesc.getSaleService()!=null && goodsDesc.getSaleService().length()>0){
			criteria.andSaleServiceLike("%"+goodsDesc.getSaleService()+"%");
		}

		Page<GoodsDesc> page = (Page<GoodsDesc>) goodsDescMapper.selectByExample(goodsDescExample);
		return new PageResult(page.getTotal(),page.getResult());
	}

	@Override
	public Integer insertGoodsDesc(GoodsDesc goodsDesc) {
		return goodsDescMapper.insert(goodsDesc);
	}

	@Override
	public GoodsDesc findOne(Long id) {
		return goodsDescMapper.selectByPrimaryKey(id);
	}

	@Override
	public Integer updateGoodsDesc(GoodsDesc goodsDesc) {
		return goodsDescMapper.updateByPrimaryKey(goodsDesc);
	}

	@Override
	public Integer deleteGoodsDesc(Long [] ids) {
		goodsDescMapper.bulkDelete(ids);
		return null;
	}
	
}
