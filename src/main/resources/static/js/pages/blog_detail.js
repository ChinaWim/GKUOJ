/**
 * md
 */

var testEditor = editormd("editormd-div", {
    placeholder: "在这里畅所欲言你的看法吧！",
    width: "98%",
    height: 450,
    path: '/plugins/markdown/lib/',
    markdown: '',
    codeFold: true,
    autoFocus: false,
    /* theme: "dark",//工具栏主题
    previewTheme: "dark",//预览主题
    // editorTheme: "pastel-on-dark",//编辑主题  */
    saveHTMLToTextarea: true,
    searchReplace: true,
    htmlDecode: "style,script,iframe|on*",
    emoji: true,
    taskList: true,
    onfullscreen: function () {
        $("#left").attr("style", "display:none");
        $("#top").attr("style", "display:none");
    },
    onfullscreenExit: function () {
        $("#left").attr("style", "display:''");
        $("#top").attr("style", "display:''");
    },
    tocm: true,         // Using [TOCM]
    tex: true,                   // 开启科学公式TeX语言支持，默认关闭
    flowChart: true,             // 开启流程图支持，默认关闭
    sequenceDiagram: true,       // 开启时序/序列图支持，默认关闭,
    watch: true,//预览
    imageUpload: true,
    imageFormats: ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
    imageUploadURL: "file/uploadImageByMD",
    onload: function () {
    },
    toolbarIcons: function () {
        // Or return editormd.toolbarModes[name]; // full, simple, mini
        // Using "||" set icons align right.
        return ["undo", "redo", "|", "emoji", "code", "code-block", "link", "|", "bold", "italic", "quote", "uppercase", "lowercase", "|", "list-ul", "list-ol", "hr", "|", "watch", "preview", "clear", "|", "help"]
    }
});


function blogUp(blogId) {
    $.post("blog/blogUp", {"blogId": blogId}, function (resp) {
        if (resp.status == 200) {
            $("#blogDetailTitleUpCount").html(resp.data.count);
            if (resp.data.status) {
                $("#blogDetailUp").html("已赞");
                $("#blogDetailUpLove").removeClass("fa-heart-o");
                $("#blogDetailUpLove").addClass("fa-heart");
                $("#blogDetailUpLove").css("color","red");
            } else {
                $("#blogDetailUp").html("点赞");
                $("#blogDetailUpLove").removeClass("fa-heart");
                $("#blogDetailUpLove").addClass("fa-heart-o");
                $("#blogDetailUpLove").css("color","");
            }
        } else {
            $.message({
                message: resp.msg,
                type: "warning"
            });
        }

    });

}




/*
$.message({
    message: "内容不能为空",
    type: "warning"
});
*/
