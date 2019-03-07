<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>录入界面</title>
<meta name="viewport" content="width=device-width,initial-scale=1.0,user-scalable=no">
<link rel="stylesheet" href="${pageContext.request.contextPath}/js/bootstrap.min.css">
<link href="iconfont/style.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
	var tx=document.getElementByName("tx");
	alert(tx);
	
	//修改
	function updateStudent(){
				var r=confirm("确定要修改么?");
				if(r==true){
					return true;
				}else{
					return false;
				}
	}
	

	
	
</script>

<style>
	body,html{width: 100%; height: 100%;} 
	body{ background:url(images/timg.jpg) no-repeat ;
	background-size: 100% 100%; 
		color:#fff; font-family:"微软雅黑"; font-size:14px;}
	.wrap1{position:absolute; top:0; right:0; bottom:0; left:0; margin:auto }/*把整个屏幕真正撑开--而且能自己实现居中*/
	.main_content{background:url(images/main_bg.png) repeat; margin-left:auto; margin-right:auto; text-align:left; float:none; border-radius:8px;}
	.form-group{position:relative;}
	.login_btn{display:block; background:#3872f6; color:#fff; font-size:15px; width:100%; line-height:50px; border-radius:3px; border:none; }
	.login_input{width:100%; border:1px solid #3872f6; border-radius:3px; line-height:40px; padding:2px 5px 2px 30px; background:none;}
	.icon_font{position:absolute; bottom:15px; left:10px; font-size:18px; color:#3872f6;}
	.font16{font-size:16px;}
	.mg-t20{margin-top:20px;}
	@media (min-width:200px){.pd-xs-20{padding:20px;}}
	@media (min-width:768px){.pd-sm-50{padding:50px;}}
	#grad {
	  background: -webkit-linear-gradient(#4990c1, #52a3d2, #6186a3); /* Safari 5.1 - 6.0 */
	  background: -o-linear-gradient(#4990c1, #52a3d2, #6186a3); /* Opera 11.1 - 12.0 */
	  background: -moz-linear-gradient(#4990c1, #52a3d2, #6186a3); /* Firefox 3.6 - 15 */
	  background: linear-gradient(#4990c1, #52a3d2, #6186a3); /* 标准的语法 */
	}
</style>

</head>

<body style="background-color:#B2DFEE;">
    
    <div class="container wrap1" style="height:800px;">
            <h2 class="mg-b20 text-warning text-center" style="padding-top: 5px;">聚一婚礼人才学院录入页面</h2>
            <div class="col-sm-8 col-md-5 center-auto pd-sm-50 pd-xs-20 main_content">
                <p class="text-warning text-center" >学员录入</p>
                <form action="${pageContext.request.contextPath }/student/updateStudent.action" method="post">
                    <div class="form-group mg-t20">
                        <i class="icon-user icon_font"></i>
                        <input type="text" class="login_input" id="name" name="StudentName" value="${findStudent.studentName}" placeholder="请输入姓名"  required="required"/>
                        <input type="hidden" name="sId" value="${findStudent.sId }"/>
                    </div>
                    <input type="hidden" id="fuxuan" value="${findStudent.curriculum}"/>
                 <!--  <div class="form-group mg-t20" style="height: 40px;">
                        <i class="icon-user icon_font" style=""></i>
						      <select class="login_input form-control" id="lesson" name="curriculum" value="">
						        <option >婚礼策划师</option>
						        <option >婚礼统筹师</option>
						      	<option >婚礼设计师</option>
						     	<option >花艺设计师</option>
						      	<option >礼仪主持人</option>
						     	<option >化妆造型师</option>
						     	<option >摄影师</option>
						     	<option >摄像师</option>
						      </select>
                    </div>--> 
                    
                    <div class="form-group mg-t20">
                        <i class="icon-user icon_font"></i>
                        <input type="text" class="login_input" id="bookNumber" name="CertificateNumber" value="${findStudent.certificateNumber}" placeholder="证书编号"  required="required"/>
                    </div>
                    <div class="form-group mg-t20">
                        <i class="icon-user icon_font"></i>
                        <input type="text" class="login_input" id="bookProve" name="certificate" value="${findStudent.certificate}" placeholder="证书证明" required="required" />
                    </div>
                    <div class="form-group mg-t20">
                        <i class="icon-user icon_font"></i>
                        <input type="text" class="login_input" id="trainTime" name="trainingTime" value="${findStudent.trainingTime}" placeholder="培训时间" required="required"/>
                    </div>
                    <div class="form-group mg-t20">
                        <i class="icon-user icon_font"></i>
                        <input type="text" class="login_input" id="proveTime" name="certificationDate" value="${findStudent.certificationDate}" placeholder="认证时间" required="required"/>
                    </div>
                    <div class="form-group mg-t20">
                        <i class="icon-user icon_font"></i>
                        <input type="text" class="login_input" id="idNumber" name="IDNumber" value="${findStudent.IDNumber}" placeholder="身份证号" required="required"/>
                    </div>
                    <div class="form-group mg-t20">
                        <i class="icon-user icon_font"></i>
                        <input type="text" class="login_input" id="SchoolWeb" name="school" value="${findStudent.school}" placeholder="学院网址" required="required"/>
                    </div>
                    <div class="checkbox mg-b25">
                        <span  class="toast"></span>
                    </div>
                    <button style="submit" class="login_btn" onclick="return updateStudent()">修改信息</button>
               </form>
        </div><!--row end-->
    </div><!--container end-->
           
</body>
<script type="text/javascript">
	$(function(){
		
		
		$(".login_input").blur(function(){
				if($(".login_input").val()==""){
					$(".toast").html("信息不能为空")
					
				}else{
					$(".toast").html("")
					
				}
		})
		
		$(".login_btn").click(function(){
			
			if($("#name").val()==""
			 
			 ||$("#lesson").val()==""
			 ||$("#bookNumber").val()==""
			 ||$("#bookProve").val()==""
			 ||$("#trainTime").val()==""
			 ||$("#proveTime").val()==""
			 ||$("#idNumber").val()==""
			 ||$("#SchoolWeb").val()==""){
					$(".toast").html("信息不能为空")
					
				}else{
					$(".toast").html("")
					
				}
//			if($("#name").val()==$(".login_btn").val()
//				==$("#lesson").val()==$("#bookNumber").val()==$("#bookProve").val()
//				==$("trainTime").val()==$("#proveTime").val()==$("#idNumber").val()==$("#SchoolWeb").val()==""){
//					$(".toast").html("信息不能为空")
//				
//			}else{
//				alert("ajax提交")
//			}
			
		})
		
		
	})
</script>
</html>