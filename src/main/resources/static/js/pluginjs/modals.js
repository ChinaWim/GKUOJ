//modals page
'use strict';
$(document).ready(function(){
    $(".rotatein").on("click", function() {
        var animationEnd = 'webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend';
        $('#modal-rotatein').addClass('animated rotateIn').one(animationEnd, function() {
            $(this).removeClass('animated rotateIn');
        });
    });
    $(".rotatedownright").on("click", function() {
        var animationEnd = 'webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend';
        $('#modal-rotatedownright').addClass('animated rotateInDownRight').one(animationEnd, function() {
            $(this).removeClass('animated rotateInDownRight');
        });
    });
    $(".flipiny").on("click", function() {
        var animationEnd = 'webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend';
        $('#modal-flipiny').addClass('animated flipInY').one(animationEnd, function() {
            $(this).removeClass('animated flipInY');
        });
    });
    $(".zoomin").on("click", function() {
        var animationEnd = 'webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend';
        $('#modal-zoomin').addClass('animated zoomIn').one(animationEnd, function() {
            $(this).removeClass('animated zoomIn');
        });
    });
    $(".swing").on("click", function() {
        var animationEnd = 'webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend';
        $('#modal-swing').addClass('animated swing').one(animationEnd, function() {
            $(this).removeClass('animated swing');
        });
    });
    $(".tada").on("click", function() {
        var animationEnd = 'webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend';
        $('#modal-tada').addClass('animated tada').one(animationEnd, function() {
            $(this).removeClass('animated tada');
        });
    });
    $(".shake").on("click", function() {
        var animationEnd = 'webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend';
        $('#modal-shake').addClass('animated shake').one(animationEnd, function() {
            $(this).removeClass('animated shake');
        });
    });
    $(".lightspeedin").on("click", function() {
        var animationEnd = 'webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend';
        $('#modal-lightspeedin').addClass('animated lightSpeedIn').one(animationEnd, function() {
            $(this).removeClass('animated lightSpeedIn');
        });
    });
    $(".slideinleft").on("click", function() {
        var animationEnd = 'webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend';
        $('#modal-slideinleft').addClass('animated fadeInLeft').one(animationEnd, function() {
            $(this).removeClass('animated fadeInLeft');
        });
    });
    $(".slideinright").on("click", function() {
        var animationEnd = 'webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend';
        $('#modal-slideinright').addClass('animated slideInRight').one(animationEnd, function() {
            $(this).removeClass('animated slideInRight');
        });
    });
    $(".fadein").on("click", function() {
        var animationEnd = 'webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend';
        $('#modal-1').addClass('animated fadeIn').one(animationEnd, function() {
            $(this).removeClass('animated fadeIn');
        });
    });
    $(".fadeindown").on("click", function() {
        var animationEnd = 'webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend';
        $('#modal-fadeindown').addClass('animated fadeInDown').one(animationEnd, function() {
            $(this).removeClass('animated fadeInDown');
        });
    });
    $(".bounceinright").on("click", function() {
        var animationEnd = 'webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend';
        $('#modal-2').addClass('animated bounceInRight').one(animationEnd, function() {
            $(this).removeClass('animated bounceInRight');
        });
    });
    $(".bounceindown").on("click", function() {
        var animationEnd = 'webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend';
        $('#modal-3').addClass('animated bounceInDown').one(animationEnd, function() {
            $(this).removeClass('animated bounceInDown');
        });
    });
    $(".bounceinup").on("click", function() {
        var animationEnd = 'webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend';
        $('#modal-bounceinup').addClass('animated bounceInUp').one(animationEnd, function() {
            $(this).removeClass('animated bounceInUp');
        });
    });
});
