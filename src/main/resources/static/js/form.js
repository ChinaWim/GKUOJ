"use strict";
    function loadjscssfile(filename, filetype) {
        if (filetype == "css") {
            var fileref = document.createElement("link");
            fileref.rel = "stylesheet";
            fileref.type = "text/css";
            fileref.href = 'css/skins/' + filename;
            $("#skin_change").attr("href", "css/skins/"+filename+"")
        }
    }


;(function($){
  
  Admire.formGeneral = function() {
    $('.with-tooltip').tooltip({
        selector: ".input-tooltip"
    });
    /*----------- BEGIN autosize CODE -------------------------*/
    if($('#autosize').length){
        $('#autosize').autosize();
    }
    /*----------- END autosize CODE -------------------------*/

    /*----------- BEGIN inputlimiter CODE -------------------------*/
    $('#limiter').inputlimiter({
        limit: 140,
        remText: 'You only have %n character%s remaining...',
        limitText: 'You\'re allowed to input %n character%s into this field.'
    });
    /*----------- END inputlimiter CODE -------------------------*/

    /*----------- BEGIN uniform CODE -------------------------*/
    $('.uniform').uniform();
    /*----------- END uniform CODE -------------------------*/

    /*----------- BEGIN validVal CODE -------------------------*/
    $('#validVal').validVal();
    /*----------- END validVal CODE -------------------------*/

};
  
  return Admire;
})(jQuery);
;(function($){
  
  Admire.formValidation = function() {
    /*----------- BEGIN validationEngine CODE -------------------------*/
    $('#popup-validation').validationEngine();
    /*----------- END validationEngine CODE -------------------------*/

    /*----------- BEGIN validate CODE -------------------------*/
    $('#inline-validate').validate({
        rules: {
            required: "required",
            email: {
                required: true,
                email: true
            },
            date: {
                required: true,
                date: true
            },
            url: {
                required: true,
                url: true
            },
            password: {
                required: true,
                minlength: 5
            },
            confirm_password: {
                required: true,
                minlength: 5,
                equalTo: "#password"
            },
            agree: "required",
            minsize: {
                required: true,
                minlength: 3
            },
            maxsize: {
                required: true,
                maxlength: 6
            },
            minNum: {
                required: true,
                min: 3
            },
            maxNum: {
                required: true,
                max: 16
            }
        },
        errorClass: 'help-block col-lg-6',
        errorElement: 'span',
        highlight: function(element, errorClass, validClass) {
            $(element).parents('.form-group').removeClass('has-success').addClass('has-error');
        },
        unhighlight: function(element, errorClass, validClass) {
            $(element).parents('.form-group').removeClass('has-error').addClass('has-success');
        }
    });


    $('#block-validate').validate({
        rules: {
            required2: "required",
            email2: {
                required: true,
                email: true
            },
            date2: {
                required: true,
                date: true
            },
            url2: {
                required: true,
                url: true
            },
            password2: {
                required: true,
                minlength: 5
            },
            confirm_password2: {
                required: true,
                minlength: 5,
                equalTo: "#password2"
            },
            agree2: "required",
            digits: {
                required: true,
                digits: true
            },
            range: {
                required: true,
                range: [5, 16]
            }
        },
        errorClass: 'help-block',
        errorElement: 'span',
        highlight: function(element, errorClass, validClass) {
            $(element).parents('.form-group').removeClass('has-success').addClass('has-error');
        },
        unhighlight: function(element, errorClass, validClass) {
            $(element).parents('.form-group').removeClass('has-error').addClass('has-success');
        }
    });
    /*----------- END validate CODE -------------------------*/
};
  
  return Admire;
})(jQuery);
;(function($, Admire) {
  
  Admire.formWizard = function() {

    /*----------- BEGIN uniform CODE -------------------------*/
    $('#fileUpload').uniform();
    /*----------- END uniform CODE -------------------------*/

    /*----------- BEGIN plupload CODE -------------------------*/
    $("#uploader").pluploadQueue({
        runtimes: 'html5,html4',
        url: 'form-wysiwyg.html',
        max_file_size: '128kb',
        unique_names: true,
        filters: [
            {
                title: "Image files",
                extensions: "jpg,gif,png"
            }
        ]
    });
    /*----------- END plupload CODE -------------------------*/

    /*----------- BEGIN formwizard CODE -------------------------*/
    $("#wizardForm").formwizard({
        formPluginEnabled: true,
        validationEnabled: true,
        focusFirstInput: true,
        formOptions: {
            beforeSubmit: function(data) {
                $.gritter.add({
                    // (string | mandatory) the heading of the notification
                    title: 'data sent to the server',
                    // (string | mandatory) the text inside the notification
                    text: $.param(data),
                    sticky: false
                });

                return false;
            },
            dataType: 'json',
            resetForm: true
        },
        validationOptions: {
            rules: {
                server_host: "required",
                server_name: "required",
                server_user: "required",
                server_password: "required",
                table_prefix: "required",
                table_collation: "required",
                username: {
                    required: true,
                    minlength: 3
                },
                usermail: {
                    required: true,
                    email: true
                },
                pass: {
                    required: true,
                    minlength: 6
                },
                pass2: {
                    required: true,
                    minlength: 6,
                    equalTo: "#pass"
                }
            },
            errorClass: 'help-block',
            errorElement: 'span',
            highlight: function(element, errorClass, validClass) {
                $(element).parents('.form-group').removeClass('has-success').addClass('has-error');
            },
            unhighlight: function(element, errorClass, validClass) {
                $(element).parents('.form-group').removeClass('has-error').addClass('has-success');
            }
        }
    });
    /*----------- END formwizard CODE -------------------------*/

};
  
  return Admire;
})(jQuery, Admire || {});
;(function($){
  Admire.formWysiwyg = function() {

    /*----------- BEGIN wysihtml5 CODE -------------------------*/
    $('#wysihtml5').wysihtml5();
    /*----------- END wysihtml5 CODE -------------------------*/

    /*----------- BEGIN Markdown.Editor CODE -------------------------*/
    var converter = Markdown.getSanitizingConverter();
    var editor = new Markdown.Editor(converter);
    editor.run();
    /*----------- END Markdown.Editor CODE -------------------------*/

    /*----------- BEGIN epiceditor CODE -------------------------*/
    var opts = {
        basePath: 'assets/lib/epiceditor'
    };
    var epiceditor = new EpicEditor(opts).load();
    /*----------- END epiceditor CODE -------------------------*/
};
return Admire;
})(jQuery);

;(function($){
  Admire.AdmireFile = function() {

    /*----------- BEGIN elfinder CODE -------------------------*/
    var elf = $('#elfinder').elfinder({
        url: 'assets/elfinder-2.0-rc1/php/connector.php'  // connector URL (REQUIRED)
                // lang: 'de',             // language (OPTIONAL)
    }).elfinder('instance');
    /*----------- END elfinder CODE -------------------------*/

};
  return Admire;
})(jQuery);
;(function($, Admire) {
    if (!$().sortable) {
        return;
    }
    var $sortable = $('.inner .row');
    Admire.admireSortable = function() {
        $sortable.sortable();
    };
    return Admire;
})(jQuery, Admire || {});


