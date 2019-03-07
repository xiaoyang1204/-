package com.juyi.controller;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.juyi.model.Page;
import com.juyi.model.Student;
import com.juyi.model.User;
import com.juyi.service.StudentService;
import com.juyi.service.UserService;


@Controller
@RequestMapping("user")
public class UserController {
	/**
	 * 自动装配User接口类
	 */
	@Autowired
	private UserService userService;
	/**
	 * 自动装配student接口类
	 */
	@Autowired
	private  StudentService studentService;

	/**
	 * 保存一个用户
	 * @param user 用户类
	 * @param model 模型驱动
	 * @return
	 */
	@RequestMapping("saveUser")
	public String saveUser(User user,Model model) {
		//判断是否为空
		if(user.getTel() != null || !user.getTel().equals("")) {
			//类型
			String type="PC端";
			//日期转换
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date=new Date();
			String dateTime = sdf.format(date);
			//将类型和日期塞入user中
			user.setDateTime(dateTime);
			user.setType(type);
			//调用接口
			userService.saveUser(user);
			//返回数据 1代表成功
			return "redirect:http://sh.hunlipeixun.com/index.htm?tc=1";
		}
			//返回数据 2代表手机号为空  
			return "redirect:http://sh.hunlipeixun.com/index.htm?tc=2";
	}
	/**
	 * 展示所有
	 * @param model
	 * @param pageNum
	 * @return
	 */
	@RequestMapping("findAllUser")
	public String findAllUser(Model model,String pageNum,HttpServletRequest request) {	
		try {
			if(pageNum==null||pageNum.equals("")) {
				pageNum = "1";
			}
		} catch (Exception e) {
			pageNum = "1";
		}	
		request.setAttribute("pageNum",pageNum);
		Page page = userService.findAllUser(pageNum);	
		page.setServletUrl("/user/findAllUser.action");
		model.addAttribute("page", page);
		return "UserList";
	}
	
	/**
	 * 删除一个或者多个用户
	 * @param uid
	 * @return
	 */
	@RequestMapping("/deleteUser")
	public String deleteUser(Integer[] uid) {
		int i = userService.deleteUser(uid);
		if(i > 0) {
			return "redirect:/user/findAllUser";
		}
		return "redirect:/user/findAllUser";
	}
	
	/**
	 * 移动端
	 * @param model 模型驱动
	 * @param user 用户名
	 */
	@RequestMapping("App")
	@ResponseBody
	public void findAppUser(Model model,User user) {
			if(user.getTel() != null ||user.getTel().equals("")) {
				String type="移动端";
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date=new Date();
				String dateTime = sdf.format(date);
				user.setDateTime(dateTime);
				user.setType(type);
				userService.saveUser(user);
			}
	}	
	/**
	 * 查询学员信息
	 * @param student  	学园类
	 * @param response	响应
	 * @param request	请求
	 * @return			
	 * @throws UnsupportedEncodingException  捕捉空指针异常
	 */
	@RequestMapping(value="/selSname",produces ="text/plain;charset=utf-8")
	@ResponseBody
	public String findSname(Student student,HttpServletResponse response,HttpServletRequest request) throws UnsupportedEncodingException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		Student selstudent=null;
		try {
			selstudent= studentService.findSname(student);
		}catch (Exception e) {
			e.printStackTrace();
		}
		if(selstudent != null) {
			return JSON.toJSONString(selstudent);		
		}	
			return JSON.toJSONString(selstudent);
	}
}
