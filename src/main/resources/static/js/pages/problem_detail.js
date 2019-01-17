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
    if ("c" == type) {
        editor.session.setMode("ace/mode/c_cpp");
        editor.setValue("#include <stdio.h>\n" +
            "\n" +
            "int main() {\n" +
            "    int a,b;\n" +
            "    scanf(\"%d%d\",&a,&b);\n" +
            "    printf(\"%d\", a+b);\n" +
            "    return 0;\n" +
            "}");
        $("#dropdownMenuButton").html("c");
    } else if ("c++" == type) {
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
        $("#dropdownMenuButton").html("c++");
    } else if ("java8" == type) {
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
        $("#dropdownMenuButton").html("java8");
    } else if ("python2" == type) {
        editor.session.setMode("ace/mode/python");
        editor.setValue("s = raw_input().split()\n" +
            "print int(s[0]) + int(s[1])");
        $("#dropdownMenuButton").html("python2");
    } else if ("python3" == type) {
        editor.session.setMode("ace/mode/python");
        editor.setValue("s = input().split()\n" +
            "print(int(s[0]) + int(s[1]))");
        $("#dropdownMenuButton").html("python3");
    }
};

/**
 * 测试样例运行
 */
function testRun(){
    var inputHtml = $("#testInput").html;
    var eOutputHtml = $("#eOutput").html("");
        if (!inputHtml || !eOutputHtml){

        }


}


