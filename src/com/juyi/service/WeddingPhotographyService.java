package com.juyi.service;

import com.juyi.model.Page;
import com.juyi.model.WeddingPhotography;

public interface WeddingPhotographyService {
	
	int insertWeddingPhotography(WeddingPhotography weddingPhotography);
	
	int deleteWeddingPhotography(Integer[] id);

	Page findAllWeddingPhotography(Integer pageNum, String keyword);

}
