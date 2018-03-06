<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<script type="text/javascript">
	var _ctx = "${ctx}";
</script>
<meta name="renderer" content="ie-stand">	
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- <meta http-equiv="X-UA-Compatible" content="IE=7,IE=9,IE=10" />	 -->
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<!--[if lt IE 9]>
    <script src="${ctx}/styles/extend/json2.js"></script>
<![endif]-->
<link rel="shortcut icon" href="${ctx}/common/favicon.ico">
    <link href="${ctx}/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${ctx}/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="${ctx}/css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
    <link href="${ctx}/css/animate.css" rel="stylesheet">
    <link href="${ctx}/css/style.css?v=4.1.0" rel="stylesheet">
    <link href="${ctx}/plugins/bootstrap3-dialog-master/css/bootstrap-dialog.css" rel="stylesheet">
    
    
    
 		<script src="${ctx}/js/jquery.min.js?v=2.1.4"></script>
		<script src="${ctx}/js/bootstrap.min.js?v=3.3.6"></script>
		<script src="${ctx}/js/plugins/metisMenu/jquery.metisMenu.js"></script>
		<script src="${ctx}/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
		<script src="${ctx}/js/plugins/layer/layer.min.js"></script>

		<!-- 自定义js -->
		<script src="${ctx}/js/hplus.js?v=4.1.0"></script>
		<script type="text/javascript" src="${ctx}/js/contabs.js"></script>

		<!-- 第三方插件 -->
		<script src="${ctx}/js/plugins/pace/pace.min.js"></script>
		
		
		<!-- Bootstrap table -->
    <script src="${ctx}/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
    <script src="${ctx}/js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
    <script src="${ctx}/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
		
	<script type="text/javascript" src="${ctx}/plugins/bootstrap3-dialog-master/js/bootstrap-dialog.js">

</script>	
<!-- 去掉ie下文本框右侧叉号及密码框右侧眼睛，因为可输入的下拉框中此叉号只能清空文本框内容不能取消下拉框选择 -->
<style>
        ::-ms-clear, ::-ms-reveal{display: none;}
</style>