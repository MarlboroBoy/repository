(function() {
	var user = $("#user");
	var pwd = $("#pwd");

	function loginverify() {
		loading.open();
		var model = JSON.stringify({
			account : $.trim(user.val()),
			password : pwd.val()
		});
		console.info(model);
		model = JSON.parse(model);
		if (user.val() == "" || user.val().replace(/\s/g, "") == "") {
			loading.close();
			layer.open({
				content : "请输入用户名",
				btn : '确定'
			});
			return;
		}
		if (pwd.val() == "") {
			loading.close();
			layer.open({
				content : "请输入密码",
				btn : '确定'
			});
			return;
		}
		$
				.ajax({
					type : "POST",
					url : getAPIURL() + "/mobileLogin/login.do",
					dataType : "json",
					headers : {
						'Content-Type' : 'application/x-www-form-urlencoded'
					},
					contentType : "application/json",
					data : $('#login_form').serialize(),
					success : function(data) {
						if (data.rtn == 0) {
							localStorage.setItem("username", user.val());
							localStorage.setItem("token", data.token);
							loading.close();
							layer
									.open({
										content : '登录成功',
										skin : 'msg',
										time : 2 //2秒后自动关闭
										,
										end : function() {
											//判断直接从登录页进去，跳到个人中心
											console.info(history.length);
											if (history.length == 1) {
												window.location.href = "../page/index.html";
												return false;
											}
											if (window.location.search != "") {
												window.location.href = "../page/index.html";
											} else {
												var value = document.referrer;
												if (value.indexOf("login.html") != -1) {
													window.location.href = "../page/index.html";
													return;
												}
												if (!value) {
													window.location.href = "../page/index.html";
													return;
												}
												location.href = document.referrer;
												//解决safari不支持的问题//go(-1)ios不会刷新页面
												return false;
											}
										}
									});
						} else if (data.rtn == 1) {
							layer.open({
								content : '账号或密码错误,请重新登录',
								skin : 'msg',
								time : 1 //2秒后自动关闭
								,
								end : function() {
									//location.reload();
									//this.layer.close();
									$("#modal").css("display","none");
								}
							})
						}
					},
//					error : function(XMLHttpRequest, textStatus, errorThrown) {
//						loading.close();
//						if (XMLHttpRequest.status == 400) {
//							var obj = JSON.parse(XMLHttpRequest.responseText);
//							layer.open({
//								content : obj.Message,
//								btn : '确定'
//							});
//						}
//					}
				});
	}
	$(".login_btn").click(function() {
		loginverify();
	});
	//切换密码的可见状态
	$(".icon_eye").click(function() {
		var arr = this.src.split("/");
		if (arr[arr.length - 1] == "bkj.png") {
			this.src = "../img/kj.png";
			$(this).prev().attr("type", "text");
		} else {
			this.src = "../img/bkj.png";
			$(this).prev().attr("type", "password");
		}

	});

})();