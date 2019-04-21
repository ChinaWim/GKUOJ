var padDate = function (va) {
    va = va < 10 ? '0' + va : va;
    return va
};

function differDate2HourMinute(date1, date2) {
    var result;
    var totalTime = Math.abs(new Date(date1).getTime() - new Date(date2).getTime());
    var minTime = (totalTime / 1000 / 60);
    if (minTime < 60) {
        result = minTime + " 分钟";
    } else {
        var hourNum = parseInt(minTime / 60);
        var minNum = minTime % 60;
        result = hourNum + " 小时 " + minNum + " 分钟";
    }
    return result;
}



/**
 *0 编译中　1 ac 2 ce 3 pe 4 re 5 tle 6 me 7 wa　8队列中 9判题中
 * 根据判题status返回对应的颜色
 * @param status
 */
function getColorByStatus(status){
    if(status == 1){
        return '#4BC0C0';
    }
    if(status == 2){
        return '#FFCD56';
    }
    if(status == 3){
        return  '#ed92ff';
    }
    if(status == 4){
        return  '#FF9F40';
    }

    if(status == 5){
        return  '#62b8ff';
    }
    if(status == 6){
        return'#6574ff';
    }
    if(status == 7){
        return  '#FF6384'
    }
    return '';
}

function getStrByStatus(status){
    if(status == 0){
        return '编译中';
    }
    if(status == 1){
        return 'Accepted';
    }
    if(status == 2){
        return 'CompileError';
    }
    if(status == 3){
        return  'PresentationError';
    }
    if(status == 4){
        return  'RuntimeError';
    }
    if(status == 5){
        return  'TimeLimitExceeded';
    }
    if(status == 6){
        return'MemoryLimitExceeded';
    }
    if(status == 7){
        return  'WrongAnswer'
    }
    if(status == 8){
        return  '队列中'
    }
    if(status == 9){
        return  '判题中'
    }
    return '';
}

/**
 * 数组去重
 * @returns {Array}
 */
