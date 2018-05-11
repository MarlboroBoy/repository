<%@ page contentType="text/html;charset=UTF-8"%>
<%@include file="/common/views/common.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

<title>H+ 后台主题UI框架 - 登录</title>
<meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
<meta name="description"
	content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">
<link href="${ctx}/css/bootstrap.min.css" rel="stylesheet">
<link href="${ctx}/css/font-awesome.css?v=4.4.0" rel="stylesheet">
<link href="${ctx}/css/animate.css" rel="stylesheet">
<link href="${ctx}/css/style.css" rel="stylesheet">
<link href="${ctx}/css/login.css" rel="stylesheet">
<!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
<script>
        if (window.top !== window.self) {
            window.top.location = window.location;
        }
    </script>
<script type="text/javascript">
    function login(){
    	var user =$('#userName').val();
    	var password = $('#password').val();
    	console.info(user+'         '+password);
    	
    		var model = JSON.stringify({
    			account : $.trim(user),
    			password :password
    		});
    		console.info(model);
    		model = JSON.parse(model);
    		if (user == "" || user.replace(/\s/g, "") == "") {
    			layer.open({
    				content : "请输入用户名",
    				btn : '确定'
    			});
    			return;
    		}
    		if (password == "") {
 
    			layer.open({
    				content : "请输入密码",
    				btn : '确定'
    			});
    			return;
    		}
    		$.ajax({
    					type : "POST",
    					url : "${ctx}/adminLogin/toLogin.do",
    					dataType : "json",
    					headers : {
    						'Content-Type' : 'application/x-www-form-urlencoded'
    					},
    					contentType : "application/json",
    					data : model,
    					success : function(data) {
    						if (data._msg == "登录成功") {
    							$.showSuccessTimeout('登录成功',1000);
    							window.location.href="${ctx}/adminLogin/login.do"
    									}
    						 else {
    							 $.showSuccessTimeout('密码错误',1000);
    							}
    						
    					},
//    				
    				});
    	
    	
    	
    }
    </script>

</head>

<body class="signin">
	<div class="signinpanel">
		<div class="row">
			<div class="col-sm-7">
				<div class="signin-info">
					<div class="logopanel m-b">
						<h1>智能移车管理系统</h1>
					</div>
					<div class="m-b"></div>


					<strong>如忘记密码请联系管理员？ </strong>
				</div>
			</div>
			<div class="col-sm-5">

				<h4 class="no-margins">登录：</h4>
				<p class="m-t-md">登录到智能移车后台</p>
				<input type="text" class="form-control uname" placeholder="用户名" name ="account"
					id="userName" /> <input type="password"
					class="form-control pword m-b" placeholder="密码" id="password" name="password"/> <a
					href=""></a>
				<button class="btn btn-success btn-block" onclick="login()" >登录</button>

			</div>
		</div>
		<div class="signup-footer">
			<div class="pull-left">&copy; 2015 All Rights Reserved. H+</div>
		</div>
	</div>
</body>

</html>


