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
<script type="text/javascript" 
src="${ctx}/plugins/bootstrap3-editable/js/bootstrap-table-editable.js"></script>

<script type="text/javascript">
    $(function(){	
    	 $('#exampleTableEvents').bootstrapTable({
    	      url: "${ctx}/car/queryCar.do",
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
    	     },			 {
    	                field: "licensePlate",
    	                title: "车牌号",
    	            }, 
    	            {
    	                field: "carType",
    	                title: "编号",
    		                
    	            },{
    	                field: "carAddress",
    	                title: "车辆所在地",
//    	              formatter: function (value, row, index) {
//    	                  var date = eval('new ' + eval(value).source)
//    	                  return date.format("yyyy-MM-dd");
//    	              }
    	            },
    	            {
    	                field: "userType",
    	                title: "汽车用途"
    	            }, {
    	                field: "brandNumber",
    	                title: "行驶证编号"                
    	            }
    				, {
    	                field: "carCode",
    	                title: "汽车编号"                
    	            }
    				, {
    	                field: "enginecode",
    	                title: "发动机编号"                
    	            }
    				, {
    	                field: "carColor",
    	                title: "汽车颜色" 
    	                },
    	                
    	                {
        	                field: "name",
        	                title: "车主姓名"   
        	              
    	              
    	           }
    				],//开启编辑模式
    				  
    	       
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
                'pageToLoad': '${ctx}/car/display.do?licensePlate='+rows[0].licensePlate
            },  buttons : [ {// 设置关闭按钮
                label : '关闭',
                action : function(dialogItself) {
                    dialogItself.close();
                }
            }],
        });
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
				</div>
				<table id="exampleTableEvents"
					data-mobile-responsive="true">
				</table>
			</div>
		</div>
	</div>
</body>
</html>
