<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>权限设置</title>
		
		<link href="<@s.url '/plugin/bootstrap/css/bootstrap.min.css'/>" type="text/css" rel="stylesheet"/>
		<link href="<@s.url '/plugin/bootstrap/css/bootstrap-theme.min.css'/>" type="text/css" rel="stylesheet"/>
		
	</head>

	<body>
		<div class="container">
		
			<#include "/menu/menu.ftl">
			
			<div class="row" style="height: 60px;">
				<ol class="breadcrumb">
					<span>您当前的位置:</span>
					<li><a href="#">首页</a></li>
					<li><a href="#">系统设置</a></li>
					<li class="active">权限管理</li>
				</ol>
			</div>
			<div class="row" style="height: 60px;">
				<form class="form-inline">
					<div class="form-group">
						<label for="keyWord">角色:</label>
						<input class="form-control" id="role_name" role_id="${role.id!}" value="${role.name!}" readonly />
					</div>
				</form>
			</div>
			<div class="row">
				<table class="table table-hover">
					<tr class="active">
						<td><label>模块名称</label></td>
						<td><label>权限设置</label></td>
						<td></td>
					</tr>
					<#if moduleMapList?exists>
						<#list moduleMapList as moudlueMap>
						<#if moudlueMap?exists>
							<#list moudlueMap?keys as key> 
								<tr>
									<td><label>${key}</label></td>
									<td>
									<#assign moudleList = moudlueMap[key]>
									<#if moudleList?exists>
									<#list moudleList as module>
										<label><input type="checkbox" name="module" module_id="${module.id}" >${module.name}</label>
									</#list>
									</#if>
									<td>
								</tr>
							</#list>
						</#if>
						</#list>
					</#if>
					
				</table>
				
				<div class="row" style="height: 60px;">
					<form class="form-inline">
						<div class="form-group">
							<input type="button" class="btn btn-default" id="back_role" value="返回" />
							<input type="button" class="btn btn-primary" id="save_right" value="保存" />
						</div>
					</form>
				</div>
				
			</div>
		</div>
	</body>
	
	<script src="<@s.url '/plugin/jquery/jquery-1.12.3.min.js'/>" type="text/javascript"></script>
	<script src="<@s.url '/plugin/bootstrap/js/bootstrap.min.js'/>" type="text/javascript"></script>
	<script src="<@s.url '/js/system/right.js'/>" type="text/javascript"></script>
</html>