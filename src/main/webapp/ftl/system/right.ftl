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
						<select class="form-control" id="type">
					        <option value="">请选择角色</option>
					        <option value="">老师</option>
					        <option value="">学生</option>
					        <option value="">管理员</option>
					    </select>
					</div>
				</form>
			</div>
			<div class="row">
				<table class="table table-hover">
					<tr class="active">
						<td><label>模块名称</label></td>
						<td><label>权限设置</label></td>
					</tr>
					<tr>
						<td><label>考生管理</label></td>
						<td>
							<label><input type="checkbox">考生管理</label>
							<label><input type="checkbox">考生管理</label>
						</td>
					</tr>
					<tr>
						<td><label>试题管理</label></td>
						<td>
							<label><input type="checkbox">技能提管理</label>
							<label><input type="checkbox">理论题管理</label>
							<label><input type="checkbox">预选项管理</label>
							<label><input type="checkbox">试题审核</label>
						</td>
					</tr>
					<tr>
						<td><label>试卷管理</label></td>
						<td>
							<label><input type="checkbox">技能卷管理</label>
							<label><input type="checkbox">理论卷管理</label>
							<label><input type="checkbox">试卷审核</label>
						</td>
					</tr>
					<tr>
						<td><label>考试管理</label></td>
						<td>
							<label><input type="checkbox">考试管理</label>
						</td>
					</tr>
					<tr>
						<td><label>系统设置</label></td>
						<td>
							<label><input type="checkbox">用户管理</label>
							<label><input type="checkbox">角色管理</label>
							<label><input type="checkbox">权限管理</label>
						</td>
					</tr>
					<tr>
						<td><label>成绩查询</label></td>
						<td>
							<label><input type="checkbox">成绩查询</label>
							<label><input type="checkbox">成绩分析</label>
						</td>
					</tr>
					<tr>
						<td><label>制作考试宝</label></td>
						<td>
							<label><input type="checkbox">制作考试宝</label>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</body>
	
	<script src="<@s.url '/plugin/jquery/jquery-1.12.3.min.js'/>" type="text/javascript"></script>
	<script src="<@s.url '/plugin/bootstrap/js/bootstrap.min.js'/>" type="text/javascript"></script>

</html>