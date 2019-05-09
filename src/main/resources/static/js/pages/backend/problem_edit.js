

/**
 * save problem
 */
function saveProblem() {
    var id = $("#problemId").val();
    var name = $("#name").val();
    var content = problemDescEditor.getMarkdown();       // 获取 Markdown 源码
    var htmlContent = problemDescEditor.getHTML();           // 获取 Textarea 保存的 HTML 源码
    var inputDesc = $("#inputDesc").val();
    var outputDesc = $("#outputDesc").val();
    var testcaseInput = $("#testcaseInput").val();
    var testcaseOutput = $("#testcaseOutput").val();
    var level = $("input[name='level']:checked").val();
    var tagsItem = $("#tags").val();
    if (!name) {
        $.message({
            message: "标题不能为空",
            type: "warning"
        });
        return;
    }
    if (!content) {
        $.message({
            message: "题目描述不能为空",
            type: "warning"
        });
        return;
    }

    if (!inputDesc) {
        $.message({
            message: "输入规范不能为空",
            type: "warning"
        });
        return;
    }

    if (!outputDesc) {
        $.message({
            message: "输出规范不能为空",
            type: "warning"
        });
        return;
    }

    if (!testcaseInput) {
        $.message({
            message: "题目样例输入不能为空",
            type: "warning"
        });
        return;
    }

    if (!testcaseOutput) {
        $.message({
            message: "题目样例输出不能为空",
            type: "warning"
        });
        return;
    }

    if (!level) {
        $.message({
            message: "难度不能为空",
            type: "warning"
        });
        return;
    }
    if (!tagsItem) {
        $.message({
            message: "标签至少一个",
            type: "warning"
        });
        return;
    }
    var tags = tagsItem.toString();
    if(tagsItem.length > 3){
        $.message({
            message: "标签至多三个",
            type: "warning"
        });
        return;
    }

    swal({
        title: '确认保存题目吗?',
        // text: '提醒',
        type: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#EF6F6C',
        cancelButtonColor: '#4fb7fe',
        confirmButtonText: '确定',
        cancelButtonText: '取消'
    }).then(function () {

        $.ajax({
            type: "POST",
            url: "backend/problem/save",
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify({
                "id":id,
                "content": content, "htmlContent": htmlContent,
                "name": name, "inputDesc":inputDesc ,"outputDesc":outputDesc,
                "testcaseInput": testcaseInput, "testcaseOutput":testcaseOutput,
                "level": level, "tags": tags,
                "testcaseList":wrap.testcaseList
            }),
            dataType: "json",
            success: function (resp) {
                if (resp.status === 200) {
                    $.message({
                        message: resp.msg,
                        type: "success"
                    });
                    $("#problemId").val(resp.data.id);
                } else {
                    $.message({
                        message: resp.msg,
                        type: "error"
                    });
                }
            },
            error: function (resp) {
                $.message({
                    message: resp,
                    type: "error"
                });
            }
        });

    }).catch(function (reason) {

    });


}


function saveTestcase() {
    var problemId = $("#problemId").val();
    var num = $("#num").val();
    var testcaseAnswerInput = $("#testcaseAnswerInput").val();
    var testcaseAnswerOutput = $("#testcaseAnswerOutput").val();
    if (!problemId) {
        $.message({
            message: "先创建题目",
            type: "warning"
        });
        return;
    }

    if (!testcaseAnswerInput) {
        $.message({
            message: "样例输入不能为空",
            type: "warning"
        });
        return;
    }
    if (!testcaseAnswerOutput) {
        $.message({
            message: "样例输出不能为空",
            type: "warning"
        });
        return;
    }
    $.post("backend/testcase/save",
        {
            "problemId": problemId, "testcaseOutput": testcaseAnswerOutput,
            "testcaseInput": testcaseAnswerInput,"num":num
        }, function (resp) {
            if (resp.status === 200) {
                $.message({
                    message: resp.msg,
                    type: "success"
                });
                wrap.listTestcase();
                $("#close").click();
            } else {
                $.message({
                    message: resp.msg,
                    type: "error"
                });
            }
        });
}

function addTestcase(){
    wrap.testcaseList.push({"num":wrap.testcaseList.length+1,"input":"","output":""});
}

function removeTestcase(id) {
    var length = wrap.testcaseList.length;
    if (length === 1) {
        $.message({
            message:'至少添加一组',
            type:'warning'
        });
        return false;
    }
    wrap.testcaseList.splice(id-1, 1);
}



function saveSetting() {
    var problemId = $("#problemId").val();
    if(!problemId){
        $.message({
            message:'先创建题目',
            type:'warning'
        });
        return false;
    }
    var time = $("#time").val();
    var memory = $("#memory").val();
    var flag = $("#flag").val();


    $.ajax({
        type: "POST",
        url: "backend/problem/save",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify({
            "id": problemId, "time": time,
            "memory": memory,"flag":flag,
            "settingUpdated": true
        }),
        dataType: "json",
        success: function (resp) {
            if (resp.status === 200) {
                $.message({
                    message: resp.msg,
                    type: "success"
                });
            } else {
                $.message({
                    message: resp.msg,
                    type: "error"
                });
            }
        },
        error: function (resp) {
            $.message({
                message: resp,
                type: "error"
            });
        }
    });

}



function deleteProblem() {
    var problemId = $("#problemId").val();
    if(!problemId){
        $.message({
            message:'先创建题目',
            type:'warning'
        });
        return false;
    }

    swal({
        title: '确认删除题目吗?',
        // text: '提醒',
        type: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#EF6F6C',
        cancelButtonColor: '#4fb7fe',
        confirmButtonText: '确定',
        cancelButtonText: '取消'
    }).then(function () {
        $.post("backend/problem/delete", {
            "problemId": problemId
        }, function (resp) {
            if (resp.status === 200) {
                $.message({
                    message: resp.msg,
                    type: 'success'
                });
                $("#problemId").val("");
            } else {
                $.message({
                    message: resp.msg,
                    type: 'error'
                });
            }
        });
    }).catch(function (reason) {

    });

}

function initTestcase() {
    $("#num").val("");
    $("#testcaseAnswerInput").val("");
    $("#testcaseAnswerOutput").val("");

}


function editTestcase(num,input,output) {
    $("#num").val(num);
    $("#testcaseAnswerInput").val(input);
    $("#testcaseAnswerOutput").val(output);

}

function deleteTestcase(num) {
    var problemId = $("#problemId").val();
    if(!problemId){
        $.message({
            message:'先创建题目',
            type:'warning'
        });
        return false;
    }

    swal({
        title: '确认该测试用例吗?',
        // text: '提醒',
        type: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#EF6F6C',
        cancelButtonColor: '#4fb7fe',
        confirmButtonText: '确定',
        cancelButtonText: '取消'
    }).then(function () {
        $.post("backend/testcase/delete", {
            "problemId": problemId,
            "num":num
        }, function (resp) {
            if (resp.status === 200) {
                $.message({
                    message: resp.msg,
                    type: 'success'
                });
                wrap.listTestcase();
            } else {
                $.message({
                    message: resp.msg,
                    type: 'error'
                });
            }
        });
    }).catch(function (reason) {

    });

}

