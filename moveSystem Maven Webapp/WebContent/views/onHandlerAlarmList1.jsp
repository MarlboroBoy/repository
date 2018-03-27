<%@ page contentType="text/html;charset=UTF-8"%>
<%@include file="/common/views/common.jsp"%>


<html>

<head>


<title>H+ 后台主题UI框架 - Bootstrap Table</title>



</head>

<body class="gray-bg">


	<div class="col-sm-12">

		<div class="example-wrap">

			<div class="example">

				<div class="btn-group hidden-xs" id="exampleTableEventsToolbar"
					role="group">

					<button type="button" class="btn btn-outline btn-default"
						onclick="display()">
						<i class="glyphicon glyphicon-search" aria-hidden="true"></i> <small>查看</small>
					</button>

					<button type="button" class="btn btn-outline btn-default">
						<i class="glyphicon glyphicon-trash" aria-hidden="true"></i> <small>删除</small>
					</button>
				</div>
				<table id="exampleTableEvents" data-mobile-responsive="true">
					<thead>
						<tr>
							<th data-field="state" data-checkbox="true"></th>
							<th data-field="id">编号</th>
							<th data-field="plate">车牌号</th>
							<th data-field="address">违停车辆地址</th>
							<th data-field="carownerName">车主姓名</th>
							<th data-field="carownertel">车主电话</th>
							<th data-field="alarmid">报警人编号</th>
							<th data-field="alarmName">报警人用户名</th>
							<th data-field="alarmtel">报警人电话</th>
							<th data-field="alarmstate">处理状态</th>
						</tr>
					</thead>
				</table>
			</div>
		</div>
		<!-- End Example Events -->
	</div>


	<script src="${ctx}/js/admin/bootstrap-table-demo.js"></script>
</body>

</html>

