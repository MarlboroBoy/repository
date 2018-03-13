function alarm(){
	var AuserId  = localStorage.getItem("username");
	//定位地址
	//var localAdress
	var AalarmAdress = $('#alarmAdress').val();
	 var  AlicensePlate = $('#licensePlate').val();
	 var  Adescrib = $('#describ').val();
	 var AimgUrl = $('#describ').val();
	var alarmData =  JSON.stringify({
		licensePlate:AlicensePlate,
		 alarmAdress:AalarmAdress,
		 describ:Adescrib,
		 imgUrl:AimgUrl,
		 userid:AuserId
	      })
	  	$.ajax({
			type:"post",
			url: getAPIURL() + "/alarm/alarm.do",
			dataType:'json',
			contentType: "application/json; charset=utf-8",
			data:JSON.parse(alarmData),
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				},
				success:function(data){
					if(data._success==true){
					layer.open({
						content:'提交成功,如移车成功请及时处理',
						btn:'确定',
						yes: function(index){
						      location.reload();
						      layer.close(index);
						    }
								})
					}
				}
				
		})
		console.info();
		
	
	
}