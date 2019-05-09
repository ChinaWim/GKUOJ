"use strict";
/**
 *  ace editor init
 */
var editor = ace.edit("editor");
ace.require("ace/ext/language_tools");
editor.$blockScrolling = Infinity;
editor.setFontSize(18);
editor.getSession().setTabSize(4);
//代码折叠
editor.getSession().setUseWrapMode(true);
//设置打印边距可见度
editor.setShowPrintMargin(false);
editor.session.setMode("ace/mode/java");
editor.setTheme("ace/theme/monokai");
editor.setOptions({
    enableBasicAutocompletion: false,
    enableSnippets: true,
    enableLiveAutocompletion: true
});

/**
 * 选择语言
 * @param type
 */
function setCodeType(type) {
    $("#dropdownMenuButton").html(type);
    $("#type").val(type);
    if ("C" == type) {
        editor.session.setMode("ace/mode/c_cpp");
        editor.setValue("#include <stdio.h>\n" +
            "\n" +
            "int main() {\n" +
            "    int a,b;\n" +
            "    scanf(\"%d%d\",&a,&b);\n" +
            "    printf(\"%d\", a+b);\n" +
            "    return 0;\n" +
            "}");
    } else if ("C++" == type) {
        editor.session.setMode("ace/mode/c_cpp");
        editor.setValue("#include <iostream>\n" +
            "#include <cstdio>\n" +
            "\n" +
            "using namespace std;\n" +
            "\n" +
            "int main() {\n" +
            "    int a,b;\n" +
            "    cin >> a >> b;\n" +
            "    cout << a+b;\n" +
            "    return 0;\n" +
            "}");
    } else if ("Java8" == type) {
        editor.session.setMode("ace/mode/java");
        editor.setValue("import java.io.*;\n" +
            "import java.util.*;\n" +
            "public class Main {\n" +
            "    public static void main(String args[]) throws Exception {\n" +
            "        Scanner cin=new Scanner(System.in);\n" +
            "        int a = cin.nextInt(), b = cin.nextInt();\n" +
            "        System.out.println(a+b);\n" +
            "    }\n" +
            "}");
    } else if ("Python2" == type) {
        editor.session.setMode("ace/mode/python");
        editor.setValue("s = raw_input().split()\n" +
            "print int(s[0]) + int(s[1])");
        $("#dropdownMenuButton").html("python2");
    } else if ("Python3" == type) {
        editor.session.setMode("ace/mode/python");
        editor.setValue("s = input().split()\n" +
            "print(int(s[0]) + int(s[1]))");
    }
    editor.moveCursorTo(0, 0);
};


/**
 * 提交代码
 */
function submit(problemName, compId) {
    var type = $("#type").val();
    var sourceCode = editor.getValue();
    if (!type || type == -1) {
        $.message({
            message: "请选择编程语言",
            type: 'warning'
        });
        return;
    }
    if (!sourceCode) {
        $.message({
            message: "请编写代码",
            type: 'warning'
        });
        return;
    }
    swal({
        title: '确认提交代码?',
        // text: '提醒',
        type: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#EF6F6C',
        cancelButtonColor: '#4fb7fe',
        confirmButtonText: '确定',
        cancelButtonText: '取消'
    }).then(function () {
        $.post("problemResult/submit", {
            "problemId": problemId,
            "compId": compId,
            "type": type,
            "sourceCode": sourceCode
        }, function (resp) {
            if (resp.status == 200) {
                var runNum = resp.data;
                var html = "<div class='text-center' id = '" + runNum + "'>" +
                    "<i class='fa fa-circle-o-notch fa-lg fa-spin text-primary'></i>" +
                    "<span class='ml-3' id = '" + runNum + "-Str'>队列中</span></div>";

                naranja()["log"]({
                    icon: false,
                    title: problemName,
                    text: html,
                    timeout: 'keep'
                });
                var problemResultNowInterval = window.setInterval(function () {
                    problemResultNow(runNum, problemResultNowInterval)
                }, 500);
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

/**
 * 拉取题目测评结果
 * @param runNum
 * @param problemResultNowInterval
 */
function problemResultNow(runNum, problemResultNowInterval) {
    $.post("problemResult/problemResultNow", {"runNum": runNum}, function (resp) {
        if (resp.status == 200) {
            if (resp.data.status != 0 && resp.data.status != 8 && resp.data.status != 9) {
                window.clearInterval(problemResultNowInterval);
                var color = getColorByStatus(resp.data.status);
                var str = getStrByStatus(resp.data.status);
                var usedTime = resp.data.time;
                var usedMemory = resp.data.memory;
                var problemResultId = resp.data.id;
                var href = "/problemResult/problemResultDetailPage?problemResultId=" + problemResultId;
                var html = "<a class='mr-2 btn-sm text-white' style='background-color: " + color + "'>" + str + "</a>" +
                    "<a class='btn-success mr-2 btn-sm text-white'>" + usedTime + "ms</a>" +
                    "<a class='btn-success mr-2 btn-sm text-white'>" + usedMemory + "KB</a>" +
                    "<a href=" + href + " class='btn btn-info btn-sm text-white'>查看详情</a>";

                var runNumItem = $("#" + runNum + "");
                runNumItem.html(html);
                runNumItem.attr("class","text-left");
            } else {
                var str = getStrByStatus(resp.data.status);
                $("#" + runNum + "-Str").html(str);
            }
        } else {
            window.clearInterval(problemResultNowInterval);
            $.message({
                message: resp.msg,
                type: 'error'
            });
        }
    });
}

/**
 * end of 提交代码
 */


/**
 * 测试样例运行
 */
function testRun() {

    var inputHtml = $("#testInput").val();
    var eOutputHtml = $("#eOutput").val();
    if (!inputHtml || !eOutputHtml) {
        $.message({
            message: '输入不能为空',
            type: 'warning'
        });
    }
}


/**
 * 复制测试样例
 */
function copyToClipboard() {
    $.message({
        message: '复制成功',
        type: 'success'
    });
}



