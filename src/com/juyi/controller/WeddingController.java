package com.juyi.controller;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.juyi.model.Page;
import com.juyi.model.Wedding;
import com.juyi.service.WeddingService;
/**
 * 婚礼预约控制
 * @author Admin
 *
 */
@Controller
@RequestMapping("/wedding")
public class WeddingController {
	
	@Autowired
	private WeddingService weddingService;
	/**
	 * 保存一个用户预约信息
	 * @param wedding 婚礼类
	 * @param model	
	 * @param response
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@SuppressWarnings("static-access")
	@RequestMapping(value="/saveWedding",produces ="text/plain;charset=utf-8")
	@ResponseBody
	public String saveWedding(Wedding wedding,Model model,HttpServletResponse response,HttpServletRequest request) throws UnsupportedEncodingException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		JSONObject json = new JSONObject();
		String name = wedding.getName();
		String city = wedding.getCity();
		if(name!=null ) {
			name=new String(name.getBytes("ISO8859-1"), "UTF-8");		
		}
		if(city!=null ) {
			city=new String(city.getBytes("ISO8859-1"), "UTF-8");			
		}
		if(wedding.getPhone()!=null && wedding.getPhone() != "") {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date=new Date();
			String format = sdf.format(date);
			wedding.setName(name);
			wedding.setCity(city);
			wedding.setInputTime(format);
			weddingService.saveWedding(wedding);
			json.put("msg", 200);
			String jsonString = json.toJSONString(json);
			return jsonString;					
		}
			json.put("msg", 500);
			String jsonString = json.toJSONString(json);
			return jsonString;
	}
	
	/**
	 *婚博会 
	 * @param wedding
	 * @return
	 */
	@RequestMapping(value="/HunBoHui",produces ="text/plain;charset=utf-8")
	@ResponseBody
	public String HunBoHui(Wedding wedding) {
		JSONObject json = new JSONObject();
		if(wedding.getPhone() !=null && wedding.getPhone() != "") {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date=new Date();
			String format = sdf.format(date);
			wedding.setInputTime(format);
			weddingService.saveWedding(wedding);
			json.put("msg", 200);
			String jsonString = json.toJSONString(json);
			return jsonString;					
		}
			json.put("msg", 500);
			String jsonString = json.toJSONString(json);
			return jsonString;
	}
	
	
	/**
	 * 查询所有预约用户信息
	 * @param model
	 * @param pageNum
	 * @param request
	 * @return
	 */
	@RequestMapping("/findAllWedding")
	public String findAllWedding(Model model,String pageNum,HttpServletRequest request) {
		try {
			if(pageNum==null||pageNum.equals("")) {
				pageNum = "1";
			}
		} catch (Exception e) {
			pageNum = "1";
		}
		request.setAttribute("pageNum",pageNum);
		Page page = weddingService.findAllWedding(pageNum);
		page.setServletUrl("/wedding/findAllWedding.action");
		model.addAttribute("page", page);
		return "WeddingList";
	}
	/**
	 * 根据id删除一条信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteWedding")
	public String deleteWedding(Integer[] id) {
		Integer deleteWedding = weddingService.deleteWedding(id);
		if(deleteWedding>0) {
			return "redirect:/wedding/findAllWedding.action?tx=1";
		}
			return "redirect:/wedding/findAllWedding.action?tx=2";
	}	
}
