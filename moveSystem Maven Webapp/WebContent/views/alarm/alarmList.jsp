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
 
<script type="text/javascript" src="${ctx}/plugins/bootstrap3-editable/js/bootstrap-editable.min.js"></script>
<script type="text/javascript" src="${ctx}/plugins/bootstrap3-editable/js/bootstrap-table-editable.js"></script>

<script type="text/javascript">
    $(function(){	
    	 $('#exampleTableEvents').bootstrapTable({
    	      url: "${ctx}/js/demo/bootstrap_table_test2.json",
    	      idField: "Id",
    	      search: true,
    	      pagination: true,
    	      showRefresh: true,
    	      showToggle: true,
    	      showColumns: true,
    	      iconSize: 'outline',
    	      sstriped:true,
    	      toolbar: '#exampleTableEventsToolbar',
    	     checkbox:true,
    	     editable:true,
    	     columns: [ 
    	     {checkbox: true
    	     },			{
    	                field: "id",
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
    	                field: "carOwnName",
    	                title: "车主姓名"
    	            }, {
    	                field: "alarmid",
    	                title: "报警人编号"                
    	            }
    				, {
    	                field: "telphone",
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
    	                	source:[{value:"1",text:"研发部"},{value:"2",text:"销售部"},{value:"3",text:"行政部"}]
    	                }
    	              
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
	addDetailInfo('http://localhost:8080/moveSystem/test/test1.do', '123', '1000px', '1000px');
	//      BootstrapDialog.show({
	//      	type: BootstrapDialog.TYPE_PRIMARY,
	//      size: BootstrapDialog.SIZE_WIDE,
	//      nl2br: true,
	//          title: '详情',
	//          message: this.parent.load(''),
	//          closable:true         
	//      });
}</script>
<script>
function addDetailInfo(url, title, formId, cssClasses) {
	var $that = $(this);
	var formUrl = url;
	if(url.indexOf("?") != -1) {
		formUrl = url.substring(0, url.indexOf("?")) + "/form";
	} else {
		formUrl = url + "/form";
	}
	//失效  
	$that.attr("disabled", "disabled");
	// 调用add方法  
	var dialog = BootstrapDialog.show({
		type: BootstrapDialog.TYPE_DEFAULT,
		title:  title,
		closable: false,
		draggable: true,
		cssClass: cssClasses,
		message: $('<div></div>').load(url), //加载弹出页面  
		size: BootstrapDialog.SIZE_WIDE, //弹出框大小。  
		onhide: function() {
			$that.removeAttr("disabled");
		},
		buttons: [{
			id: 'btn-form-submit',
			label: '提交',
			icon: 'fa fa-check-circle',
			cssClass: 'btn-primary',
			action: function(dialogRef) {
				var $button = this;
				//表单验证并提交  
				$('#' + formId).unbind("valid.form");
				$('#' + formId).bind('valid.form', function(e, form) {
					// Before submitting the form, hold form, to prevent duplicate submission.  
					//$(form).holdSubmit();  
					$button.disable();
					$.ajax({
						type: 'post',
						url: formUrl,
						data: $("#" + formId).serialize(), //序列化表格内容为字符串    
						cache: false,
						dataType: 'json',
						success: function(data) {
							// After the form is submitted successfully, release hold.  
							//$(form).holdSubmit(false);  
							$button.enable();
							BootstrapDialog.alertSuccess("提交成功!", function() {
								//当前页面刷新  
								window.location.reload();
							});
							dialog.close();
						},
						error: function(error) {
							$button.enable();
							BootstrapDialog.alertError("提交失败!");
						}
					});
				});
				//提交表单  
				$('#' + formId).trigger("submit");
			}
		}, {
			label: '关闭',
			icon: 'fa fa-close',
			action: function(dialogItself) {
				dialogItself.close();
			}
		}]
	});
};
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
					<button type="button" class="btn btn-outline btn-default">
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
