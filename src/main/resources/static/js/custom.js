"use strict";
(function ($, window, document, undefined) {


    var pluginName = "metisMenu",
        defaults = {
            toggle: true,
            doubleTapToGo: false
        };

    function Plugin(element, options) {
        this.element = element;
        this.settings = $.extend({}, defaults, options);
        this._defaults = defaults;
        this._name = pluginName;
        this.init();
    }

    Plugin.prototype = {
        init: function () {
            var $this = $(this.element),
                $toggle = this.settings.toggle,
                obj = this
            if (this.isIE() <= 9) {
                $this.find("li.active").has("ul").children("ul").collapse("show");
                $this.find("li").not(".active").has("ul").children("ul").collapse("hide");
            } else {
                $this.find("li.active").has("ul").children("ul").addClass("collapse show");
                $this.find("li").not(".active").has("ul").children("ul").addClass("collapse");
            }
            //add the "doubleTapToGo" class to active items if needed
            if (obj.settings.doubleTapToGo) {
                $this.find("li.active").has("ul").children("a").addClass("doubleTapToGo");
            }
            $this.find("li").has("ul").children("a").on("click", function (e) {
                e.preventDefault();
                //Do we need to enable the double tap
                if (obj.settings.doubleTapToGo) {
                    //if we hit a second time on the link and the href is valid, navigate to that url
                    if (obj.doubleTapToGo($(this)) && $(this).attr("href") !== "#" && $(this).attr("href") !== "") {
                        e.stopPropagation();
                        document.location = $(this).attr("href");
                        return;
                    }
                }
                $(this).parent("li").toggleClass("active").children("ul").collapse({
                    toggle: true,
                    animate: false
                });
                $this.find("li.active").has("ul").children("ul").addClass("collapse show");
                if ($toggle) {
                    $(this).parent("li").siblings().removeClass("active").children("ul.show").collapse("hide");
                    $this.find("li.active").has("ul").children("ul").addClass("collapse show");
                    $this.find("li").not(".active").has("ul").children("ul").removeClass("show");
                }
            });
        },
        isIE: function () { //https://gist.github.com/padolsey/527683
            var undef,
                v = 3,
                div = document.createElement("div"),
                all = div.getElementsByTagName("i");
            while (
                div.innerHTML = "<!--[if gt IE " + (++v) + "]><i></i><![endif]-->",
                    all[0]
                ) {
                return v > 4 ? v : undef;
            }
        },
        //Enable the link on the second click.
        doubleTapToGo: function (elem) {
            var $this = $(this.element);
            //if the class "doubleTapToGo" exists, remove it and return
            if (elem.hasClass("doubleTapToGo")) {
                elem.removeClass("doubleTapToGo");
                return true;
            }
            //does not exists, add a new class and return false
            if (elem.parent().children("ul").length) {
                //first remove all other class
                $this.find(".doubleTapToGo").removeClass("doubleTapToGo");
                //add the class on the current element
                elem.addClass("doubleTapToGo");
                return false;
            }
        }
    };
    $.fn[pluginName] = function (options) {
        this.each(function () {
            if (!$.data(this, "plugin_" + pluginName)) {
                $.data(this, "plugin_" + pluginName, new Plugin(this, options));
            }
        });
        return this;
    };
    $("#main li").hover(function () {
        $(this).find("i.fa").css("transform", "rotateY(150deg)")
    })
})(jQuery, window, document);
//    ==========menu hover===============

