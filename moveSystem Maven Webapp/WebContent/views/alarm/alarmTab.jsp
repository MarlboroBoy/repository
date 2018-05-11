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
$('input').attr("disabled","true");
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
			data-toggle="tab">报警单信息</a></li>
		<li role="presentation"><a href="#userMessage" role="tab"
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
							<input type="text" class="form-control" value="${alarmRecordModel.alarmSheetId}">
						</div>
						<label class="col-sm-2 control-label col-sm-pull-1">车牌号:</label>
						<div class="col-sm-4 col-sm-pull-1">
							<input type="text" class="form-control" value="${alarmRecordModel.licensePlate}">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label ">车主姓名:</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" value="${alarmRecordModel.carOwnName}">
						</div>
						<label class="col-sm-2 control-label col-sm-pull-1">车主电话:</label>
						<div class="col-sm-4 col-sm-pull-1">
							<input type="text" class="form-control" value="${alarmRecordModel.telphone}">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label ">报警人姓名:</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" value="${alarmRecordModel.userName}">
						</div>
						<label class="col-sm-2 control-label col-sm-pull-1">报警人电话:</label>
						<div class="col-sm-4 col-sm-pull-1">
							<input type="text" class="form-control" value="${alarmRecordModel.tel}">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label ">状态:</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" value="${alarmRecordModel.processingState}">
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
								<input type="text" class="form-control" value="${alarmRecordModel.id}">
							</div>
							<label class="col-sm-2 control-label col-sm-pull-1">车主身份证号:</label>
							<div class="col-sm-4 col-sm-pull-1">
								<input type="text" class="form-control" value="${alarmRecordModel.idNumber}">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label ">车主姓名:</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" value="${alarmRecordModel.carOwnName}">
							</div>
							<label class="col-sm-2 control-label col-sm-pull-1">车主电话:</label>
							<div class="col-sm-4 col-sm-pull-1">
								<input type="text" class="form-control" value="${alarmRecordModel.telphone}">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label ">车主性别:</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" value="${alarmRecordModel.sex}">
							</div>
							<label class="col-sm-2 control-label col-sm-pull-1">家庭住址:</label>
							<div class="col-sm-4 col-sm-pull-1">
								<input type="text" class="form-control" value="${alarmRecordModel.address}">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label ">出生年月:</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" value="${alarmRecordModel.birthday}">
							</div>
							<label class="col-sm-2 control-label col-sm-pull-1">电话号码:</label>
							<div class="col-sm-4 col-sm-pull-1">
								<input type="text" class="form-control" value="${alarmRecordModel.telphone}">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label ">违停次数:</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" value="${alarmRecordModel.illegalNumber}">
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
							<input type="text" class="form-control" value="${alarmRecordModel.alarmSheetId}">
						</div>
						<label class="col-sm-2 control-label col-sm-pull-1">车牌号:</label>
						<div class="col-sm-4 col-sm-pull-1">
							<input type="text" class="form-control" value="${alarmRecordModel.licensePlate}">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label ">违停地址:</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" value="${alarmRecordModel.alarmAdress}">
						</div>
						<label class="col-sm-2 control-label col-sm-pull-1">报警时间:</label>
						<div class="col-sm-4 col-sm-pull-1">
							<input type="text" class="form-control" value="${alarmRecordModel.alarmTime}">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label ">现场图片:</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" value="${alarmRecordModel.imgUrl}">
						</div>
						<label class="col-sm-2 control-label col-sm-pull-1">现场描述:</label>
						<div class="col-sm-4 col-sm-pull-1">
							<input type="text" class="form-control" value="${alarmRecordModel.describ}">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label ">状态:</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" value="${alarmRecordModel.processingState}">
				
						</div>
					</div>
				</form>
			</div>
		</div>
		<div role="tabpanel" class="tab-pane" id="userMessage">
			<div class="ibox-content">
				<form method="get" class="form-horizontal">
					<div class="form-group">
						<label class="col-sm-2 control-label ">报警人id:</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" value="${alarmRecordModel.account}">
						</div>
						<label class="col-sm-2 control-label col-sm-pull-1">姓名:</label>
						<div class="col-sm-4 col-sm-pull-1">
							<input type="text" class="form-control" value="${alarmRecordModel.userName}">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label ">身份证号:</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" value="${alarmRecordModel.idcardNumber}">
						</div>
						<label class="col-sm-2 control-label col-sm-pull-1">性别:</label>
						<div class="col-sm-4 col-sm-pull-1" >
							<input type="text" class="form-control" value="${alarmRecordModel.userSex}">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label ">创建时间:</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" value="${alarmRecordModel.userUptime}">
						</div>
						<label class="col-sm-2 control-label col-sm-pull-1">报警人电话:</label>
						<div class="col-sm-4 col-sm-pull-1">
							<input type="text" class="form-control" value="${alarmRecordModel.tel}">
						</div>
					</div>
				</form>
			</div>
		</div>
	
		<div role="tabpanel" class="tab-pane" id="settings">
			<div class="ibox-content">
				<form method="get" class="form-horizontal">
					<div class="form-group">
						<label class="col-sm-2 control-label ">车牌号:</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" value="${alarmRecordModel.processingState}">
						</div>
						<label class="col-sm-2 control-label col-sm-pull-1">车辆类型:</label>
						<div class="col-sm-4 col-sm-pull-1">
							<input type="text" class="form-control" value="${alarmRecordModel.carType}">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label ">车主姓名:</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" value="${alarmRecordModel.carOwnName}">
						</div>
						<label class="col-sm-2 control-label col-sm-pull-1">车主电话:</label>
						<div class="col-sm-4 col-sm-pull-1" >
							<input type="text" class="form-control" value="${alarmRecordModel.telphone}">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label ">车辆所在地:</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" value="${alarmRecordModel.carAddress}">
						</div>
						<label class="col-sm-2 control-label col-sm-pull-1">使用类型:</label>
						<div class="col-sm-4 col-sm-pull-1">
							<input type="text" class="form-control" value="${alarmRecordModel.userType}">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label ">品牌编号:</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" value="${alarmRecordModel.brandNumber}">
						</div>
						<label class="col-sm-2 control-label col-sm-pull-1">识别代码:</label>
						<div class="col-sm-4 col-sm-pull-1">
							<input type="text" class="form-control" value="${alarmRecordModel.carcode}">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label ">发动机编号:</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" value="${alarmRecordModel.enginecode}">
						</div>
						<label class="col-sm-2 control-label col-sm-pull-1">汽车颜色:</label>
						<div class="col-sm-4 col-sm-pull-1">
							<input type="text" class="form-control" value="${alarmRecordModel.carColor}">
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>