"use strict";
$(function () {

});

function skipProblemDetail() {
    var problemId = $("#problemId").val();
    if (!problemId) {
        toastr.warning("输入不能为空", "提示");
        return;
    }
    location.href = "problem/problemDetailPage?problemId=" + problemId;
}



