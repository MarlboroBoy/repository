function safechange() {
	var OldPwd = $("#txtOldPwd") ;
	var NewPwd = $("#txtNewPwd");
	var ReNewPwd = $("#txtReNewPwd");
	loading.open();
	if ($.trim(OldPwd.val()) == "") {
		loading.close();
		layer.open({
			content : '请输入原密码',
			btn : '我知道了'
		});
		return false;
	}
	if ($.trim(NewPwd.val()) == "") {
		loading.close();
		layer.open({
			content : '请输入新的密码！',
			btn : '我知道了'
		});
		return false;
	} else {
		//var pwdStr = $.trim(NewPwd.val()).split("");
		if (NewPwd.val().length < 6) {
			loading.close();
			layer.open({
				content : '密码长度在6-20个字符之间，不能有空格！',
				btn : '我知道了'
			});
			return false;
		} else {
			if ($.trim(NewPwd.val()).length < 6
					|| $.trim(NewPwd.val()).length > 20) {
				loading.close();
				layer.open({
					content : '密码长度在6-20个字符之间，不能有空格！',
					btn : '我知道了'
				});
				return false;
			}

		}
	}
	if ($.trim(ReNewPwd.val()) != $.trim(NewPwd.val())) {
		loading.close();
		layer.open({
			content : '确认密码与新密码不一致！',
			btn : '我知道了'
		});
		return false;
	}
	var account = localStorage.getItem("username");
	var data = {
		account : account,
		oldPassword : OldPwd,
		newPassword : NewPwd
	}
	$.ajax({
		type : "POST",
		url : getAPIURL() + "/mobileLogin/modifyPassword.do",
		data : data,
		dataType : 'json',
		cache : false,
		async : false,
		success : function(data) {
			loading.close();
			if (data.rtn == "1") {
				layer.open({
					content : '登录密码修改成功!',
					btn : [ '重新登录', '取消' ],
					yes : function() {
						window.location = '../page/login.html?login=true';
					},
					no : function() {
						window.location = '../page/safe_center.html';

					}
				});
			}
			if (data.rtn == "2") {
				layer.open({
					content : '原密码不正确！',
					btn : '我知道了'
				});
			}
			if (data.rtn == "3") {
				layer.open({
					content : '密码修改失败！',
					btn : '我知道了'
				});
			}
		},
		error : function(data) {
			loading.close();
			if (data.status == 404) {
				layer.open({
					content : "请求资源不存在",
					skin : 'msg',
					time : 2
				//2秒后自动关闭
				});
			} else {
				layer.open({
					content : JSON.parse(data.responseText).Message,
					skin : 'msg',
					time : 2
				//2秒后自动关闭
				});
			}
		},
		headers : {
			"Authorization" : "Bearer " + getTOKEN()
		}
	})

}
