function forgetSubmit(){
    var password = $("#password").val();
    var rePassword = $("#rePassword").val();
    if(!password || !rePassword){

        $.message({
            message:'输入不能为空',
            type:'warning'
        });
        return;
    }
    if(rePassword != password){
        $.message({
            message:'两次密码不相等',
            type:'warning'
        });
        return;
    }
    if(password.length < 6){
        $.message({
            message:'密码不能少于６个字符',
            type:'warning'
        });
        return;
    }
    $.post("user/forgetSubmitProcess", {"password": password}, function (resp) {
        if (resp.status == 200) {
            $.message({
                message:'重置成功',
                type:'success'
            });
        } else {
            $.message({
                message:resp.msg,
                type:'error'
            });
        }
    });
}


