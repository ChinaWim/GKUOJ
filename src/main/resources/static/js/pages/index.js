"use strict";
$(function() {

    $('.runner').on('click', function(e) {
        var notes = [];
        notes['alert'] = 'Best check yo self, you\'re not looking too good.';
        notes['error'] = 'Change a few things up and try submitting again.';
        notes['success'] = '祝你好运';
        notes['information'] = 'This alert needs your attention, but it\'s not super important.';
        notes['warning'] = '<strong>Warning!</strong> <br /> Best check yo self, you\'re not looking too good.';
        notes['confirm'] = 'Do you want to continue?';
        e.preventDefault();
        var self = $(this);
        if (self.data('layout') == 'inline') {
            $(self.data('custom')).noty({
                text: notes[self.data('type')],
                type: self.data('type'),
                theme: 'relax',
                dismissQueue: true,
                animation: {
                    open: {
                        height: 'toggle'
                    },
                    close: {
                        height: 'toggle'
                    },
                    easing: 'swing',
                    speed: 500
                },
                buttons: (self.data('type') != 'confirm') ? false : [{
                    addClass: 'btn btn-primary',
                    text: 'Ok',
                    onClick: function($noty) {
                        $noty.close();
                        $(self.data('custom')).noty({
                            force: true,
                            text: 'You clicked "Ok" button',
                            type: 'success'
                        });
                    }
                }, {
                    addClass: 'btn btn-danger',
                    text: 'Cancel',
                    onClick: function($noty) {
                        $noty.close();
                        $(self.data('custom')).noty({
                            force: true,
                            text: 'You clicked "Cancel" button',
                            type: 'error'
                        });
                    }
                }]
            });
            return false;
        }
        noty({
            text: notes[self.data('type')],
            type: self.data('type'),
            theme: 'relax',
            dismissQueue: true,
            layout: self.data('layout'),
            animation: {
                open: {
                    height: 'toggle'
                },
                close: {
                    height: 'toggle'
                },
                easing: 'swing',
                speed: 500
            },
            buttons: (self.data('type') != 'confirm') ? false : [{
                addClass: 'btn btn-primary',
                text: 'Ok',
                onClick: function($noty) {
                    $noty.close();
                    noty({
                        force: true,
                        theme: 'relax',
                        animation: {

                            open: {
                                height: 'toggle'
                            },
                            close: {
                                height: 'toggle'
                            },
                            easing: 'swing',
                            speed: 500
                        },
                        text: 'You clicked "Ok" button',
                        type: 'success',
                        layout: self.data('layout')
                    });
                }
            }, {
                addClass: 'btn btn-danger',
                text: 'Cancel',
                onClick: function($noty) {
                    $noty.close();
                    noty({
                        force: true,
                        theme: 'relax',
                        animation: {

                            open: {
                                height: 'toggle'
                            },
                            close: {
                                height: 'toggle'
                            },
                            easing: 'swing',
                            speed: 500
                        },
                        text: 'You clicked "Cancel" button',
                        type: 'error',
                        layout: self.data('layout')
                    });
                }
            }]
        });
        return false;
    });


});