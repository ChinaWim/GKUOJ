function timer(intDiff) {

    var timerInterval = window.setInterval(function () {

        var day = 0,

            hour = 0,

            minute = 0,

            second = 0;//时间默认值

        if (intDiff > 0) {

            day = Math.floor(intDiff / (60 * 60 * 24));

            hour = Math.floor(intDiff / (60 * 60)) - (day * 24);

            minute = Math.floor(intDiff / 60) - (day * 24 * 60) - (hour * 60);

            second = Math.floor(intDiff) - (day * 24 * 60 * 60) - (hour * 60 * 60) - (minute * 60);

        }

        if (minute <= 9) minute = '0' + minute;

        if (second <= 9) second = '0' + second;

        $('#day_show').html(day);

        $('#hour_show').html('<s id="h"></s>' + hour);

        $('#minute_show').html('<s></s>' + minute);

        $('#second_show').html('<s></s>' + second);
        if (intDiff === 0) {
            $(".time-item").html('<span class="item-closed">已经结束!</span>');
            window.clearInterval(timerInterval);
            return;
        }
        intDiff--;

    }, 1000);

}

