$().ready(function() {
    validateRule();
    var sexHidden = $("#sexHidden").val();
    console.log("#sexHidden:"+sexHidden);
    $("#sex").val(sexHidden);
    var professionHidden = $("#professionHidden").val();
    console.log("#professionHidden:"+professionHidden);
    $("#profession").val(professionHidden);

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
        url : "/certificationManager/update/",
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

    var sexHidden = $("#sexHidden").val();
        console.log("#sexHidden:"+sexHidden);
        $("#sex").find("option[value="+sexHidden+"]").attr("selected","selected");
    var icon = "<i class='fa fa-times-circle'></i> ";
    $("#signupForm").validate({
        // rules : {
        // 	name : {
        // 		required : true
        // 	}
        // },
        // messages : {
        // 	name : {
        // 		required : icon + "请输入姓名"
        // 	}
        // }
    })
}

