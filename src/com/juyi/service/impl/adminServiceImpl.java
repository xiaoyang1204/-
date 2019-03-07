package com.juyi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juyi.dao.adminDao;
import com.juyi.model.Page;
import com.juyi.model.Student;
import com.juyi.model.admin;
import com.juyi.service.adminService;
/**
 * 登录
 * @author Admin
 *
 */
@Service
public class adminServiceImpl implements adminService {
	@Autowired
	private adminDao admindao;
	
	@Override
	public admin findAdmin(String username, String password) {
		return admindao.findAdmin(username, password);
	}

	@Override
	public int saveAdmin(admin admin) {
		return admindao.saveAdmin(admin);
	}

	@Override
	public int deleteAdmin(Integer[] aid) {
		return admindao.deleteAdmin(aid);
	}

	@Override
	public Page findAllAdmin(String pageNum) {
		Integer pagenum = 0;
		try {
			pagenum = Integer.valueOf(pageNum);
		}
		catch (Exception e){
			pagenum = 1;
		}
		Integer count = admindao.findAdminCount();
		Page page = new Page(pagenum,count);
		int m = page.getStartIndex();
		int n = page.getPagesize();
		List<admin> list = admindao.findAllAdmin(m, n);
		page.setRecords(list);
		return page;
	}
}