$('#messages').hover(function () {
    $(this).find('.dropdown-menu').stop(true, true).delay(200).fadeIn(200);
}, function () {
    $(this).find('.dropdown-menu').stop(true, true).delay(200).fadeOut(200);
});
function menu_default() {
    if ($("body").hasClass("sidebar-left-hidden")) {
        if($("#content").height() < 950){
            $(".sidebar-left-hidden #left").addClass("sm_content");
        }
        $("#menu>li").has("ul").children("a").off("click").on("click", function(e) {
            e.preventDefault();
        });
    } else {
        $("#left").removeClass("sm_content");
        $("#menu li").has("ul").children("a").off("click");
        $("#menu").find("li").has("ul").children("a").on("click", function (e) {
            e.preventDefault();
            $(this).parent("li").toggleClass("active").children("ul").collapse({
                toggle: true,
                animate: false
            });
            $("#menu").find("li.active").has("ul").children("ul").addClass("collapse show");
            $(this).parent("li").siblings().removeClass("active").children("ul.show").collapse("hide");
            $("#menu").find("li").not(".active").has("ul").children("ul").removeClass("show");
        });
    }
}
$("#menu li:nth-child(2)").find("ul").removeClass("sidebarbottom");
//        ======================
// skins js
function loadjscssfile(filename, filetype) {
    if (filetype == "css") {
        var fileref = document.createElement("link");
        fileref.rel = "stylesheet";
        fileref.type = "text/css";
        fileref.href = 'css/skins/' + filename;
        $("#skin_change").attr("href", "css/skins/"+filename+"")
    }
}

