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
		var parent_code = $("#parent_code").find("option:selected").attr("id");
		var module_code = $("#module_code").val();
		var module_name = $("#module_name").val();
		var module_url = $("#module_url").val();
		var module_seq = $("#module_seq").val();
		$.ajax({
			url: "/ksb/module/add",
			dataType:'json',
			type:'post',
			data:{
				"parentCode":parent_code,
				"code":module_code,
				"name":module_name,
				"url":module_url,
				"seq":module_seq
			},
			async : true,
			success: function(data){
				location.href = "/ksb/module/list";
			},
			error:function(data){
				alert("啊呀,报错了...联系 QQ 363059330...");
			}
		});
	});
});