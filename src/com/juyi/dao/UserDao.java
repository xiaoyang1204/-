package com.juyi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.juyi.model.User;
/**
 * 用户接口
 * @author Admin
 *
 */
public interface UserDao {
	/**
	 * 保存一个用户
	 * @param user
	 * @return
	 */
	public Integer saveUser(User user);
	/**
	 * 查询所有
	 * @return
	 */
	public List<User> findAllUser(@Param("m")int m,@Param("n")int n);
	/**
	 * 查询一共多少数据
	 */
	public int findConuntUser();
	
	/**
	 * 删除一个或者多个用户
	 * @param uid
	 * @return
	 */
	int deleteUser(Integer[] uid);
}
