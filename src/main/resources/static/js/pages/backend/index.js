"use strict";
$(function () {

});

function skipProblemDetail() {
    var problemId = $("#problemId").val();
    if (!problemId) {
        $.message({
            message:'输入不能为空',
            type:'warning'
        });
        return;
    }
    location.href = "problem/problemDetailPage?problemId=" + problemId;
}

function randomProblem() {
    $.message({
        message:'祝你好运',
        type:'info'
    });
    window.setTimeout("gotoProblem()",1500);
}
function gotoProblem(){
    window.location.href = "problem/randomProblem";
}



