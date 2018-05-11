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
<link  href="${ctx}/plugins/bootstrap3-editable/css/bootstrap-editable.css"/>
 <style>
 select.input-sm {
    height: 40px;
    line-height: 30px;
}
 </style>
<script type="text/javascript" src="${ctx}/plugins/bootstrap3-editable/js/bootstrap-editable.min.js"></script>
<script type="text/javascript" src="${ctx}/plugins/bootstrap3-editable/js/bootstrap-table-editable.js"></script>

<script type="text/javascript">
    $(function(){	
    	 $('#exampleTableEvents').bootstrapTable({
    	      url: "${ctx}/alarmRecord/onAlarmList.do",
    	      idField: "alarmSheetId",
    	      search: true,
    	      pagination: true,
    	      showRefresh: true,
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
    	                field: "alarmSheetId",
    	                title: "编号",
    		                
    	            }, {
    	                field: "licensePlate",
    	                title: "车牌号",
    	            }, {
    	                field: "alarmAdress",
    	                title: "违停车辆地址",
//    	              formatter: function (value, row, index) {
//    	                  var date = eval('new ' + eval(value).source)
//    	                  return date.format("yyyy-MM-dd");
//    	              }
    	            },
    	            {
    	                field: "name",
    	                title: "车主姓名"
    	            }, {
    	                field: "telphone",
    	                title: "车主电话"                
    	            }
    				, {
    	                field: "userName",
    	                title: "报警人用户名"                
    	            }
    				, {
    	                field: "tel",
    	                title: "报警人电话"                
    	            }
    				, {
    	                field: "processingState",
    	                title: "处理状态"   ,
    	                editable:{
    	                	type:'select',
    	                	title:'处理状态',
    	                	source:[{value:"1",text:"报警单生成中"},{value:"2",text:"通知车主中"},{value:"3",text:"移车中"},{value:"4",text:"人工处理中"},{value:"5",text:"处理完成"}]}  	              
    	           }
    				],//开启编辑模式
    				   onEditableSave: function (field, row, oldValue, $el) {
    		                $.ajax({
    		                    type: "post",
    		                    url: "${ctx}/alarmRecord/changeState.do",
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
 <script type="text/javascript">
 
    	function display() {
    		var rows = $('#exampleTableEvents').bootstrapTable('getSelections');
    		 if(rows==null||rows==""){
    			 $.showErr('请选择一条数据');
    			 return false;
    		 }
    		
        BootstrapDialog.show({
            message: function(dialog) {
                var $message = $('<div></div>');
                var pageToLoad = dialog.getData('pageToLoad');
                $message.load(pageToLoad);
                return $message;
            },
            title:'查看详细信息',
            size: BootstrapDialog.SIZE_WIDE,
            data: {
                'pageToLoad': '${ctx}/alarmRecord/alarmDisplay.do?alarmSheetId='+rows[0].alarmSheetId
            },  buttons : [ {// 设置关闭按钮
                label : '关闭',
                action : function(dialogItself) {
                    dialogItself.close();
                }
            }],
        });
}
    	var rows; 
    	function deleteAlarm(){
    		 rows = $('#exampleTableEvents').bootstrapTable('getSelections');
   		 if(rows==null||rows==""){
   			 $.showErr('请选择一条数据');
   			 return false;
   		 }
   		
   		$.showConfirm('确定删除吗?',function(){
   			var row = rows[0];
   	   	   $.ajax({
   	           type: "post",
   	           url: "${ctx}/alarmRecord/deleteAlarm.do",
   	           data: row,
   	           dataType: 'JSON',
   	           success: function (data, status) {
   	               if (status == "success") {
   	            	$('#exampleTableEvents').bootstrapTable(  
      	   	                 "refresh",  
      	   	                 {  
      	   	                     url:"${ctx}/alarmRecord/alarmList.do"  
      	   	                 }  
      	   	         );
   	                   $.showSuccessTimeout('删除成功',1000);
   	            
   	               }
   	           },
   	           error: function () {
   	        	   $.showErr('删除失败,请联系管理员');
   	           },
   	           complete: function () {
   	        
   	           }

   	       });
   	   	},null);
    	}
   		 
   	
    	
    	
    	</script>
<body class="gray-bg">
	<div class="col-sm-12">
		<!-- Example Events -->
		<div class="example-wrap">
			<div class="example">
				<div class="btn-group hidden-xs" id="exampleTableEventsToolbar"
					role="group">
					<button type="button" class="btn btn-outline btn-default"
						onclick="display()">
						<i class="glyphicon glyphicon-search" aria-hidden="true"></i> <small>查看</small>
					</button>
					<button type="button" class="btn btn-outline btn-default"
					onclick="deleteAlarm()">
						<i class="glyphicon glyphicon-trash" aria-hidden="true"></i> <small>删除</small>
					</button>
				</div>
				<table id="exampleTableEvents"
					data-mobile-responsive="true">
				</table>
			</div>
		</div>
	</div>
</body>
</html>
