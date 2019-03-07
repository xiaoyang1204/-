package com.juyi.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.juyi.model.Page;
import com.juyi.model.admin;
/**
 * 登录账号
 * @author Admin
 *
 */
public interface adminService {

	public admin findAdmin(String username,String password);
	
	/**
	 * 增加一个用户
	 * @param admin
	 * @return
	 */
	int saveAdmin(admin admin);
	
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
	Page findAllAdmin(String pageNum);

}
