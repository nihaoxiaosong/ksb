$(function(){
	//返回按钮点击事件
	$("#back_role").click(function(){
		location.href = "/ksb/role/list";
	});
	
	//保存按钮点击事件
	$("#save_right").click(function(){
		var roleId = $("#role_name").attr("role_id");
		var moduleIds = new Array();
		$("input:checkbox[name='module']:checked").each(function(i){
			var moudleId = $(this).attr("module_id");
			moduleIds[i] = moudleId;
		});
		alert("baocun..."+roleId);
		
		$.ajax({
			url: "/ksb/right/save",
			dataType:'json',
			type:'post',
			data:{
				"roleId" : roleId,
				"moduleIds" : moduleIds
			},
			async : true,
			success: function(data){
				location.href = "/ksb/right/list?roleId="+roleId;
			},
			error:function(data){
				alert("啊呀,报错了...联系 QQ 363059330...");
			}
		});
		
	});
});