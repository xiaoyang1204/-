<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <title>聚一培训学院 - 登录</title>
    <link href="${pageContext.request.contextPath}/js/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/js/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/js/animate.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/js/style.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/js/login.min.css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.js"></script>

    <script>
        if(window.top!==window.self){
        window.top.location=window.location;
        };
        
        $(function(){
	        	var v='${prompt}';
	        	if(v!=''){
	        	alert(v);
       	 }
        });
          
     
    </script>

</head>

<body class="signin">
    <div class="signinpanel">
        <div class="row">
            <div class="col-sm-7">
                <div class="signin-info">
                    <div class="logopanel m-b">
                        <p style="color: black;font-size: 50px;">JuYi</p>
                    </div>
                    <div class="m-b"></div>
                </div>
            </div>
            <div class="col-sm-5">
                <form method="post" action="${pageContext.request.contextPath }/admin/findAdmin.action">
                    <h4 class="no-margins" style="color: black;">登录：</h4><span style="color: red;"><c:if test="${ts==1}">密码错误,请重新输入</c:if></span>
                    <input type="text" name="username" class="form-control uname" placeholder="用户名" />
                    <input type="password" name="password" class="form-control pword m-b" placeholder="密码" />
                    <strong style="color: black;">忘记密码? 请联系管理员!</strong>
                    <button class="btn btn-success btn-block">登录</button>
                </form>
            </div>
        </div>
        <div class="signup-footer">
            <div class="pull-left" style="color: black;">
                &copy; 2018 All Rights Reserved. JY
            </div>
        </div>
    </div>
</body>
</html>