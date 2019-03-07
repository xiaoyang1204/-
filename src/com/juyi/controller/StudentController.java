package com.juyi.controller;


import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.juyi.model.Page;
import com.juyi.model.Student;
import com.juyi.service.StudentService;

@Controller
@RequestMapping("student")
public class StudentController {
	@Autowired
	private  StudentService studentService;
	
	/**
	 * 保存学员信息
	 * @param student
	 * @return
	 */
	@RequestMapping("saveStudent")
	public String saveStudent(Student student) {
		Integer stu = studentService.saveStudent(student);
		if(stu>0) {
			return "redirect:/student/findAllStudent.action?tx=1";
		}
			return "redirect:/show/entering.action?tx=2";
	}
	/**
	 * 展示所有学员信息
	 * @param model
	 * @param pageNum
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("/findAllStudent")
	public String findAllStudent(Model model,String pageNum,HttpServletRequest request) throws UnsupportedEncodingException {
		String StudentName = request.getParameter("StudentName");
		 
		try {
			if(pageNum==null||pageNum.equals("")) {
				pageNum = "1";
			}
		} catch (Exception e) {
			pageNum = "1";
		}
		if(StudentName != null) {
			StudentName=new String(StudentName.getBytes("iso-8859-1"),"UTF-8");
			model.addAttribute("name", StudentName);				
		}
		request.setAttribute("pageNum",pageNum);
		Page page = studentService.findAllStudent(pageNum,StudentName);	
		page.setServletUrl("/student/findAllStudent.action");
		model.addAttribute("page", page);
		return "StudentList";
	}
	
	/**
	 * 删除一个或者多个学员
	 * @param tid
	 * @return
	 */
	@RequestMapping("/deleteStudent")
	public String deleteStudent(Integer[] tid) {
		Integer deleteStudent = studentService.deleteStudent(tid);
		if(deleteStudent > 0) {
			return "redirect:/student/findAllStudent.action";
		}
		return "redirect:/student/findAllStudent.action";
	}
	
	/**
	 * 展示修改页
	 * @return
	 */
	@RequestMapping("/amendStudebnt")
	public String amendStudebnt(Student student,Model model) {
		Student findStudent = studentService.findId(student);
		model.addAttribute("findStudent", findStudent);
		return "amendEntering";
	}
	/**
	 * 修改一个学员
	 * @param student
	 * @return
	 */
	@RequestMapping("/updateStudent")
	public String updateStudent(Student student) {
		Integer updateStudent = studentService.updateStudent(student);
		if(updateStudent>0) {
			return "redirect:/student/findAllStudent.action";
		}
			return "redirect:/student/amendStudebnt.action";
	}
}
