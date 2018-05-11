<%@ page contentType="text/html;charset=UTF-8"%>
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
			data-toggle="tab">车辆信息</a></li>

		<li role="presentation"><a href="#settings" role="tab"
			data-toggle="tab">车主信息</a></li>
			
	</ul>

	<!-- 面板区 -->
	<div class="tab-content">
		<div role="tabpanel" class="tab-pane active" id="home">
			<div class="ibox-content">
				<form method="get" class="form-horizontal">
					<div class="form-group">
						<label class="col-sm-2 control-label ">车牌号:</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" value="${carModel.licensePlate}" disabled="disabled">
						</div>
						<label class="col-sm-2 control-label col-sm-pull-1">车辆类型:</label>
						<div class="col-sm-4 col-sm-pull-1">
							<input type="text" class="form-control" value="${carModel.carType}" disabled="disabled">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label ">车主姓名:</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" value="${carModel.name}" disabled="disabled">
						</div>
						<label class="col-sm-2 control-label col-sm-pull-1">车主电话:</label>
						<div class="col-sm-4 col-sm-pull-1" >
							<input type="text" class="form-control" value="${carModel.telphone}" disabled="disabled">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label ">车辆所在地:</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" value="${carModel.carAddress}"disabled="disabled">
						</div>
						<label class="col-sm-2 control-label col-sm-pull-1">使用类型:</label>
						<div class="col-sm-4 col-sm-pull-1">
							<input type="text" class="form-control" value="${carModel.userType}" disabled="disabled">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label ">品牌编号:</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" value="${carModel.brandNumber}" disabled="disabled">
						</div>
						<label class="col-sm-2 control-label col-sm-pull-1">识别代码:</label>
						<div class="col-sm-4 col-sm-pull-1">
							<input type="text" class="form-control" value="${carModel.carcode}" disabled="disabled">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label ">发动机编号:</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" value="${carModel.enginecode}" disabled="disabled">
						</div>
						<label class="col-sm-2 control-label col-sm-pull-1">汽车颜色:</label>
						<div class="col-sm-4 col-sm-pull-1">
							<input type="text" class="form-control" value="${carModel.carColor}" disabled="disabled">
						</div>
					</div>
				</form>
			</div>
		</div>
		
	
	
		<div role="tabpanel" class="tab-pane" id="settings">
			<div class="ibox float-e-margins">
				<div class="ibox-content">
					<form method="get" class="form-horizontal">
						<div class="form-group">
							<label class="col-sm-2 control-label ">车主编号:</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" value="${carModel.id}" disabled="disabled">
							</div>
							<label class="col-sm-2 control-label col-sm-pull-1">车主身份证号:</label>
							<div class="col-sm-4 col-sm-pull-1">
								<input type="text" class="form-control" value="${carModel.idNumber}" disabled="disabled">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label ">车主姓名:</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" value="${carModel.name}" disabled="disabled">
							</div>
							<label class="col-sm-2 control-label col-sm-pull-1">车主电话:</label>
							<div class="col-sm-4 col-sm-pull-1">
								<input type="text" class="form-control" value="${carModel.telphone}" disabled="disabled">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label ">车主性别:</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" value="${carModel.sex}" disabled="disabled">
							</div>
							<label class="col-sm-2 control-label col-sm-pull-1">家庭住址:</label>
							<div class="col-sm-4 col-sm-pull-1">
								<input type="text" class="form-control" value="${carModel.address}" disabled="disabled">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label ">出生年月:</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" value="${carModel.birthday}" disabled="disabled">
							</div>
							<label class="col-sm-2 control-label col-sm-pull-1">电话号码:</label>
							<div class="col-sm-4 col-sm-pull-1">
								<input type="text" class="form-control" value="${carModel.telphone}" disabled="disabled">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label ">违停次数:</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" value="${carModel.illegalNumber}" disabled="disabled">
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>