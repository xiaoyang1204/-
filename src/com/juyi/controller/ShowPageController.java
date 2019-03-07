package com.juyi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("show")
public class ShowPageController {
	
	/**
	 * 展示查询所有页面
	 * @return
	 */
	@RequestMapping("/findUser")
	public String showJuyi() {
		return "redirect:/user/findAllUser.action";
	}
	
	/**
	 * 展示home页面
	 * @return
	 */
	@RequestMapping("/Home")
	public String showHome() {
		return "home";
	}
	
	/**
	 * 展示录入页面
	 * @return
	 */
	@RequestMapping("/entering")
	public String entering() {
		return "entering";
	}
	
	/**
	 * 展示所有学员页
	 * @return
	 */
	@RequestMapping("/StudentList")
	public String StudentList() {
		return "StudentList";
	}
	
	/**
	 * 展示系统管理页
	 * @return
	 */
	@RequestMapping("/AdminList")
	public String AdminList() {
		return "AdminList";
	}
	
	/**
	 * 展示增加系统用户页面
	 * @return
	 */
	@RequestMapping("/addAdmin")
	public String addAdmin() {
		return "AddAdmin";
	}
	
	/**
	 * 
	 * @描述:展示婚纱摄影页
	 * @方法名: showWeddingPhotography
	 * @return
	 * @返回类型 String
	 * @创建人 Admin
	 * @创建时间 2018年9月12日上午11:34:14
	 * @修改人 Admin
	 * @修改时间 2018年9月12日上午11:34:14
	 * @修改备注
	 * @since
	 * @throws
	 */
	@RequestMapping("/showWeddingPhotography")
	public String showWeddingPhotography() {
		return "WeddingPhotography";
	}
}
