function register(){
    var email = $("#email").val();
    var imageCode = $("#imageCode").val();
    if(!email || !imageCode){
        toastr.info("输入不能为空哦","提示");
        return;
    }
    var reg = new RegExp("^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$");
    if(!reg.test(email)){
        toastr.info("请输入正确的邮箱","提示");
        return;
    }
    $.post("user/sendEmail",{"email":email,"imageCode":imageCode},function (resp) {
        if(resp.status == 200){

        }else {
            toastr.error(resp.msg,"错误提示");
            $("#imageCodeImg").attr("src","validate/code");
        }
    });
}