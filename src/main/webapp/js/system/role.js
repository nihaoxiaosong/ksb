$(function() {
	//查询按钮点击事件
	$("#query").click(function(){
		var keyWord = $("#keyWord").val();
		location.href = "/ksb/role/list?keyWord="+keyWord;
	});
	
	//重置按钮点击事件
	$("#reset").click(function(){
		$("#keyWord").val("");
		location.href = "/ksb/role/list";
	});
	
	//删除按钮点击事件
	$("input[name='delete_role']").click(function() {
		//摸态框居中
//		$("#delete_modal").on('shown.bs.modal', function() {
//			var $this = $(this);
//			var $modal_dialog = $this.find('.modal-dialog');
//			var m_top = ($(document).height() - $modal_dialog.height()) / 2;
//			$modal_dialog.css({
//				'margin' : m_top + 'px auto'
//			});
//		});
		//摸态框显示
		$("#delete_modal").modal();
		var delete_id = $(this).attr("role_id");
		$("#delete_id").val(delete_id);
	});
	
	//删除确认按钮点击事件
	$("#delete_confirm").click(function(){
		var role_id = $("#delete_id").val();
		$.ajax({
			url: "/ksb/role/delete",
			dataType:'json',
			type:'post',
			data:{
				"roleId": role_id
			},
			async : true,
			success: function(data){
				$("#delete_id").val("");
				location.href = "/ksb/role/list";
			},
			error:function(data){
				alert("啊呀,报错了...联系 QQ 363059330...");
			}
		});
	});
	
	//新增按钮点击事件
	$("#add_role").click(function(){
		//摸态框显示
		$("#add_modal").modal();
	});
	
	//保存按钮点击事件
	$("#add_confirm").click(function(){
		var role_code = $("#role_code").val();
		var role_name = $("#role_name").val();
		$.ajax({
			url: "/ksb/role/add",
			dataType:'json',
			type:'post',
			data:{
				"code": role_code,
				'name': role_name
			},
			async : true,
			success: function(data){
				location.href = "/ksb/role/list";
			},
			error:function(data){
				alert("啊呀,报错了...联系 QQ 363059330...");
			}
		});
	});
	
	//修改状态
	$("a[name='change_status']").click(function(){
		var role_id=$(this).attr("role_id");
		var enable=$(this).attr("enable");
		var status = 0;
		if(enable==0){
			status = 1;
		}else if(enable==1){
			status = 0;
		}
		$.ajax({
			url: "/ksb/role/changeStatus",
			dataType:'json',
			type:'post',
			data:{
				"roleId": role_id,
				'enable': status
			},
			async : true,
			success: function(data){
				location.href = "/ksb/role/list";
			},
			error:function(){
			}
		});
	});
	//修改按钮点击事件
	$("input[name='update_role']").click(function(){
		var role_id = $(this).attr("role_id");
		alert("修改功能..."+role_id);
	});
	//权限设置按钮点击事件
	$("input[name='right']").click(function(){
		var role_id = $(this).attr("role_id");
		alert("权限设置..."+role_id);
		location.href = "/ksb/right/list";
	});
	
});
