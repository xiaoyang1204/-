package com.juyi.service;


import com.juyi.model.Page;
import com.juyi.model.Wedding;
/**
 * 婚礼
 * @author Admin
 *
 */
public interface WeddingService {

	/**
	 * 保存一个预约婚礼人的信息
	 * @param wedding
	 * @return
	 */
	Integer saveWedding(Wedding wedding);
	/**
	 * 查询所有预约人信息
	 * @return
	 */
	Page findAllWedding(String pageNum);
	/**
	 * 删除预约人信息
	 * @param id
	 * @return
	 */
    Integer deleteWedding(Integer[] id);
    

	 
	
}
