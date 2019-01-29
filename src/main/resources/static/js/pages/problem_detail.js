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
        $("#type").val("python2");
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
function submit() {
    var type = $("#type").val();
    var sourceCode = editor.getValue();
    if (!type || type == -1) {
        $.message({
            message:"请选择编程语言",
            type:'warning'
        });
        return;
    }
    if (!sourceCode) {
        $.message({
            message:"请编写代码",
            type:'warning'
        });
        return;
    }

    $.post("problemResult/submit", {
        "problemId": problemId,
        "type": type,
        "sourceCode": sourceCode
    }, function (resp) {
        if (resp.status == 200) {
            $.message({
                message:resp.msg,
                type:'success'
            });
        } else {
            $.message({
                message:resp.msg,
                type:'error'
            });
        }
    });
}

/**
 * 消息框
 */

/**
 * 测试样例运行
 */
function testRun() {

    var inputHtml = $("#testInput").val();
    var eOutputHtml = $("#eOutput").val();
    if (!inputHtml || !eOutputHtml) {
        $.message({
            message:'输入不能为空',
            type:'warning'
        });
    }
}


/**
 * 复制测试样例
 */
function copyToClipboard() {
}



