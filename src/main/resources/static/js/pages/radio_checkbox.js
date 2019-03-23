'use strict';
$(document).ready(function(){
    // Bootstrap switch
    $.each($('.make-switch-radio'), function () {
        $(this).bootstrapSwitch({
            onText: $(this).data('onText'),
            offText: $(this).data('offText'),
            onColor: $(this).data('onColor'),
            offColor: $(this).data('offColor'),
            size: $(this).data('size'),
            labelText: $(this).data('labelText')
        });
    });

    // Switchery
    new Switchery(document.querySelector('.sm_toggle'), { size: 'small', color: '#4fb7fe', jackColor: '#fff' });
    new Switchery(document.querySelector('.sm_toggle_checked'), { size: 'small', color: '#EF6F6C', jackColor: '#fff' });
    new Switchery(document.querySelector('.sm_disable'), { size: 'small', disabled: true });

    new Switchery(document.querySelector('.sm_disable_checked'), { size: 'small', disabled: true, color:'#00cc99',  jackColor: '#fff' });

    new Switchery(document.querySelector('.md_toggle'), { color: '#00cc99', secondaryColor: '#ff9933',jackColor: '#fff' });
    new Switchery(document.querySelector('.md_toggle_checked'), { color: '#4fb7fe', jackColor: '#fff' });
    new Switchery(document.querySelector('.md_disable'), { disabled: true });
    new Switchery(document.querySelector('.md_disable_checked'), { color: '#347dff', jackColor: '#fff', disabled: true });

    new Switchery(document.querySelector('.md_colored'),{ color: '#0fb0c0', secondaryColor: '#ff9933', jackColor: '#fff', jackSecondaryColor: '#00cc99' });

});