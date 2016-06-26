<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>模块管理</title>
		
		<link href="<@s.url '/plugin/bootstrap/css/bootstrap.min.css'/>" type="text/css" rel="stylesheet"/>
		<link href="<@s.url '/plugin/bootstrap/css/bootstrap-theme.min.css'/>" type="text/css" rel="stylesheet"/>
		
	</head>

	<body>
		<div class="container">
			<div class="page-header">
				<h1 style="color: #286090;">考试宝后台管理系统
					<small style="float: right;">欢迎您,张三. &nbsp;
						<a href="#"><span class="glyphicon glyphicon-off" aria-hidden="true"></span>退出</a>
					</small>
				</h1>
			</div>
			<div class="row" style="height: 60px;">
				<ul class="nav nav-pills">
					<li role="" class="">
						<a href="#"><span class="glyphicon glyphicon-home" aria-hidden="true"></span> 首页</a>
					</li>
					<li role="">
						<a href="#"><span class="glyphicon glyphicon-education" aria-hidden="true"></span> 考生管理</a>
					</li>
					<li role="">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
							<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> 试题管理 <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#"><span class="glyphicon glyphicon-wrench" aria-hidden="true"></span> 技能题管理</a></li>
							<li><a href="#"><span class="glyphicon glyphicon-book" aria-hidden="true"></span> 理论题管理</a></li>
							<li><a href="#"><span class="glyphicon glyphicon-tags" aria-hidden="true"></span> 预选项管理</a></li>
							<li><a href="#"><span class="glyphicon glyphicon-check" aria-hidden="true"></span> 试题审核</a></li>
						</ul>
					</li>
					<li role="">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
							<span class="glyphicon glyphicon-duplicate" aria-hidden="true"></span> 试卷管理 <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#"><span class="glyphicon glyphicon-wrench" aria-hidden="true"></span> 技能卷管理</a></li>
							<li><a href="#"><span class="glyphicon glyphicon-book" aria-hidden="true"></span> 理论卷管理</a></li>
							<li><a href="#"><span class="glyphicon glyphicon-check" aria-hidden="true"></span> 试卷审核</a></li>
						</ul>

					</li>
					<li role="">
						<a href="#"><span class="glyphicon glyphicon-hourglass" aria-hidden="true"></span> 考试管理</a>
					</li>
					<li role="" class="active">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
							<span class="glyphicon glyphicon-cog" aria-hidden="true"></span> 系统设置 <span class="caret"></span>
						</a>
						<ul class="dropdown-menu">
							<li><a href="#"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> 用户管理</a></li>
							<li><a href="#"><span class="glyphicon glyphicon-align-center" aria-hidden="true"></span> 角色管理</a></li>
							<li><a href="#"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span> 权限管理</a></li>
						</ul>
					</li>
					<li role="">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
							<span class="glyphicon glyphicon-tag" aria-hidden="true"></span> 成绩查询 <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#"><span class="glyphicon glyphicon-signal" aria-hidden="true"></span> 成绩分析</a></li>
						</ul>
					</li>
					<li role="">
						<a href="#"><span class="glyphicon glyphicon-retweet" aria-hidden="true"></span> 制作考试宝</a>
					</li>
				</ul>
			</div>
			<div class="row" style="height: 60px;">
				<ol class="breadcrumb">
					<span>您当前的位置:</span>
					<li><a href="#">首页</a></li>
					<li><a href="#">系统设置</a></li>
					<li class="active">模块管理</li>
				</ol>
			</div>
			<div class="row">
				<input type="button" class="btn btn-info" id="add_module" style="margin-bottom:10px;float:left" value=" + 新增" />
				<table class="table table-hover">
					<tr class="active">
						<td><label></label></td>
						<td><label>编码</label></td>
						<td><label>名称</label></td>
						<td><label>url地址</label></td>
						<td><label>排序</label></td>
						<td><label>操作</label></td>
					</tr>
					
					<#if  moduleList?? && moduleList?size gt 0>
						<#list moduleList as module>
							<#if module.seq==0>
								<tr class="info">
									<td></td>
									<td>${module.code!}</td>
									<td><label>${module.name!}</label></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
							<#else>
								<tr>
									<td></td>
									<td>${module.code!}</td>
									<td>${module.name!}</td>
									<td>${module.url!}</td>
									<td>${module.seq!}</td>
									<td>
										<input type="button" class="btn btn-info" value="修改" />
										<input type="button" name="delete_module" role_id="${module.id!}" class="btn btn-warning" value="删除" />
									</td>
								</tr>
							</#if>
						</#list>
					<#else>
						<tr style="text-align:center;"><td colspan="10" style="padding:20px;">暂无记录!</td></tr>
					</#if>
					
				</table>
			</div>
		</div>
		
		
		
		<#-- 删除摸态框 -->
		<div class="modal" id="delete_modal"  tabindex="-1">
		    <div class="modal-dialog modal-sm">
		    	<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
						<h4 class="modal-title">提示</h4>
					</div>
					<div class="modal-body">
						<p>确认删除?</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="button" class="btn btn-primary">删除</button>
					</div>
				</div>
			</div>
		</div>
		<#-- 新增摸态框 -->
		<div class="modal" id="add_modal"  tabindex="-1">
		    <div class="modal-dialog">
		    	<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
						<h4 class="modal-title">新增</h4>
					</div>
					<div class="modal-body">
						<form class="form-horizontal">
							<div class="form-group">
						    	<label for="" class="col-sm-2 control-label">上级模块:</label>
						    	<div class="col-sm-10">
						      		<select class="form-control" id="parent_code">
						      			<option id="000">根模块</option>
						      			<option>考生管理</option>
						      			<option>试题管理</option>
						      			<option>试卷管理</option>
						      			<option>考试管理</option>
						      			<option>系统设置</option>
						      			<option>成绩查询</option>
						      			<option>制作考试宝</option>
						      		</select>
						    	</div>
						  	</div>
							<div class="form-group">
						    	<label for="" class="col-sm-2 control-label">编码:</label>
						    	<div class="col-sm-10">
						      		<input type="text" class="form-control" id="module_code" placeholder="请输入模块编码">
						    	</div>
						  	</div>
						  	<div class="form-group">
						    	<label for="" class="col-sm-2 control-label">名称:</label>
						    	<div class="col-sm-10">
						      		<input type="text" class="form-control" id="module_name" placeholder="请输入模块名称">
						    	</div>
						  	</div>
						  	<div class="form-group">
						    	<label for="" class="col-sm-2 control-label">url:</label>
						    	<div class="col-sm-10">
						      		<input type="text" class="form-control" id="module_url" placeholder="请输入url地址">
						    	</div>
						  	</div>
						  	<div class="form-group">
						    	<label for="" class="col-sm-2 control-label">排序:</label>
						    	<div class="col-sm-10">
						      		<input type="text" class="form-control" id="module_seq" placeholder="请输入在上级模块下的排序">
						    	</div>
						  	</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="button" class="btn btn-primary" id="add_confirm">保存</button>
					</div>
				</div>
			</div>
		</div>
			
	</body>

	<script src="<@s.url '/plugin/jquery/jquery-1.12.3.min.js'/>" type="text/javascript"></script>
	<script src="<@s.url '/plugin/bootstrap/js/bootstrap.min.js'/>" type="text/javascript"></script>
	<script src="<@s.url '/js/system/module.js'/>" type="text/javascript"></script>
		
</html>