package com.juyi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.juyi.model.WeddingPhotography;

public interface WeddingPhotographyDao {
	
	int insertWeddingPhotography(@Param("weddingPhotography")WeddingPhotography weddingPhotography);
	
	List<WeddingPhotography> findAllWeddingPhotography(@Param("m")int m,@Param("n")int n , @Param("keyword")String keyword);
	
	Integer CountWeddingPhotography(@Param("keyword")String keyword);
	
	int deleteWeddingPhotography(Integer[] id);

}
