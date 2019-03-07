package com.juyi.service.impl;
/**
 * 聚一人才婚礼人培训官网预约
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juyi.dao.UserDao;
import com.juyi.model.Page;
import com.juyi.model.User;
import com.juyi.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userdao;
	
	@Override
	public Integer saveUser(User user) {
		return userdao.saveUser(user);
	}

	@Override
	public Page findAllUser(String pageNum) {
		Integer pagenum = 0;
		try {
			pagenum = Integer.valueOf(pageNum);
		}
		catch (Exception e){
			pagenum = 1;
		}
		int countPhone = userdao.findConuntUser();
		Page page = new Page(pagenum,countPhone);
		int m = page.getStartIndex();
		int n = page.getPagesize();
		List<User> list = userdao.findAllUser(m, n);
		page.setRecords(list);
		return page;
	}

	@Override
	public int deleteUser(Integer[] uid) {
		return userdao.deleteUser(uid);
	}
}
