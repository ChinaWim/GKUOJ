/**
 * md
 */

/**
 * select2
 */
$('.select2-data').val("").select2({
    theme: 'bootstrap4',
    placeholder: '选择一个板块'
});


/**
 * save problem
 */
function saveProblem() {
    var id = $("#problemId").val();
    var content = problemDescEditor.getMarkdown();       // 获取 Markdown 源码
    var htmlContent = problemDescEditor.getHTML();           // 获取 Textarea 保存的 HTML 源码
    if (!title) {
        $.message({
            message: "标题不能为空",
            type: "warning"
        });
        $("#title").focus();
        return;
    }

    if (!bcId) {
        $.message({
            message: "请选择一个板块",
            type: "warning"
        });
        return;
    }

    if (!content) {
        $.message({
            message: "内容不能为空",
            type: "warning"
        });
        return;
    }

    $.post("backend/blog/save",
        {
            "content": content, "htmlContent": htmlContent,
            "title": title, "bcId": bcId, "tags": tags,"id":id
        }, function (resp) {
            if (resp.status == 200) {
                $.message({
                    message: resp.msg,
                    type: "success"
                });
                window.setTimeout("goToBlogListPage()",1000);
            } else {
                $.message({
                    message: resp.msg,
                    type: "error"
                });
            }
        });
}


function saveTestcase() {
    var id = $("#blogId").val();
    var content = testEditor.getMarkdown();       // 获取 Markdown 源码
    var htmlContent = testEditor.getHTML();           // 获取 Textarea 保存的 HTML 源码
    if (!title) {
        $.message({
            message: "标题不能为空",
            type: "warning"
        });
        $("#title").focus();
        return;
    }

    if (!bcId) {
        $.message({
            message: "请选择一个板块",
            type: "warning"
        });
        return;
    }

    if (!content) {
        $.message({
            message: "内容不能为空",
            type: "warning"
        });
        return;
    }

    $.post("backend/blog/save",
        {
            "content": content, "htmlContent": htmlContent,
            "title": title, "bcId": bcId, "tags": tags,"id":id
        }, function (resp) {
            if (resp.status == 200) {
                $.message({
                    message: resp.msg,
                    type: "success"
                });
                window.setTimeout("goToBlogListPage()",1000);
            } else {
                $.message({
                    message: resp.msg,
                    type: "error"
                });
            }
        });
}

function addTestcase(){
    var testcase_html = "<div class=\"row testcase-input\" id=\"ADD-TESTCASE\">\n" +
        "                                                    <div class=\"col-5 mt-3\">\n" +
        "                                                        <textarea class=\"form-control\" placeholder=\"输入\" style=\"height: 90px\"></textarea>\n" +
        "                                                    </div>\n" +
        "                                                    <div class=\"col-5 mt-3\">\n" +
        "                                                        <textarea class=\"form-control\" placeholder=\"结果\" style=\"height: 90px\"></textarea>\n" +
        "                                                    </div>\n" +
        "                                                    <div class=\"col-2 mt-3\">\n" +
        "                                                        <a href=\"javascript:void(0)\" onclick=\"removeTestcase(ID_LENGTH)\"  ><i class=\"fa-lg fa fa-trash\"></i></a>\n" +
        "                                                    </div>\n" +
        "                                                </div>"

    var testcaseInput = $(".testcase-input");
    var length = testcaseInput.length + 1;
    testcase_html = testcase_html.replace("ADD-TESTCASE","testcase-"+length);
    testcase_html = testcase_html.replace("ID_LENGTH",length);
    $("#add-testcase").append(testcase_html);
}

function removeTestcase(id) {
    var length = $(".testcase-input").length;
    if (length === 1) {
        $.message({
            message:'至少添加一组',
            type:'warning'
        });
        return false;
    }
    var item = "#testcase-" + id;
    $(item).remove();
}



