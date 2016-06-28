$(function(){
	//返回按钮点击事件
	$("#back_role").click(function(){
		location.href = "/ksb/role/list";
	});
	
	//保存按钮点击事件
	$("#save_right").click(function(){
		var roleId = $("#role_name").attr("role_id");
		alert("baocun..."+roleId);
	});
});