// End of skins js
//    ======================================core js=======================================
(function (window) {
    var
        // Is Modernizr defined on the global scope
        Modernizr = typeof Modernizr !== "undefined" ? Modernizr : false,
        // whether or not is a touch device
        isTouchDevice = Modernizr ? Modernizr.touch : !!('ontouch' in window || 'onmsgesturechange' in window),
        // Are we expecting a touch or a click?
        buttonPressedEvent = (isTouchDevice) ? 'touch' : 'click',
        Admire = function () {
            this.init();
        };
    // Initialization method
    Admire.prototype.init = function () {
        this.isTouchDevice = isTouchDevice;
        this.buttonPressedEvent = buttonPressedEvent;
    };
    Admire.prototype.getViewportHeight = function () {
        var docElement = document.documentElement,
            client = docElement.clientHeight,
            inner = window.innerHeight;
        if (client < inner)
            return inner;
        else
            return client;
    };
    Admire.prototype.getViewportWidth = function () {
        var docElement = document.documentElement,
            client = docElement.clientWidth,
            inner = window.innerWidth;
        if (client < inner)
            return inner;
        else
            return client;
    };
    // Creates a Admire object.
    window.Admire = new Admire();
})(this);
// =====================resize plugin===================
//  jQuery resize event - v1.1 - 3/14/2010
(function ($, h, c) {
    var a = $([]), e = $.resize = $.extend($.resize, {}), i, k = "setTimeout", j = "resize", d = j + "-special-event", b = "delay", f = "throttleWindow";
    e[b] = 250;
    e[f] = true;
    $.event.special[j] = {
        setup: function () {
            if (!e[f] && this[k]) {
                return false;
            }
            var l = $(this);
            a = a.add(l);
            $.data(this, d, {w: l.width(), h: l.height()});
            if (a.length === 1) {
                g();
            }
        }, teardown: function () {
            if (!e[f] && this[k]) {
                return false
            }
            var l = $(this);
            a = a.not(l);
            l.removeData(d);
            if (!a.length) {
                clearTimeout(i);
            }
        }, add: function (l) {
            if (!e[f] && this[k]) {
                return false
            }
            var n;

            function m(s, o, p) {
                var q = $(this), r = $.data(this, d);
                r.w = o !== c ? o : q.width();
                r.h = p !== c ? p : q.height();
                n.apply(this, arguments)
            }

            if ($.isFunction(l)) {
                n = l;
                return m
            } else {
                n = l.handler;
                l.handler = m
            }
        }
    };
    function g() {
        i = h[k](function () {
            a.each(function () {
                var n = $(this), m = n.width(), l = n.height(), o = $.data(this, d);
                if (m !== o.w || l !== o.h) {
                    n.trigger(j, [o.w = m, o.h = l])
                }
            });
            g()
        }, e[b])
    }
})(jQuery, this);
// =====================resize plugin end===============
(function ($) {
    var $navBar = $('nav.navbar'),
        $body = $('body'),
        $menu = $('#menu');

    function addPaddingTop(el, val) {
        el.css('padding-top', val);
    }

    function removePaddingTop(el) {
        el.css('padding-top', 'inherit');
    }

    function getHeight(el) {
        return el.outerHeight();
    }

    function init() {
        var isFixedNav = $navBar.hasClass('navbar-fixed-top');
        var bodyPadTop = isFixedNav ? $navBar.outerHeight(true) : 0;
        $body.css('padding-top', bodyPadTop);
        if ($body.hasClass('menu-affix')) {
            $menu
                .css({
                    height: function () {
                        return $(window).height();
                    },
                    top: bodyPadTop - 1,
                    bottom: 0
                });
        }
    }

    Admire.navBar = function () {
        var resizeTimer;
        init();
        $(window).resize(function () {
            clearTimeout(resizeTimer);
            resizeTimer = setTimeout(init(), 250);
        });
    };
    return Admire;
})(jQuery);
(function ($, Admire) {
    var $body = $('body'),
        $leftToggle = $('.toggle-left'),
        $rightToggle = $('.toggle-right');
    var leftopened = 0;

    /*右侧menu
        var demo = $("<div />").css({
            position: "fixed",
            top: "200px",
            right: "-1px",
            transition: 'all 0.3s ease-in-out',
            background: "#00cc99",
            "border-radius": "5px 0px 0px 5px",
            padding: "5px",
            "font-size": "16px",
            cursor: "pointer",
            color: "#ddd"
        }).html(" <i class='fa fa-fw fa-cog skin-icon'></i>").addClass("no-print");
        $body.append(demo);
        $(".no-print").on("mouseenter mouseleave", function(){
            $(".skin-icon").toggleClass("fa-spin");
            return false;
    });*/

    Admire.admireAnimatePanel = function () {
        if ($('#left').length) {
            $leftToggle.on(Admire.buttonPressedEvent, function (e) {
                // $(".toggle-left").on('click', function(e) {
                if ($(window).width() < 768) {
                    $body.toggleClass('sidebar-left-opened');
                    // $body.toggleClass('sidebar-left-hidden');
                    // $body.removeClass("sidebar-right-opened");
                } else {
                    $body.toggleClass("sidebar-left-hidden");
                    $body.removeClass("sidebar-right-opened");
                }
                menu_default();
            });
        } else {
            $leftToggle.addClass('hidden');
        }
       /* demo.on('click', function (e) {
            $body.toggleClass("sidebar-right-opened");
        });*/
    };
    return Admire;
})(jQuery, Admire || {});
$(document).ready(function () {
    $(window).on("load",function () {
        $('.preloader img').fadeOut();
        $('.preloader').fadeOut(1000);
    });

    $('[data-toggle="tooltip"]').tooltip();
    $('#menu').metisMenu();
    Admire.navBar();
    Admire.admireAnimatePanel();
    function _fix() {
        //Get window height and the wrapper height
     /*   var height = $(window).height() - $("#top").height();
        var wrapper = $(".wrapper");
        wrapper.css("min-height", height + "px");
        var content = wrapper.height();
        //If the wrapper height is greater than the window
        if (content > height) {
            //then set sidebar height to the wrapper
            $("html, body").css("min-height", content + 0 + "px");
            $("#left").css("min-height", content + 2 + "px");
        }
        else {
            //Otherwise, set the sidebar to the height of the window
            $("html, body").css("min-height", height + 0 + "px");
            $("#left").css("min-height", height + 2 + "px");
        }*/
    }

    function fix_sidebar() {
        if (!$("body").hasClass("fixed")) {
            return;
        }
        if ($(window).width() > 767) {
            $('.left_content').jScrollPane({
                autoReinitialise: true,
                autoReinitialiseDelay: 100
            });
        }
        else {
            $('.left_content').jScrollPane({
                autoReinitialise: true,
                autoReinitialiseDelay: 100
            });
        }
    }

    //Fire upon load admire
    setTimeout(_fix, 100);
    //Fix the fixed layout sidebar scroll bug
    fix_sidebar();
    //Fire when wrapper is resized
    $(".wrapper").on("resize",function () {
        _fix();
        fix_sidebar();
    });

    $('#messages,#notifications').css("height",220);
    $('#messages,#notifications').jScrollPane({
        autoReinitialise: true,
        autoReinitialiseDelay: 100
    });

    $("#request_btn, #notifications_section, #messages_section").on("click", function () {
        var animationEnd = 'webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend';
        $('#request_list, #notifications_dropdown, #messages_dropdown').addClass('animated fadeIn').one(animationEnd, function () {
            $("#request_list, #notifications_dropdown, #messages_dropdown").removeClass('animated fadeIn');
        });
    });

    $("#menu>.dropdown_menu").hover(function () {
        var sideoffset = $("#menu").offset();
        var submenuoffset = $(this).children("ul").offset();
        if (sideoffset.top + $("#menu").height() < submenuoffset.top + $(this).children("ul").height()) {
            $(this).children("ul").addClass("sidebarbottom");
        }
    });

//    ============================fading effect=======

//    ==========================Different cards=====================
//        Card close
    $('.card-header .fa-close').on('click', function () {
        $(this).closest('.card').parent().hide('slow');
    });
//        Card toggle
    $(".card-header .fa-chevron-up").on("click",function () {
        $(this).closest('.card').find('.card-block').slideToggle();
        $(this).toggleClass("fa-chevron-up").toggleClass("fa-chevron-down");
    });

//        Card edit
    (function($){
        $.fn.setCursorToTextEnd = function() {
            var $initialVal = this.val();
            this.val($initialVal);
        };
    })(jQuery);
    $(".card-header .fa-pencil").on('click',function(e){
        var edit=$(this).closest('.card').find('.card-header .card-title').text();
        var editable = $(this).closest('.card').find('.card-header');
        var editBox = "<div class='card_editbox'><input type='text' class='form-control text_for_save' maxlength='20' value='" + edit + "'></div>";
        if(!$(this).hasClass("fa-check")){
            editable.after(editBox);
            $(this).closest('.card').find("input").focus().setCursorToTextEnd();
        }else{
            $(this).closest(".card").find(".card_editbox").remove();
        }
        $(this).toggleClass('fa-check').toggleClass('fa-pencil');
    });
    $(".card").on("input",".text_for_save",function(){
        $(this).closest('.card').find('.card-header .card-title').text($(this).val());
    });

//        Card colors
    $(".card-header .fa-tint").on('click',function () {
        var colorpick=$(this).closest('.card').find('.card-header');
        var headerColor='<div class="header_colors">' +
            '<div class="inline_table"><div class="bg-primary" data-color="bg-primary"></div></div>' +
            '<div class="inline_table"><div class="bg-success" data-color="bg-success"></div></div>' +
            '<div class="inline_table"><div class="bg-warning" data-color="bg-warning"></div></div>' +
            '<div class="inline_table"><div class="bg-danger" data-color="bg-danger"></div></div>' +
            '<div class="inline_table"><div class="bg-info" data-color="bg-info"></div></div>' +
            '<div class="inline_table"><div class="bg-mint" data-color="bg-mint"></div></div>' +
            '<div class="inline_table"><div class="bg-white" data-color="bg-white"></div></div></div>'
        if($(this).hasClass("fa-tint")){
            colorpick.after(headerColor);
        }else{
            $(this).closest(".card").find('.header_colors').hide('slow');
        }
        $(".header_colors").each(function () {
            $(this).find('.inline_table div').on('click',function () {
                $(this).closest('.card').find('.card-header').removeClass().addClass("card-header "+$(this).attr("data-color"));
            });
        });
        $(this).toggleClass("fa-tint").toggleClass("fa-file-image-o");
    });

//        Full screen
    $(".card-header .fa-arrows-alt").on('click',function () {
        $(this).closest('.card').toggleClass('fullscreen');
    });

    //        Card Refreshing
    $(".card_refresh").on("click",function(){
        var card = $(this).parents(".card");
        card_refresh(card);
        setTimeout(function(){
            card_refresh(card);
        },2000);
    });

    function card_refresh(card){
        if(!card.hasClass("card-refreshing")){
            card.append('<div class="card_refresh_section"><img src="img/loader.gif"/></div>');
            card.find(".card_refresh_section").width(card.width()).height(card.height());
            card.addClass("card-refreshing");

        }else{
            card.find(".card_refresh_section").remove();
            card.removeClass("card-refreshing");
        }
    }
    // =============================== Right side bar =======================

    function scroll_fixtop() {
        var rightHeightTop=$(window).height() - top.height();
        $(".request_scrollable").css("height", rightHeightTop);
    }
    function scroll_fixtop2() {
        var rightHeightTop2=$(window).height() ;
        $(".request_scrollable").css("height", rightHeightTop2);

    }

    function fixed_menu_scroll(){
        if($("body").hasClass("fixedNav_position")){
            var leftHeight=$(window).height()-$("#top").height();
            $('.left_scrolled').css("height",leftHeight);
            $('.left_scrolled').jScrollPane({
                autoReinitialise: true,
                autoReinitialiseDelay: 100
            });
        }else{
            var leftHeight=$(window).height();
            $('.left_scrolled').css("height",leftHeight);
            $('.left_scrolled').jScrollPane({
                autoReinitialise: true,
                autoReinitialiseDelay: 100
            });
            var content_height=$("#content").height();
            var window_height=$(window).height();
            if(window_height>content_height){
                var leftHeight=$(window).height()-$("#top").height();
                $('.left_scrolled').css("height",leftHeight);
                $('.left_scrolled').jScrollPane({
                    autoReinitialise: true,
                    autoReinitialiseDelay: 100
                });
            }
        }

    }
    function fixed_menu_scroll2() {

        var element = $('.menu_scroll').jScrollPane();
        var api = element.data('jsp');
        api.destroy();
        $(".menu_scroll").removeAttr("style");

        if(left_height_unfixed > $("#content").height())
        {
            $("#left").css("min-height", left_height_unfixed);

        }
    }
    var top = $("#top");
    var left = $("#left");
    var body = $("body");
    var input=$("input");
    var fixedNav=$('#setting_fixed_nav').find(input);
    var fixedMenu=$('#setting_fixed_menunav').find(input);
    var breadcrumb=$('#setting_breadcrumb').find(input);
    fixedNav.lc_switch();
    fixedMenu.lc_switch();
    breadcrumb.lc_switch();
    function top_resize() {
        var topHeight=top.height();
        $("#request_list").css("padding-top", topHeight);
    }
    top_resize();
    $("#top").on("resize",function () {
        top_resize();
    });
    function right_fix(){
        var rightHeight=$(window).height();
        $(".request_scrollable").css("height", rightHeight)
    }
    function scroll_fix() {
        var rightHeight=$(window).height() - top.height()-30;
        $('.request_scrollable').jScrollPane({
            autoReinitialise: true,
            autoReinitialiseDelay: 100
        });
    }
    right_fix();
    scroll_fix();
    $(window).on("resize",function () {
        right_fix();
        scroll_fix();
    });
    $("#request_btn").on("click", function () {
        body.toggleClass("right_menu_section");
    });
    if($(window).width()>767) {
        breadcrumb.on('lcs-statuschange', function () {
            $(".head").toggleClass("breadcrumb_hide");
            if($("#setting_fixed_menunav .lcs_switch").hasClass("lcs_off")){
                $(".menu_scroll").removeClass("left_scrolled");
            }
        });
        fixedNav.on('lcs-statuschange', function () {
            $("#top").toggleClass("fixed");
            $(".wrapper").toggleClass("fixedNav_top");
            body.toggleClass("fixedNav_position");
            if($("#top").hasClass("fixed")){
                $(".menu_scroll").removeClass("left_scrolled");
                scroll_fixtop();
                $(window).on("resize",function () {
                    scroll_fixtop();
                });
            }
            else{
                scroll_fixtop2();
                $(window).on("resize",function () {
                    scroll_fixtop2();
                });
            }
        });
        var left_height_unfixed = $("#left").height();
        fixedMenu.on('lcs-statuschange', function () {
            $("#left").toggleClass("fixed");
            body.toggleClass("fixedMenu_left");
            $("#left.fixed").find(".menu_scroll").addClass("left_scrolled");
            if (body.hasClass("fixedMenu_left")) {
                fixed_menu_scroll();
                $(window).on("resize",function() {
                    fixed_menu_scroll();
                });
                fixedNav.on('lcs-statuschange', function () {
                    if($("body").hasClass("fixedNav_position")){
                        var leftHeight11=$(window).height()-$("#top").height();
                        $('.menu_scroll').css("height",leftHeight11);
                    }else{
                        var leftHeight11=$(window).height();
                        $('.menu_scroll').css("height",leftHeight11);
                    }
                });
            }
            else {
                fixedNav.on('lcs-statuschange', function () {
                    // $('.menu_scroll').css("height", "");
                    $('.menu_scroll').removeAttr('style');
                });
                fixed_menu_scroll2();
                $(window).on("resize",function() {
                    fixed_menu_scroll2();
                });
            }
        });
    }

    $(window).on("scroll", function () {
        var window_height= $(window).height();
        $("#content").css("min-height", window_height);
        if($("#top").hasClass("fixed")){
            scroll_fixtop()
        }else{
            request_scrollable_default();
        }
        if ($(this).scrollTop() > 50) {
            $('#request_list,.fixedMenu_left #left').addClass('rightsidebar-without-nav');
        } else {
            $('#request_list,.fixedMenu_left #left').removeClass('rightsidebar-without-nav');
        }

        if ($(this).scrollTop() > 50 && $(this).scrollTop() < 100) {
            $('#request_list,.fixedMenu_left #left').addClass('rightsidebar-without-nav-small');
        } else {
            $('#request_list,.fixedMenu_left #left').removeClass('rightsidebar-without-nav-small');
        }

    });
    // fixed header
    var top = $("#top");
    function request_scrollable_default(){
        var rightHeightTop2=$(window).height();
        $(".request_scrollable").css("height", rightHeightTop2);
    }
    function scroll_fixtop() {
        var rightHeightTop=$(window).height() - top.height();
        $(".request_scrollable").css("height", rightHeightTop)
    }
    scroll_fixtop();
    $(window).on("resize",function () {
        scroll_fixtop();
        request_scrollable_default();
    });
    // Fixed menu
    function fixed_menu_scroll() {
        if($("body").hasClass("fixedNav_position")){
            var leftHeight=$(window).height()-$("#top").height();
            $('.left_scrolled').css("height",leftHeight);
            $('.left_scrolled').jScrollPane({
                autoReinitialise: true,
                autoReinitialiseDelay: 100
            });
        }else{
            var leftHeight=$(window).height();
            $('.left_scrolled').css("height",leftHeight);
            $('.left_scrolled').jScrollPane({
                autoReinitialise: true,
                autoReinitialiseDelay: 100
            });
        }
    }
    fixed_menu_scroll();
    $(window).on("resize", function () {
        fixed_menu_scroll();
    });

    if($("body").hasClass("fixedMenu_left")) {
        $('#setting_fixed_nav').find('input').on('lcs-statuschange', function () {
            if ($("body").hasClass("fixedNav_position")) {
                if ($("#top").hasClass("fixed")) {
                    var leftHeight_fixednav = $(window).height() - $("#top").height();
                    $('.menu_scroll').css("height", leftHeight_fixednav);
                    $('.menu_scroll').css("min-height", leftHeight_fixednav);
                }
            }else{
                var leftHeight_withoutfixednav = $(window).height();
                $('.menu_scroll').css("height", leftHeight_withoutfixednav);
            }
        });

    }
});