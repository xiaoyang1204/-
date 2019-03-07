<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div  style="letter-spacing: 15px"><a href="${pageContext.request.contextPath}${page.servletUrl}?pageNum=1&name=${name}">首页</a>

	<a href="${pageContext.request.contextPath}${page.servletUrl}?name=${name}&pageNum=${page.pagenum<=1 ? 1:page.pagenum-1}">上一页</a>

	<c:forEach begin="${page.startPage }" end="${page.endPage }" var="cp">
		<a href="${pageContext.request.contextPath }${page.servletUrl}?pageNum=${cp}&name=${name}">${cp }页</a>
	</c:forEach>
	
	<a href="javaScript:void(0)">共${page.totalpage }页</a>
	
	<a href="${pageContext.request.contextPath}${page.servletUrl}?name=${name}&pageNum=${page.pagenum>=page.totalpage ? page.totalpage:page.pagenum+1}">下一页</a>


	<a href="${pageContext.request.contextPath}${page.servletUrl}?name=${name}&pageNum=${page.totalpage}">尾页</a>
	<input type="text" id="tiao" size="3"/><a href="javascript:void(0);" onclick="tiao()">&nbsp;跳转</a><br/>
</div>
<script type="text/javascript">
	function tiao(){
		var a=parseInt($("#tiao").val());
		var b=parseInt('${page.totalpage}');
		if(a >= 1 && a<=b){
			window.location="${pageContext.request.contextPath}${page.servletUrl}?name=${name}&pageNum="+a;
		}
	}
</script>

<style>
a {
	text-decoration:none;
}
</style>