package com.kgc.pinyougou.service;

import com.kgc.pinyougou.domain.Seller;
import com.kgc.pinyougou.utils.PageResult;

/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface SellerService {

	/**
	 * @Author Admin
	 * @description:  //TODO
	 * @param:
	 * @param pageNum   分页页数
	 * @param pageSize  分页记录数
	 * @return: com.kgc.pinyougou.utils.PageResult
	 * @time: 2020/4/25 22:11
	 */
	PageResult findAllSeller(Integer pageNum, Integer pageSize, Seller seller);

	Integer insertSeller(Seller seller);

	Seller findOne(String id);

	Integer updateSeller(Seller seller);

	Integer updateStatus(String sellerId,String status);

	Integer deleteSeller(String [] ids);


}
