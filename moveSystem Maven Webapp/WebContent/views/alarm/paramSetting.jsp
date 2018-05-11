<%@ page contentType="text/html;charset=UTF-8"%>
<%@include file="/common/views/common.jsp"%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>H+ 后台主题UI框架 - Bootstrap Table</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

</head>
<script type="text/javascript">
$(document).ready(function() {
	var workType="${workType}";	
	if(workType!=null&&workType!=''&&workType=='automatic'){
	
	$("#workType1").attr("checked",true);
	}else if(workType!=null&&workType!=''&&workType=='manual')
		$("#workType2").attr("checked",true);

		

  
	$.ajax({
        type: "post",
        url: "${ctx}/message/getAll.do",
        data:"123",
        dataType: 'JSON',
        success: function (userList) {
        	  var unitObj=document.getElementById("messageId"); 
        	  //页面上的<html:select>元素
        	  if(userList!=null){ //后台传回来的select选项
                  for(var i=0;i<userList.length;i++){
                      //遍历后台传回的结果，一项项往select中添加option
                      unitObj.options.add(new Option(userList[i].title,userList[i].messageId));
                  }
              }
        },
        error: function () {
     	   $.showErr('');
        },
        complete: function () {
     
        }

    });
  
  
});

function sendParam(){
	var workType = $('input[name="workType"]:checked ').val()
	//var workType =$('input[type=radio][name=]').val();
	var resendTimes = $('#resendTimes').val();
	var timeOut = $('#timeOut').val();
	var messageId = $('#messageId').val();
	var callTimeOut =$('#callTimeOut').val() ;
	var callTimes = $('#callTimes').val();
	var callTimeLater=$('#callTimeLater').val();
	var data={"resendTimes":resendTimes,"timeOut":timeOut,"messageId":messageId,"workType":workType,"callTimeOut":callTimeOut,"callTimes":callTimes,"callTimeLater":callTimeLater};	
	$.ajax({
	           type: "post",
	           url: "${ctx}/paramSetting/setting.do",
	           data: data,
	           dataType: 'JSON',
	           success: function (data, status) {
	               if (status == "success") {
	                   $.showSuccessTimeout('设置成功',1000);
	               }
	           },
	           error: function () {
	        	   $.showErr('设置失败,请联系管理员');
	           },
	           complete: function () {
	        
	           }

	       });
}



</script>
<body class="gray-bg">
   
             <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5><small>系统参数设置</small></h5>
                       </div>
                    <div class="ibox-content">
                        <form  class="form-horizontal">
                        	 <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">当前系统的工作模式
                                    <br/>
                                    <br />
                                    <small class="text-navy"></small>
                                </label>

                                <div class="col-sm-8">
                      
                                    <div class="radio">
                                        <label>
                                            <input type="radio"  value="automatic" id="workType1" name="workType">自动处理模式</label>
                                    </div>
                                    <div class="radio">
                                        <label>
                                            <input type="radio"  value="manual" id="workType2" name="workType">手动处理模式</label>
                                    </div>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">系统信息发送失败重新发送次数</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" id = "resendTimes" name="resendTimes" value="${resendTimes}"> <span class="help-block m-b-none"></span>
                                </div>
                            </div>
                           <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">系统信息发送失败重新间隔时间</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" id = "timeOut" name="timeOut" value="${timeOut}">
                                </div>
                            </div>
                         
                            <div class="hr-line-dashed"></div>
                             <div class="form-group">
                                <label class="col-sm-2 control-label">回访报警人延迟时间</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" id = "callTimeLater" name="callTimeLater" value="${callTimeLater}">
                                </div>
                            </div>
                         
                            <div class="hr-line-dashed"></div>
                          
                          <div class="form-group">
                                <label class="col-sm-2 control-label">回访报警人次数</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" id = "callTimes" name="callTimes" value="${callTimes}">
                                </div>
                            </div>
                         
                            <div class="hr-line-dashed"></div>
                         
                          <div class="form-group">
                                <label class="col-sm-2 control-label">回访报警人时间间隔</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" id = "callTimeOut" name="callTimeOut" value="${callTimeOut}">
                                </div>
                            </div>
                         
                            <div class="hr-line-dashed"></div>
                         
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">选择信息发送模板</label>

                                <div class="col-sm-8">
                                    <select class="form-control m-b" name="messageId" id="messageId">
                                       
                                    </select>

                                   
                                </div>
                            </div>
                            
                            <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-2">
                                    <button class="btn btn-primary" type="button" onclick="sendParam()">保存内容</button>
                                    <button class="btn btn-white" type="reset">重置</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    


    <!-- 自定义js -->
    <script src="../js/content.js?v=1.0.0"></script>



</body>

</html>
