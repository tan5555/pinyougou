package com.kgc.pinyougou.service;

import com.github.pagehelper.Page;
import com.kgc.pinyougou.domain.Goods;
import com.kgc.pinyougou.domain.GoodsExample;
import com.kgc.pinyougou.mapper.GoodsMapper;
import com.kgc.pinyougou.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Component;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service(version = "1.0",interfaceClass = GoodsService.class)
@Component
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsMapper goodsMapper;

    @Override
    public PageResult findAllGoods(Integer pageNum, Integer pageSize, Goods goods) {
        PageHelper.startPage(pageNum, pageSize);

        GoodsExample example=new GoodsExample();
        GoodsExample.Criteria criteria = example.createCriteria();

        if(goods!=null){
            if(goods.getSellerId()!=null && goods.getSellerId().length()>0){
                criteria.andSellerIdLike("%"+goods.getSellerId()+"%");
            }
            if(goods.getGoodsName()!=null && goods.getGoodsName().length()>0){
                criteria.andGoodsNameLike("%"+goods.getGoodsName()+"%");
            }
            if(goods.getAuditStatus()!=null && goods.getAuditStatus().length()>0){
                criteria.andAuditStatusLike("%"+goods.getAuditStatus()+"%");
            }
            if(goods.getIsMarketable()!=null && goods.getIsMarketable().length()>0){
                criteria.andIsMarketableLike("%"+goods.getIsMarketable()+"%");
            }
            if(goods.getCaption()!=null && goods.getCaption().length()>0){
                criteria.andCaptionLike("%"+goods.getCaption()+"%");
            }
            if(goods.getSmallPic()!=null && goods.getSmallPic().length()>0){
                criteria.andSmallPicLike("%"+goods.getSmallPic()+"%");
            }
            if(goods.getIsEnableSpec()!=null && goods.getIsEnableSpec().length()>0){
                criteria.andIsEnableSpecLike("%"+goods.getIsEnableSpec()+"%");
            }
            if(goods.getIsDelete()!=null && goods.getIsDelete().length()>0){
                criteria.andIsDeleteLike("%"+goods.getIsDelete()+"%");
            }

        }

        Page<Goods> page= (Page<Goods>)goodsMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
	public Integer insertGoods(Goods goods) {
		return goodsMapper.insert(goods);
	}

	@Override
	public Goods findOne(Long id) {
		return goodsMapper.selectByPrimaryKey(id);
	}

	@Override
	public Integer updateGoods(Goods goods) {
		return goodsMapper.updateByPrimaryKey(goods);
	}

	@Override
	public Integer deleteGoods(Long [] ids) {
        goodsMapper.bulkDelete(ids);
		return null;
	}
	
}
