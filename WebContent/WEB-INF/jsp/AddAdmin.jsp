<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>系统用户录入界面</title>
<meta name="viewport" content="width=device-width,initial-scale=1.0,user-scalable=no">
<link rel="stylesheet" href="${pageContext.request.contextPath}/js/bootstrap.min.css">
<link href="iconfont/style.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>

<script type="text/javascript">
	var tx=document.getElementByName("tx");
	alert(tx);
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
            <h2 class="mg-b20 text-warning text-center" style="padding-top: 5px;">系统用户页面</h2>
            <div class="col-sm-8 col-md-5 center-auto pd-sm-50 pd-xs-20 main_content">
                <p class="text-warning text-center">增加系统用户</p>
                <form action="${pageContext.request.contextPath }/admin/saveAdmin.action" method="post">
                    <div class="form-group mg-t20">
                        <i class="icon-user icon_font"></i>
                        <input type="text" class="login_input" id="username" name="username" placeholder="用户账号"  required="required"/>
                    </div>
                    
                    <div class="form-group mg-t20">
                        <i class="icon-user icon_font"></i>
                        <input type="text" class="login_input" id="password" name="password" placeholder="用户密码"  required="required"/>
                    </div>
                    
                  <div class="form-group mg-t20" style="height: 40px;">
                        <i class="icon-user icon_font" style=""></i>
						      <select class="login_input form-control" id="role" name="role">
						        <option value="1">聚一培训</option>
						        <option value="2">聚一培训学员录入</option>
						        <option value="3">婚礼预定</option>
						        <option value="6">主管</option>
						      </select>
						
                    </div>
                  
                    <div class="checkbox mg-b25">
                        <span  class="toast"></span>
                    </div>
                    <button style="submit" class="login_btn">增加系统用户</button>
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
			
		})
		
		
	})
</script>
</html>