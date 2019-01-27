$().ready(function() {
	validateRule();
    layui.use(['layer', 'form'], function(){
        var activityThemeId = window.sessionStorage.getItem('activityThemeId');
        // var activityParentId = window.sessionStorage.getItem('activityParentId');
        var layer = layui.layer, $ = layui.jquery,form = layui.form;
        var url = "/items/getActivityThemeItemsList";
        var merchantId = $('#merchantId').val();
        $.ajax({
            url:url,
            type:"POST",
            data:JSON.stringify({merchantId:merchantId}),
            contentType:"application/json; charset=utf-8",
            dataType:"json",
            success: function(res){
                if(!res){
                    return
                }
                var activityThemeIdHtml = "<option value=''>请选择</option>";
                res.forEach(item =>{
                    activityThemeIdHtml += `<option value='${item.id}' ${activityThemeId == item.id ? "selected":""}>${item.themeName}</option>`
                })
                $("#activityThemeId").html(activityThemeIdHtml);
                layui.form.render();

                // $.ajax({
                //     url:"/items/getActivityItemsList",
                //     type:"POST",
                //     data:JSON.stringify({merchantId:merchantId,activityThemeId:activityThemeId}),
                //     contentType:"application/json; charset=utf-8",
                //     dataType:"json",
                //     success: function(res) {
                //         if(!res){
                //             return
                //         }
                //         var activityParentIdHtml = "<option value=''>请选择</option>";
                //         res.forEach(item => {
                //             activityParentIdHtml += `<option value=${item.id} ${activityParentId == item.id ? "selected":""}>${item.activityAddress}</option>`
                //         })
                //         $("#activityParentId").html(activityParentIdHtml);
                //         layui.form.render();
                //     }
                // })
            }
        })
    });

});

$.validator.setDefaults({
	submitHandler : function() {
		update();
	}
});
function update() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/offlineActivity/update",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("操作成功");
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);

			} else {
				parent.layer.alert(data.msg)
			}

		}
	});

}
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
            activityAddress : {
				required : true
			},
            activityStartTimeDesc: {
                required: true
            },
            activityEndTimeDesc: {
                required: true
            },
            activityPrice: {
                required: true
            },
            limitCount: {
                required: true
            },
            applyStartTimeDesc: {
                required: true
            },
            applyEndTimeDesc: {
                required: true
            },
            activityThemeId: {
                required: true
            },
            minRequirement: {
                required: true
            },
		},
		messages : {
            activityAddress : {
				required : icon + "请输入地点"
			},
            activityStartTimeDesc: {
                required: icon + "请选择开课开始时间"
            },
            activityEndTimeDesc: {
                required: icon + "请选择开课结束时间"
            },
            activityPrice: {
                required: icon + "请填写价格"
            },
            limitCount: {
                required: icon + "请填写容纳人数"
            },
            applyStartTimeDesc: {
                required: icon + "请选择报名开始时间"
            },
            applyEndTimeDesc: {
                required: icon + "请选择报名结束时间"
            },
            activityThemeId: {
                required: icon + "请选择线下课程主题"
            },
            minRequirement: {
                required: icon + "请选择购买最低要求"
            },
		}
	})
}

layui.use('laydate', function(){
    var laydate = layui.laydate;
    laydate.render({
        elem: '#activityStartTime',
		type: 'datetime'
    });
});
layui.use('laydate', function(){
    var laydate = layui.laydate;
    laydate.render({
        elem: '#activityEndTime',
        type: 'datetime'
    });
});

layui.use('laydate', function(){
    var laydate = layui.laydate;
    laydate.render({
        elem: '#applyStartTime',
        type: 'datetime'
    });
});
layui.use('laydate', function(){
    var laydate = layui.laydate;
    laydate.render({
        elem: '#applyEndTime',
        type: 'datetime'
    });
});


// layui.use(['layer', 'form'], function(){
//     var layer = layui.layer, $ = layui.jquery,form = layui.form;
//     form.on('select(activityThemeId)', function(data){//一级主题选择的改变
//         if(!data){
//             return;
//         }
//         var url = "/items/getActivityItemsList";
//         var merchantId = $('#merchantId').val();
//         $.ajax({
//             url:url,
//             type:"POST",
//             data:JSON.stringify({merchantId:merchantId,activityThemeId:data.value}),
//             contentType:"application/json; charset=utf-8",
//             dataType:"json",
//             success: function(res){
//                 if(!res){
//                     return
//                 }
//                 var activityParentIdHtml = "<option value=''>请选择</option>";
//                 res.forEach(item=>{
//                     activityParentIdHtml+="<option value='"+item.id+"'>"+item.activityAddress+"</option>"
//                 })
//                 $("#activityParentId").html(activityParentIdHtml);
//                 layui.form.render();
//             }
//         })
//     });
//
// });

$( '.ckz-radio').on('click','.layui-form-radio', function(){
    if($(this).children('div')[0].innerText == '复训'){
        $('.ckz').removeClass('hide');
    }else{
        $('.ckz').addClass('hide');
    }
});