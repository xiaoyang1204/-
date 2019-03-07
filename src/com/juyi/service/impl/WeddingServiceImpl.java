package com.juyi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juyi.dao.WeddingDao;
import com.juyi.model.Page;
import com.juyi.model.Wedding;
import com.juyi.service.WeddingService;
/**
 * 婚礼
 * @author Admin
 *
 */
@Service
public class WeddingServiceImpl implements WeddingService {
	
	@Autowired
	private WeddingDao weddingDao;
	
	/**
	 * 保存一个预约婚礼人的信息
	 * @param wedding
	 * @return
	 */
	@Override
	public Integer saveWedding(Wedding wedding) {
		return weddingDao.saveWedding(wedding);
	}
	/**
	 * 查询所有预约人信息
	 * @return
	 */
	@Override
	public Page findAllWedding(String pageNum) {
		Integer pagenum = 0;
		try {
			pagenum = Integer.valueOf(pageNum);
		}
		catch (Exception e){
			pagenum = 1;
		}
		Integer countPhone = weddingDao.countWedding();
		Page page = new Page(pagenum,countPhone);
		int m = page.getStartIndex();
		int n = page.getPagesize();
		List<Wedding> list = weddingDao.findAllWedding(m, n);
		page.setRecords(list);
		return page;
	}

	/**
	 * 根据id删除预约人信息
	 */
	@Override
	public Integer deleteWedding(Integer[] id) {
		return weddingDao.deleteWedding(id);
	}


}
