<%@ page contentType="text/html;charset=UTF-8"%>
<%@include file="/common/views/common.jsp"%>
    <!DOCTYPE html>
   <html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>H+ 后台主题UI框架 - Bootstrap Table</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link rel="shortcut icon" href="favicon.ico"> 
    <link href="../../css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="../../css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="../../css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
    <link href="../../css/animate.css" rel="stylesheet">
    <link href="../../css/style.css?v=4.1.0" rel="stylesheet">
     <link rel="stylesheet" href="../../bootstrap3-dialog-master/dist/css/bootstrap-dialog.css"/>

</head>
<script>
$(function () {  
  $('#myTab a:last').tab('show');//初始化显示哪个tab  
  
  $('#myTab a').click(function (e) {  
    e.preventDefault();//阻止a链接的跳转行为  
    $(this).tab('show');//显示当前选中的链接及关联的content  
  })  
})  
    
</script>

<body class="gray-bg">
   
          
    <ul class="nav nav-tabs" role="tablist">    
  
  <li role="presentation" class="active"><a href="#home" role="tab" data-toggle="tab">Home</a></li>    <li role="presentation"><a href="#profile" role="tab" data-toggle="tab">Profile</a></li>  <li role="presentation"><a href="#messages" role="tab" data-toggle="tab">Messages</a></li>   <li role="presentation"><a href="#settings" role="tab" data-toggle="tab">Settings</a></li>  
  
</ul>     
  
<!-- 面板区 -->   
  
  
<div class="tab-content">    <div role="tabpanel" class="tab-pane active" id="home">...</div>    
  
  <div role="tabpanel" class="tab-pane" id="profile"><iframe src="alarmBasicListService.html" width="100%" scrolling="no" height="600px"></iframe></div>    
  
  <div role="tabpanel" class="tab-pane" id="messages">...</div>    
  
  <div role="tabpanel" class="tab-pane" id="settings">...</div>   
  
</div>  
</body>
</html>