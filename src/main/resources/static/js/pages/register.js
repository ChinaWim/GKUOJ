var numberCount = 30;
var interval;
var sendEmail = $("#sendEmail");

/**
 * 发送邮件
 */
function send() {
    var email = $("#email").val();
    var imageCode = $("#imageCode").val();
    if (!email || !imageCode) {
        toastr.warning("输入不能为空哦", "提示");
        return;
    }
    var reg = new RegExp("^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$");
    if (!reg.test(email)) {
        toastr.warning("请输入正确的邮箱", "提示");
        return;
    }
    var fa = "<i class=\"fa fa-spinner fa-pulse\"></i>";
    sendEmail.addClass("disabled");
    sendEmail.html(fa + "&nbsp;正在发送");
    $("#imageCodeImg").attr("src", "validate/code");
    $.post("user/sendRegisterEmail", {"email": email, "imageCode": imageCode}, function (resp) {
        if (resp.status == 200) {
            sendEmail.html("剩余" + numberCount + "秒");
            toastr.success("发送成功", "SUCCESS");
            interval = window.setInterval("subNumber()", 1000);
        } else {
            sendEmail.removeClass("disabled");
            sendEmail.html("发送验证邮件");
            toastr.error(resp.msg, "错误提示");
        }
    });
}

/**
 * 倒计时减一
 */
function subNumber() {
    if (numberCount == 1) {
        if (interval) {
            clearInterval(interval);
        }
        sendEmail.removeClass("disabled");
        sendEmail.html("发送验证邮件");
        numberCount = 30;
        return;
    }
    numberCount--;
    sendEmail.html("剩余" + numberCount + "秒");
}











