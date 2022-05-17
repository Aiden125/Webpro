// JavaScript source code(intervalDay.js)
Date.prototype.intervalDay = function (that) {
    if (this > that) {
        intervalMili = this.getTime() - that.getTime();
    } else {
        intervalMili = that.getTime() - this.getTime();
    }
    //이건 소수점으로 떨어질건데, 날짜로 깔끔하게 보기 위해소수점 버리기 90.34일 -> 90일
    var day = intervalMili / (1000 * 60 * 60 * 24);
    return Math.trunc(day);
};