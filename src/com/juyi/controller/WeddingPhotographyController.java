package com.juyi.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.juyi.model.Page;
import com.juyi.model.WeddingPhotography;
import com.juyi.service.WeddingPhotographyService;

@Controller
@RequestMapping("/wpg")
public class WeddingPhotographyController {
	
	@Autowired
	private WeddingPhotographyService weddingPhotographyService;
	
	@RequestMapping("/insertWeddingPhotography")
	@ResponseBody
	public String insertWeddingPhotography(WeddingPhotography weddingPhotography) {
		if(weddingPhotography.getPhone() != null && weddingPhotography.getPhone() != "") {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date=new Date();
			String dateTime = sdf.format(date);
			weddingPhotography.setDatatime(dateTime);
			int i = weddingPhotographyService.insertWeddingPhotography(weddingPhotography);
			if(i > 0) {
				return JSON.toJSONString("保存成功~");
			}
			return JSON.toJSONString("增加失败~");
		}
		return JSON.toJSONString("手机号不能为空~");
	}
	
	@RequestMapping("/findAllWeddingPhotography")
	public String findAllWeddingPhotography(Model model , Integer pageNum , HttpServletRequest request , String keyword) {
		String name = request.getParameter("keyword");
		if(pageNum == null) {
			pageNum = 1;
		}
		request.setAttribute("pageNum",pageNum);
		model.addAttribute("name", name);
		Page page = weddingPhotographyService.findAllWeddingPhotography(pageNum, keyword);
		page.setServletUrl("/wpg/findAllWeddingPhotography.action");
		model.addAttribute("page", page);
		return "WeddingPhotography";
	}

	@RequestMapping("/deleteWeddingPhotography")
	public String deleteWeddingPhotography(Integer[] id) {
		int i = weddingPhotographyService.deleteWeddingPhotography(id);
		if(i > 0) {
			return "redirect:/wpg/findAllWeddingPhotography";
		}
		return "redirect:/wpg/findAllWeddingPhotography";
	}
}
