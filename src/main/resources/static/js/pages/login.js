function login(){
    var username = $("#username").val();
    var password = $("#password").val();
    var imageCode = $("#imageCode").val();
    if(!username || !password || !imageCode){
        $.message({
            message:'输入不能为空',
            type:'warning'
        });
        return;
    }
    var content = $("#loginForm").serialize();
    $.post("user/loginProcess",content,function (resp) {
        if(resp.status == 200){
            location.href = "/";
        }else {
            $.message({
                message:resp.msg,
                type:'error'
            });
            $("#imageCodeImg").attr("src","validate/code");
        }
    });
}