<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户录入信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
  </head>
  <style type="text/css">
<!--
.STYLE1 {
	font-size: 36px;
	font-weight: bold;
	margin-top: 100px;
}
-->
</style>
  <body style="background-image: url('images/467207.jpg');">
   <strong style="position: absolute; padding-left: 1500px;padding-top:20px;"></strong>
    	<div align="center" class="STYLE1">用户信息  </div> 
  	<div style="margin-left: 300x;" >
		<table style="text-align: center;margin-top: 50px;"  border="0" cellspacing="0" cellpadding="0"   height="400">
				<tr>
					<th width="500px" >序号</th>
					<th width="500px">用户名</th>
					<th width="500px">电话</th>
					<th width="500px">学习课程</th>
					<th width="500px">省份/城市/县区</th>
					<th width="500px;">类型</th>
					<th width="500px">创建时间</th>
				</tr>
					<c:forEach items="${page.records}" var="juyi" varStatus="stat">
						 <tr align="center">
							<td>${stat.count}</td>
							<td>${juyi.name}</td>
							<td>${juyi.tel}</td>
							<td>${juyi.course}</td>
							<td><c:if test="${juyi.province==null}">无  </c:if>
								<c:if test="${juyi.province!=null}">${juyi.province}
								-${juyi.city}-${juyi.area}</c:if></td>
							<td>${juyi.type}</td>
							<td>${juyi.dateTime}</td>
						</tr>
					</c:forEach>
					
					<tr align="center">
	               		<c:if test="${page.records.size()<=0 }">
	               		<td colspan="7">暂无数据</td>
	              		</c:if>
	               	</tr>
	               	<tr align="center">
		               	<c:if test="${page.records.size()>0 }">
		               		<td colspan="7"><%@include file="/page/page.jsp" %></td>
		               	</c:if>
	               	</tr>
		</table>
	</div>
  </body>
</html>
