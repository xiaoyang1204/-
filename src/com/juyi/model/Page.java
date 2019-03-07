package com.juyi.model;

import java.util.List;

public class Page {

	private List<?> records;	
	private Integer pagesize = 10;
	private Integer pagenum;
	private Integer totalpage;
	private Integer startIndex;
	private Integer totalrecords;


	private Integer startPage;
	private Integer endPage;
	

	private String servletUrl;
	

	public Page(Integer pagenum,Integer totalrecords){
		this.pagenum = pagenum;
		this.totalrecords = totalrecords;
		startIndex = (pagenum-1)*pagesize;
		totalpage = totalrecords%pagesize==0?totalrecords/pagesize:(totalrecords/pagesize+1);
		if(totalpage<=9){
			startPage = 1;
			endPage = totalpage;
		}else{
			startPage = pagenum-4;
			endPage = pagenum+4;
			if(startPage<1){
				startPage = 1;
				endPage = 9;
			}
			if(endPage>totalpage){
				endPage = totalpage;
				startPage = totalpage-8;
			}
		}
	}
	
	
	public List<?> getRecords() {
		return records;
	}
	public void setRecords(List<?> records) {
		this.records = records;
	}
	public Integer getPagesize() {
		return pagesize;
	}
	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}
	public Integer getPagenum() {
		return pagenum;
	}
	public void setPagenum(Integer pagenum) {
		this.pagenum = pagenum;
	}
	public Integer getTotalpage() {
		return totalpage;
	}
	public void setTotalpage(Integer totalpage) {
		this.totalpage = totalpage;
	}
	public Integer getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}
	public Integer getTotalrecords() {
		return totalrecords;
	}
	public void setTotalrecords(Integer totalrecords) {
		this.totalrecords = totalrecords;
	}


	public Integer getStartPage() {
		return startPage;
	}


	public void setStartPage(Integer startPage) {
		this.startPage = startPage;
	}


	public Integer getEndPage() {
		return endPage;
	}


	public void setEndPage(Integer endPage) {
		this.endPage = endPage;
	}


	public String getServletUrl() {
		return servletUrl;
	}


	public void setServletUrl(String servletUrl) {
		this.servletUrl = servletUrl;
	}
}
