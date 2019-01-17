function login(){
    var username = $("#username").val();
    var password = $("#password").val();
    var imageCode = $("#imageCode").val();
    if(!username || !password || !imageCode){
        toastr.info("输入不能为空哦","提示");
        return;
    }
    var content = $("#loginForm").serialize();
    $.post("user/loginProcess",content,function (resp) {
        if(resp.status == 200){
            location.href = "index"
        }else {
            toastr.error(resp.msg,"错误提示");
            $("#imageCodeImg").attr("src","validate/code");
        }
    });
}