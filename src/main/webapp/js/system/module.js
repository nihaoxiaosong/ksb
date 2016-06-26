$(function(){
	//删除按钮点击事件
	$("input[name='delete_module']").click(function(){
		$("#delete_modal").modal();
	});
	
	$("#add_module").click(function(){
		$("#add_modal").modal();
	});
});