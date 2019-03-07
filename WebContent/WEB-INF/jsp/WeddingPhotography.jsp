<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>系统所有用户</title>
<meta name="keywords" content="">
<meta name="description" content="">
<link rel="../shortcut icon" href="favicon.ico">
<link href="../css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
<link href="../css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
<link href="../css/plugins/iCheck/custom.css" rel="stylesheet">
<link href="../css/animate.min.css" rel="stylesheet">
<link href="../css/style.min.css?v=4.0.0" rel="stylesheet">
<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/layer/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/layer/mobile/layer.js"></script>
<script type="text/javascript">
	//删除时提示是否删除
	function de(){
		var chk_value = [];//定义一个数组
		//name是CheckBox的name属性定义的名称
		$('input[name="id"]:checked').each(function () {
			chk_value.push($(this).val());
		});
		//判断数组是否为空
		if (chk_value.length < 1) {
			alert("请选择删除的选项~");
			return false;
		}else{
		//提示信息是否删除
				var r=confirm("确定要删除么?");
				if(r==true){
					return true;
				}else{
					return false;
				}
		}
		
	}
	
	//单个删除
	function findDe(){
				var r=confirm("确定要删除么?");
				if(r==true){
					return true;
				}else{
					return false;
				}
	}
	
	//修改
	function updatewpg(){
				var r=confirm("确定要修改么?");
				if(r==true){
					return true;
				}else{
					return false;
				}
	}
	
	
	//模糊查询的时候  传一个nama
	function f1(){
		var name = $("#username").val().trim();
		
		if(name!=null){
			location.href = "${pageContext.request.contextPath}/wpg/findAllWeddingPhotography?keyword="+name;
		}
	}
	
             
            //全选 
            function CheckAll(){
				//设置全选
				 var div=document.getElementById('div');
				 var CheckBox=div.getElementsByTagName('input');
               for(i=0;i<CheckBox.length;i++){
                    if(CheckBox[i].checked==true){
                     	CheckBox[i].checked=false;
                     }else{
                   		  CheckBox[i].checked=true;
                    };
                };
            };
</script>
</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">

		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<div class="ibox-tools">
							<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
							</a> <a class="dropdown-toggle" data-toggle="dropdown"
								href="table_basic.html#"> <i class="fa fa-wrench"></i>
							</a>
						</div>
					</div>
					<div class="ibox-content">
					<!-- 搜索模块 -->
					<form>
						<div class="row">
							<div class="col-sm-3">
								<div class="input-group">
									<input type="text" placeholder="请输入关键词"
										class="input-sm form-control" name="sName" id="username" value="${name}" required="required"> 
										<span class="input-group-btn">
										<button type="button" class="btn btn-sm btn-primary" onclick="f1()">
											搜索</button>
									</span>
								</div>
							</div>
						</div>
						</form>
			  			<form action="${pageContext.request.contextPath}/wpg/deleteWeddingPhotography.action?id=${sysUser.id}" method="post"  >
						<div class="table-responsive" id ="div" >		
							<table class="table table-striped">
								<thead>
									<tr>
									<!-- 批量删除 -->
									<th><i class=".btn-rounded" >
									<input type="button" id="All" value="全选/全不选" onclick="CheckAll()" />
									<input  type="submit" id="delete" value="批量删除" onclick="return de()"/></i><th>
										<th>序号</th>
										<th>姓名</th>
										<th>手机号</th>
										<th>城市</th>
										<th>来源</th>
										<th>录入时间</th>
									</tr>
								</thead>
								<tbody>
									<c:choose>
										<c:when test="${not empty page}">
												<c:forEach items="${page.records}" var="wpg" varStatus="stat">
												<tr>
												<td><input type="checkbox" name="id" id ="id" value="${wpg.id }"></td>
													<td></td>
													<td>${stat.count}</td>
													<td>${wpg.name}</td>
													<td>${wpg.phone}</td>
													<td>${wpg.city}</td>
													<td>${wpg.identification}</td>
													<td>${wpg.datatime}</td>
													<!-- 用户的删除 -->
													<td>
													<a href="${pageContext.request.contextPath}/wpg/deleteWeddingPhotography.action?id=${wpg.id}" onclick="return findDe()" >
														<i class="fa fa-trash-o text-navy" >删除</i>
													</a></td>
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
										</c:when>
										<c:otherwise>
											<tr>
												<td colspan="100" >没有相关数据</td>
											</tr>
										</c:otherwise>
									</c:choose>
								</tbody>
							</table>
						</div>
				</form>
					</div>
				</div>
			</div>
		
		</div>
	</div>
	
	<script src="${pageContext.request.contextPath}/js/jquery.min.js?v=2.1.4"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js?v=3.3.5"></script>
	<script src="${pageContext.request.contextPath}/js/plugins/peity/jquery.peity.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/content.min.js?v=1.0.0"></script>
	<script src="${pageContext.request.contextPath}/js/plugins/iCheck/icheck.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/demo/peity-demo.min.js"></script>
	<script>
		$(document).ready(function() {
			$(".i-checks").iCheck({
				checkboxClass : "icheckbox_square-green",
				radioClass : "iradio_square-green",
			});
		});
	</script>
</body>
</html>