package com.juyi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.juyi.model.Wedding;

/**
 * 婚礼
 * @author Admin
 *
 */
public interface WeddingDao {
	
	/**
	 * 保存一个预约婚礼人的信息
	 * @param wedding
	 * @return
	 */
	Integer saveWedding(@Param("wedding")Wedding wedding);
	/**
	 * 查询所有预约人信息
	 * @return
	 */
	List<Wedding> findAllWedding(@Param("m")int m,@Param("n")int n);
	/**
	 * 查询所有预约人的记录数
	 * @return
	 */
	Integer countWedding();
	/**
	 * 删除预约人信息
	 * @param id
	 * @return
	 */
	Integer deleteWedding(Integer[] id);	
}
