<%@ page contentType="text/html;charset=UTF-8"%>
<%@include file="/common/views/common.jsp"%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>H+ 后台主题UI框架 - Bootstrap Table</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">



</head>

<body class="gray-bg">
   
             <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>系统参数设置</small></h5>
                       </div>
                    <div class="ibox-content">
                        <form method="get" class="form-horizontal">
                        	 <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">当前系统的工作模式
                                    <br/>
                                    <br />
                                    <small class="text-navy"></small>
                                </label>

                                <div class="col-sm-8">
                      
                                    <div class="radio">
                                        <label>
                                            <input type="radio" checked="" value="option1" id="optionsRadios1" name="optionsRadios">自动处理模式</label>
                                    </div>
                                    <div class="radio">
                                        <label>
                                            <input type="radio" value="option2" id="optionsRadios2" name="optionsRadios">手动处理模式</label>
                                    </div>
                                </div>
                            </div>
                            
                        	
                        	
                        	
                        	
                        	
                        	
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">系统信息发送失败重新发送次数</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control"> <span class="help-block m-b-none">帮助文本，可能会超过一行，以块级元素显示</span>
                                </div>
                            </div>
                           <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">系统信息发送失败重新间隔时间</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control"> <span class="help-block m-b-none">帮助文本，可能会超过一行，以块级元素显示</span>
                                </div>
                            </div>
                         
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">禁用</label>

                                <div class="col-sm-8">
                                    <input type="text" disabled="" placeholder="已被禁用" class="form-control">
                                </div>
                            </div>
                            
                           
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">选择信息发送模板</label>

                                <div class="col-sm-8">
                                    <select class="form-control m-b" name="account">
                                        <option>选项 1</option>
                                        <option>选项 2</option>
                                        <option>选项 3</option>
                                        <option>选项 4</option>
                                    </select>

                                   
                                </div>
                            </div>
                            
                            <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-2">
                                    <button class="btn btn-primary" type="submit">保存内容</button>
                                    <button class="btn btn-white" type="reset">重置</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    


    <!-- 自定义js -->
    <script src="../js/content.js?v=1.0.0"></script>



</body>

</html>
