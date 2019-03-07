package com.juyi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juyi.dao.WeddingPhotographyDao;
import com.juyi.model.Page;
import com.juyi.model.WeddingPhotography;
import com.juyi.service.WeddingPhotographyService;

@Service
public class WeddingPhotographyServiceImpl implements WeddingPhotographyService{
	
	@Autowired
	private WeddingPhotographyDao weddingPhotographyDao;

	@Override
	public int insertWeddingPhotography(WeddingPhotography weddingPhotography) {
		return weddingPhotographyDao.insertWeddingPhotography(weddingPhotography);
	}

	@Override
	public Page findAllWeddingPhotography(Integer pageNum, String keyword) {
		Integer countWeddingPhotography = weddingPhotographyDao.CountWeddingPhotography(keyword);
		Page page = new Page(pageNum, countWeddingPhotography);
		List<WeddingPhotography> list = weddingPhotographyDao.findAllWeddingPhotography(page.getStartIndex(), page.getPagesize(), keyword);
		page.setRecords(list);
		return page;
	}


	@Override
	public int deleteWeddingPhotography(Integer[] id) {
		return weddingPhotographyDao.deleteWeddingPhotography(id);
	}

}
