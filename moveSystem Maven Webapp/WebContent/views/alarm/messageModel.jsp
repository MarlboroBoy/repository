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
<link
	href="${ctx}/plugins/bootstrap3-editable/css/bootstrap-editable.css" />
<style type="text/css">
select.input-sm {
	height: 40px;
	line-height: 30px;
}
</style>
<script type="text/javascript"
	src="${ctx}/plugins/bootstrap3-editable/js/bootstrap-editable.min.js"></script>
<script type="text/javascript"
	src="${ctx}/plugins/bootstrap3-editable/js/bootstrap-table-editable.js"></script>

<script type="text/javascript">
    $(function(){	
    	 $('#exampleTableEvents').bootstrapTable({
    	      url: "${ctx}/message/getAll.do",
    	      idField: "messageId",

    	      pagination: true,
    	      showToggle: true,
    	      showColumns: true,
    	      singleSelect:true,
    	      iconSize: 'outline',
    	      sstriped:true,
    	      toolbar: '#exampleTableEventsToolbar',
    	     checkbox:true,
    	     editable:true,
    	     columns: [ 
    	     {checkbox: true
    	     },			{
    	                field: "messageId",
    	                title: "模板编号",
    		                
    	            },{
    	                field: "title",
    	                title: "标题",
    	            } ,{
    	                field: "cont",
    	                title: "发送内容",
    	            }, {
    	                field: "addTime",
    	                title: "创建时间",
    	            }
    				, {
    	                field: "isUse",
    	                title: "状态"   ,
    	                editable:{
    	                	type:'select',
    	                	title:'状态',
    	                	source:[{value:"1",text:"正在使用"},{value:"2",text:"未使用"}]
    	                }
    	              
    	           }
    				],//开启编辑模式
    				   onEditableSave: function (field, row, oldValue, $el) {
    		                $.ajax({
    		                    type: "post",
    		                    url: "${ctx}/message/changeUse.do",
    		                    data: row,
    		                    dataType: 'JSON',
    		                    success: function (data, status) {
    		                        if (status == "success") {
    		                            alert('提交数据成功');
    		                        }
    		                    },
    		                    error: function () {
    		                        alert('编辑失败');
    		                    },
    		                    complete: function () {

    		                    }

    		                });
    		                },
    	       
    	      clickToSelect:true,
    	      onClickRow:function(row, $element){
    	      	
    	      }
    	    ,
    	      icons: {
    	        refresh: 'glyphicon-repeat',
    	        toggle: 'glyphicon-list-alt',
    	        columns: 'glyphicon-list'
    	      }
    	    });

    	   
    })
 </script>
 

<body class="gray-bg">
	<div class="col-sm-12">
		<!-- Example Events -->
		<div class="example-wrap">
			<div class="example">
				<div class="btn-group hidden-xs" id="exampleTableEventsToolbar"
					role="group">
				<!-- 	<button type="button" class="btn btn-outline btn-default"
						onclick="display()">
						<i class="glyphicon glyphicon-search" aria-hidden="true"></i> <small>查看</small>
					</button>
					<button type="button" class="btn btn-outline btn-default"
						onclick="deleteAlarm()">
						<i class="glyphicon glyphicon-trash" aria-hidden="true"></i> <small>删除</small>
					</button> -->
				</div>
				<table id="exampleTableEvents" data-mobile-responsive="true">
				</table>
			</div>
		</div>
	</div>
</body>
</html>
