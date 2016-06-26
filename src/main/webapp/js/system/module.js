$(function(){
	//删除按钮点击事件
	$("input[name='delete_module']").click(function(){
		$("#delete_modal").modal();
	});
	//新增按钮点击事件
	$("#add_module").click(function(){
		$("#add_modal").modal();
	});
	//保存按钮点击事件
	$("#add_confirm").click(function(){
		alert(111);
		var parent_code = $("#parent_code").val();
		var module_code = $("#module_code").val();
		var module_name = $("#module_name").val();
		var module_url = $("#module_url").val();
		var module_seq = $("#module_seq").cal();
		$.ajax({
			url: "/module/add",
			dataType:'json',
			type:'post',
			data:{
				"parentCode":parent_code,
				"code":module_code,
				"name":module_name,
				"url":module_url,
				"seq":module_url
			},
			async : true,
			success: function(data){
				alert(222);
			},
			error:function(){
			}
		});
	});
});