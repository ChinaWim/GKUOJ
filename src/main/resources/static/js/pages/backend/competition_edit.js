/**
 * md
 */


/**
 * save
 */
function saveCompetition() {

    var content = testEditor.getMarkdown();       // 获取 Markdown 源码
    var htmlContent = testEditor.getHTML();           // 获取 Textarea 保存的 HTML 源码
    var name = $("#name").val();
    var title = $("#title").val();
    var startTime = $("#startTime").val();
    var endTime = $("#endTime").val();
    var password = $("#password").val();
    var compId = $("#compId").val();
    if (!name) {
        $.message({
            message: "比赛名称不能为空",
            type: "warning"
        });
        return false;
    }

    if (!title) {
        $.message({
            message: "比赛说明不能为空",
            type: "warning"
        });
        $("#title").focus();
        return false;
    }


    if (!startTime) {
        $.message({
            message: "开始时间不能为空",
            type: "warning"
        });
        return false;
    }
    if (!endTime) {
        $.message({
            message: "结束时间不能为空",
            type: "warning"
        });
        return false;
    }
    if (!content) {
        $.message({
            message: "详细内容不能为空",
            type: "warning"
        });
        return false;
    }
    $.post("/backend/competition/save",
        {
            "id":compId,
            "content":content,
            "htmlContent":htmlContent,
            "name":name,
            "title":title,
            "startTime":startTime,
            "endTime":endTime,
            "password":password
        }, function (resp) {
            if (resp.status == 200) {
                $.message({
                    message: resp.msg,
                    type: "success"
                });
                $("#compId").val(resp.data.id);
            } else {
                $.message({
                    message: resp.msg,
                    type: "error"
                });
            }
        });
}



function addProblem2Comp(problemNum) {
    var compId = $("#compId").val();
    $("#problemNum").val(problemNum);
    $("#compProblemId").val("");
    $("#score").val("");
}


function updateProblem2Comp(compProblemId,problemNum,score) {
    $("#compProblemId").val(compProblemId);
    $("#problemNum").val(problemNum);
    $("#score").val(score);
}

function checkCompId() {
    var compId = $("#compId").val();
    if(compId === -1){
        $.message({
            message: "请先创建比赛",
            type: "error"
        });
        return false;
    }
}


function saveProblem2Competition() {
    var compId = $("#compId").val();
    if (!compId || compId.trim().length === 0) {
        $.message({
            message: "请先创建比赛",
            type: "error"
        });
        return false;
    }
    var compProblemId = $("#compProblemId").val();
    var problemId = $("#problemNum").val();
    var score = $("#score").val();

    if (!score) {
        $.message({
            message: "题目分值不能为空",
            type: "warning"
        });
        return false;
    }


    $.post("/backend/competitionProblem/save",
        {
            "id":compProblemId,
            "problemId":problemId,
            "compId":compId,
            "score":score
        }, function (resp) {
            if (resp.status == 200) {
                $.message({
                    message: resp.msg,
                    type: "success"
                });
                $("#closeEditScore").click();
                wrap.listCompetitionProblem(1);
            } else {
                $.message({
                    message: resp.msg,
                    type: "error"
                });
            }
        });
}




function deleteProblem2Competition(competitionProblemId) {
    swal({
        title: '确认删除该题目吗?',
        // text: '提醒',
        type: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#EF6F6C',
        cancelButtonColor: '#4fb7fe',
        confirmButtonText: '确定',
        cancelButtonText: '取消'
    }).then(function () {
        $.post("/backend/competitionProblem/delete", {"competitionProblemId": competitionProblemId}, function (resp) {
            if (resp.status == 200) {
                $.message({
                    message: resp.msg,
                    type: 'success'
                });
                wrap.listCompetitionProblem(1);
            } else {
                $.message({
                    message: resp.msg,
                    type: 'error'
                });
            }
        })
    });
    return false;
}
