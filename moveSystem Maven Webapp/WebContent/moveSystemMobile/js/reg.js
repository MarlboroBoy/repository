(function() {
		//var username = $("#username");
		var password = $("#password");
		var phonenum = $("#phonenum");
		var valicode = $("#valicode");
		var recommend_p = $("#recommend_p");
		var cutdownFlag = true;

		$("#register_btn").click(function() {
					$("#modal").show();
					alert("123");
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