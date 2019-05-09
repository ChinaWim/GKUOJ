$('.select2-data').val("").select2({
    theme: 'bootstrap4',
    placeholder: '选择一个板块'
});

/**
 * md
 */
var testEditor = editormd("editormd-div", {
    placeholder: "此处开始编写您要发布的内容...",
    width: "98%",
    height: 650,
    path: '/plugins/markdown/lib/',
    markdown: '',
    codeFold: true,
    /* theme: "dark",//工具栏主题
    previewTheme: "dark",//预览主题
    // editorTheme: "pastel-on-dark",//编辑主题  */
    saveHTMLToTextarea: true,
    searchReplace: true,
    htmlDecode: "style,script,iframe|on*",
    emoji: true,
    taskList: true,
    onfullscreen: function () {
        $("#tags-div").attr("style", "display:none");
        $("#left").attr("style", "display:none");
        $("#top").attr("style", "display:none");
    },
    onfullscreenExit: function () {
        $("#tags-div").attr("style", "display:''");
        $("#left").attr("style", "display:''");
        $("#top").attr("style", "display:''");
    },
    tocm: true,         // Using [TOCM]
    tex: true,                   // 开启科学公式TeX语言支持，默认关闭
    flowChart: true,             // 开启流程图支持，默认关闭
    sequenceDiagram: true,       // 开启时序/序列图支持，默认关闭,
    imageUpload: true,
    imageFormats: ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
    imageUploadURL: "file/uploadImageByMD",
    onload: function () {
    }
});


/**
 * save blog
 */
function saveBlog() {
    var content = testEditor.getMarkdown();       // 获取 Markdown 源码
    var htmlContent = testEditor.getHTML();           // 获取 Textarea 保存的 HTML 源码
    var tags = $("#tags").val();
    var bcId = $("#bcId").val();
    var title = $("#title").val();
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

    $.post("blog/saveBlog",
        {
            "content": content, "htmlContent": htmlContent,
            "title": title, "bcId": bcId, "tags": tags
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

function goToBlogListPage(url){
    location.href = "blog/blogListPage";
}