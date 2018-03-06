<%@ page contentType="text/html;charset=UTF-8"%>
<%@include file="/common/views/common.jsp"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>H+ 后台主题UI框架 - Bootstrap Table</title>
<meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
<meta name="description"
	content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">


</head>
<script>
		$(function() {
			$('#myTab a:last').tab('show'); //初始化显示哪个tab  

			$('#myTab a').click(function(e) {
				e.preventDefault(); //阻止a链接的跳转行为  
				$(this).tab('show'); //显示当前选中的链接及关联的content  
			})
		})
	</script>

<body class="gray-bg">

	<ul class="nav nav-tabs" role="tablist">

		<li role="presentation" class="active"><a href="#home" role="tab"
			data-toggle="tab">基本信息</a></li>
		<li role="presentation"><a href="#profile" role="tab"
			data-toggle="tab">车主信息</a></li>
		<li role="presentation"><a href="#messages" role="tab"
			data-toggle="tab">报警人信息</a></li>
		<li role="presentation"><a href="#settings" role="tab"
			data-toggle="tab">违停车辆信息</a></li>
	</ul>
	<!-- 面板区 -->
	<div class="tab-content">
		<div role="tabpanel" class="tab-pane active" id="home">
			<div class="ibox-content">
				<form method="get" class="form-horizontal">
					<div class="form-group">
						<label class="col-sm-2 control-label ">报警单编号:</label>
						<div class="col-sm-4">
							<input type="text" class="form-control">
						</div>
						<label class="col-sm-2 control-label col-sm-pull-1">车牌号:</label>
						<div class="col-sm-4 col-sm-pull-1">
							<input type="text" class="form-control">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label ">车主姓名:</label>
						<div class="col-sm-4">
							<input type="text" class="form-control">
						</div>
						<label class="col-sm-2 control-label col-sm-pull-1">车主电话:</label>
						<div class="col-sm-4 col-sm-pull-1">
							<input type="text" class="form-control">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label ">报警人姓名:</label>
						<div class="col-sm-4">
							<input type="text" class="form-control">
						</div>
						<label class="col-sm-2 control-label col-sm-pull-1">报警人电话:</label>
						<div class="col-sm-4 col-sm-pull-1">
							<input type="text" class="form-control">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label ">状态:</label>
						<div class="col-sm-4">
							<select class="form-control m-b" name="account">
								<option>选项 1</option>
								<option>选项 2</option>
								<option>选项 3</option>
								<option>选项 4</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-4 col-sm-offset-6">
							<button class="btn btn-primary" type="submit">保存内容</button>
							<button class="btn btn-white" type="reset">重置</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div role="tabpanel" class="tab-pane" id="profile">
			<div class="ibox float-e-margins">
				<div class="ibox-content">
					<form method="get" class="form-horizontal">
						<div class="form-group">
							<label class="col-sm-2 control-label ">车主编号:</label>
							<div class="col-sm-4">
								<input type="text" class="form-control">
							</div>
							<label class="col-sm-2 control-label col-sm-pull-1">车主身份证号:</label>
							<div class="col-sm-4 col-sm-pull-1">
								<input type="text" class="form-control">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label ">车主姓名:</label>
							<div class="col-sm-4">
								<input type="text" class="form-control">
							</div>
							<label class="col-sm-2 control-label col-sm-pull-1">车主电话:</label>
							<div class="col-sm-4 col-sm-pull-1">
								<input type="text" class="form-control">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label ">车主性别:</label>
							<div class="col-sm-4">
								<input type="text" class="form-control">
							</div>
							<label class="col-sm-2 control-label col-sm-pull-1">家庭住址:</label>
							<div class="col-sm-4 col-sm-pull-1">
								<input type="text" class="form-control">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label ">出生年月:</label>
							<div class="col-sm-4">
								<input type="text" class="form-control">
							</div>
							<label class="col-sm-2 control-label col-sm-pull-1">电话号码:</label>
							<div class="col-sm-4 col-sm-pull-1">
								<input type="text" class="form-control">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label ">违停次数:</label>
							<div class="col-sm-4">
								<input type="text" class="form-control">
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>

		<div role="tabpanel" class="tab-pane" id="messages">
			<div class="ibox-content">
				<form method="get" class="form-horizontal">
					<div class="form-group">
						<label class="col-sm-2 control-label ">报警单编号:</label>
						<div class="col-sm-4">
							<input type="text" class="form-control">
						</div>
						<label class="col-sm-2 control-label col-sm-pull-1">车牌号:</label>
						<div class="col-sm-4 col-sm-pull-1">
							<input type="text" class="form-control">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label ">车主姓名:</label>
						<div class="col-sm-4">
							<input type="text" class="form-control">
						</div>
						<label class="col-sm-2 control-label col-sm-pull-1">车主电话:</label>
						<div class="col-sm-4 col-sm-pull-1">
							<input type="text" class="form-control">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label ">报警人姓名:</label>
						<div class="col-sm-4">
							<input type="text" class="form-control">
						</div>
						<label class="col-sm-2 control-label col-sm-pull-1">报警人电话:</label>
						<div class="col-sm-4 col-sm-pull-1">
							<input type="text" class="form-control">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label ">状态:</label>
						<div class="col-sm-4">
							<select class="form-control m-b" name="account">
								<option>选项 1</option>
								<option>选项 2</option>
								<option>选项 3</option>
								<option>选项 4</option>
							</select>
						</div>
					</div>
				</form>
			</div>
		</div>
		<!--
	作者：offline
	时间：2018-02-07
	描述：违停车辆信息
-->
		<div role="tabpanel" class="tab-pane" id="settings">
			<div class="ibox-content">
				<form method="get" class="form-horizontal">
					<div class="form-group">
						<label class="col-sm-2 control-label ">车牌号:</label>
						<div class="col-sm-4">
							<input type="text" class="form-control">
						</div>
						<label class="col-sm-2 control-label col-sm-pull-1">车辆类型:</label>
						<div class="col-sm-4 col-sm-pull-1">
							<input type="text" class="form-control">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label ">车主姓名:</label>
						<div class="col-sm-4">
							<input type="text" class="form-control">
						</div>
						<label class="col-sm-2 control-label col-sm-pull-1">车主电话:</label>
						<div class="col-sm-4 col-sm-pull-1">
							<input type="text" class="form-control">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label ">车辆所在地:</label>
						<div class="col-sm-4">
							<input type="text" class="form-control">
						</div>
						<label class="col-sm-2 control-label col-sm-pull-1">车辆使用类型:</label>
						<div class="col-sm-4 col-sm-pull-1">
							<input type="text" class="form-control">
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label ">汽车品牌编号:</label>
						<div class="col-sm-4">
							<input type="text" class="form-control">
						</div>
						<label class="col-sm-2 control-label col-sm-pull-1">车辆识别代码:</label>
						<div class="col-sm-4 col-sm-pull-1">
							<input type="text" class="form-control">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label ">发动机编号:</label>
						<div class="col-sm-4">
							<input type="text" class="form-control">
						</div>
						<label class="col-sm-2 control-label col-sm-pull-1">汽车颜色:</label>
						<div class="col-sm-4 col-sm-pull-1">
							<input type="text" class="form-control">
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>