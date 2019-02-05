var padDate=function(va){
    va=va<10?'0'+va:va;
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