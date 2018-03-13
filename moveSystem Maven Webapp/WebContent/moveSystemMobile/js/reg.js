(function() {
		//var username = $("#username");
		var password = $("#password");
		var phonenum = $("#phonenum");
		var valicode = $("#valicode");
		var recommend_p = $("#recommend_p");
		var cutdownFlag = true;

		$("#register_btn").click(function() {
			$("#modal").show();	
			$.ajax({
				type:"post",
				url: getAPIURL() + "/mobileLogin/register.do",
				dataType:'json',
				contentType: "application/json; charset=utf-8",
				data:$("#registerform").serialize(),
					headers : {
						'Content-Type' : 'application/x-www-form-urlencoded'
					},
					success:function(data){
						if(data.rtn==0)
						layer.open({
							content:"注册成功,账号为:"+data.account,
							btn:['去登陆', '取消'],
							yes: function(index){
								window.location.href = "../page/login.html";
							      layer.close(index);
							    }
						})
						$("#modal").hide();	
					}
			})
			
			
		});
	
			
//切换密码的可见状态
$(".icon_eye").click(function() {
var arr = this.src.split("/");
if(arr[arr.length - 1] == "bkj.png") {
	this.src = "../img/kj.png";
	$(this).prev().attr("type", "text");
} else {
	this.src = "../img/bkj.png";
	$(this).prev().attr("type", "password");
}

});
})();