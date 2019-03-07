package com.juyi.service;


	
import com.juyi.model.Page;
import com.juyi.model.User;
/**
 * 聚一
 * @author Admin
 *
 */
public interface UserService {
		/**
		 * 保存一个用户信息
		 * @param user
		 * @return
		 */
		public Integer saveUser(User user);
		/**
		 * 查询所有
		 * @param pageNum
		 * @return
		 */
		public Page findAllUser(String pageNum);
		
		/**
		 * 删除一个或者多个用户
		 * @param uid
		 * @return
		 */
		int deleteUser(Integer[] uid);
	}



