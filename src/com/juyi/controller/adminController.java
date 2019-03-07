package com.juyi.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.juyi.model.Page;
import com.juyi.model.admin;
import com.juyi.service.adminService;

/**
 * @author Admin
 *
 */
@Controller
@RequestMapping("admin")
public class adminController {
	@Autowired
	private adminService adminservice;
	
	/**
	 * 显示登陆页面
	 * @return
	 */
	@RequestMapping("/login")
	public String showlogin(HttpServletRequest request,Model model) {
		String p = request.getParameter("ts");
		if(p!=null) {
			Integer p2 = Integer.valueOf(p);
			model.addAttribute("ts", p2);
		}
		return "login";
	}
	
	/**
	 * 登陆
	 * @param username 用户名
	 * @param password	密码
	 * @return 
	 */
	@RequestMapping("/findAdmin")
	public String findAdmin(String username,String password,HttpSession session,Model model) {
		admin admin = adminservice.findAdmin(username,password);
		session.setAttribute("admin",admin);
		if(admin!=null) {
			model.addAttribute("admin", admin);
			return "index";
		}else {
			Integer ts= 1;
			return "redirect:/admin/login.action?ts="+ts;
		}
	}

	
	
	/**
	 * 清空session
	 * @param session 	会话
	 * @param request	请求
	 * @param response  相应
	 * @throws ServletException  抛出异常
	 * @throws IOException		
	 */
	@RequestMapping("/exit")
	public void exitAdmin(HttpSession session,HttpServletRequest request,HttpServletResponse response ) throws ServletException, IOException {
		//admin admin = (com.juyi.model.admin) session.getAttribute("admin");
		//一重清除session中用户信息
		session.removeAttribute("admin");
		if(session.getAttribute("admin")==null) {
			request.getRequestDispatcher("../admin/login.action").forward(request, response);
		}else {
			//二重终止整个session会话
			session.invalidate();
			request.getRequestDispatcher("../admin/login.action").forward(request, response);
		}
	}
	
	/**
	 * 保存一个管理用户
	 * @param model
	 * @param admin
	 * @return
	 */
	@RequestMapping("/saveAdmin")
	public String saveAdmin(Model model,admin admin) {
		int i = adminservice.saveAdmin(admin);
		if(i < 0) {
			return "redirect:/admin/findAllAdmin.action?tx=1";
		}
		return "redirect:/admin/findAllAdmin.action?tx=2";
	}
	
	/**
	 * 删除一个或者多个用户
	 * @param model
	 * @param aid
	 * @return
	 */
	@RequestMapping("/deleteAdmin")
	public String deleteAdmin(Model model,Integer[] aid) {
		int i = adminservice.deleteAdmin(aid);
		if(i < 0) {
			return "redirect:/admin/findAllAdmin.action?tx=1";
		}
		return "redirect:/admin/findAllAdmin.action?tx=2";
	}
	
	/**
	 * 查询所有的用户
	 * @param model
	 * @param pageNum
	 * @param request
	 * @return
	 */
	@RequestMapping("/findAllAdmin")
	public String findAllAdmin(Model model , String pageNum , HttpServletRequest request) {
		try {
			if(pageNum==null||pageNum.equals("")) {
				pageNum = "1";
			}
		} catch (Exception e) {
			pageNum = "1";
		}
		request.setAttribute("pageNum",pageNum);
		Page page = adminservice.findAllAdmin(pageNum);	
		page.setServletUrl("/admin/findAllAdmin.action");
		model.addAttribute("page", page);
		return "AdminList";
	}
}
