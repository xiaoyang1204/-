package com.juyi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.juyi.model.admin;
/**
 * 用户管理员接口
 * @author Admin
 *
 */
public interface adminDao {
	
	public admin findAdmin(@Param("username")String username,@Param("password")String password);
	
	/**
	 * 增加一个用户
	 * @param admin
	 * @return
	 */
	int saveAdmin(@Param("admin")admin admin);
	
	/**
	 * 删除一个用户
	 * @param aid
	 * @return
	 */
	int deleteAdmin(Integer[] aid);
	
	/**
	 * 查询所有的用户
	 * @return
	 */
	List<admin> findAllAdmin(@Param("m")int m,@Param("n")int n);
	
	/**
	 * 统计用户数量
	 * @return
	 */
	Integer findAdminCount();
}
