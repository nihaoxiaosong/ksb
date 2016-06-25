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
		$("#delete_modal").on('shown.bs.modal', function() {
			var $this = $(this);
			var $modal_dialog = $this.find('.modal-dialog');
			var m_top = ($(document).height() - $modal_dialog.height()) / 2;
			$modal_dialog.css({
				'margin' : m_top + 'px auto'
			});
		});
		//摸态框显示
		$("#delete_modal").modal();
	});
	
	$("a[name='change_status']").click(function(){
		var role_id=$(this).attr("role_id");
		var enable=$(this).attr("enable");
		
	});
	
});

//更改角色状态
function change_status(roleId, enable){
	$.ajax({
		url: "/role/changeStatus",
		dataType:'json',
		type:'post',
		data:{
			"roleId": roleId,
			'enable': enable
		},
		async : true,
		success: function(data){
			location.href = "/ksb/role/list";
		},
		error:function(){
		}
	});
}




