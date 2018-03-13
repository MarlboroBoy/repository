<%@ page contentType="text/html;charset=UTF-8"%>
<%@include file="/common/views/common.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<button id="a"></button>
</body>
<script type="text/javascript">
$('#a').click(){
	var link={  　　　　//jQuery的AJAX执行的配置对象

		      type:"GET",　　　　　　//设置请求方式，默认为GET，

		      async:true,　　　　　　//设置是否异步，默认为异步

		      url:"localhost:8090/moveSystem/longPolling/ajax.do",

		      dataType:"json",　　　　//设置期望的返回格式，因服务器返回json格式，这里将数据作为json格式对待

		      success:function (msg){
		          　　setTimeout("link()",300);

		      }　　　　　　　　　　　　　　//成功时的回调函数，处理返回数据，并且延时建立新的请求连接

		}

		$.ajax(link);
	
}

</script>


</html>