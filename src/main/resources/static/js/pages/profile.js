"use strict";


function submitBase() {
    if (!checkBaseField()) {
        return false
    }

    swal({
        title: '确认更新基础信息?',
        // text: '提醒',
        type: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#EF6F6C',
        cancelButtonColor: '#4fb7fe',
        confirmButtonText: '确定',
        cancelButtonText:'取消'
    }).then(function () {
        var formData = new FormData($("#baseForm")[0]);
        $.ajax({
            url: '/user/updateBase',
            type: 'POST',
            data: formData,
            async: false,
            cache: false,
            contentType: false,
            processData: false,
            success: function (resp) {
                if (resp.status == 200) {
                    $.message({
                        message: resp.msg,
                        type: 'success'
                    });
                } else {
                    $.message({
                        message: resp.msg,
                        type: 'error'
                    });
                }
            }
        });
    });
}



function submitSecurity() {
    if (!checkSecurityField()) {
        return false
    }
    swal({
        title: '确认更新安全信息?',
        // text: '提醒',
        type: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#EF6F6C',
        cancelButtonColor: '#4fb7fe',
        confirmButtonText: '确定',
        cancelButtonText:'取消'
    }).then(function () {
        var formData = new FormData($("#securityForm")[0]);
        $.ajax({
            url: '/user/updateSecurity',
            type: 'POST',
            data: formData,
            async: false,
            cache: false,
            contentType: false,
            processData: false,
            success: function (resp) {
                if (resp.status == 200) {
                    $.message({
                        message: resp.msg,
                        type: 'success'
                    });
                } else {
                    $.message({
                        message: resp.msg,
                        type: 'error'
                    });
                }
            }
        });
    });
}


function checkBaseField() {
    var name = $("#name").val();
    if (name.trim() === '') {
        $.message({
            message:'输入不能为空',
            type:'warning'
        });
        return false;
    }
    return true;
}


function checkSecurityField(){
    var email = $("#email").val();
    var oldPassword = $("#oldPassword").val();
    var password = $("#password").val();
    var password2 = $("#password2").val();

    if (email.trim() === '' || oldPassword.trim() === ''
        || password.trim() === '' || password2.trim() === '' ) {
        $.message({
            message:'输入不能为空',
            type:'warning'
        });
        return false;
    }
    if (password !== password2) {
        $.message({
            message: '新密码前后输入不一致!',
            type: 'warning'
        });
        return false;
    }

    return true;
}