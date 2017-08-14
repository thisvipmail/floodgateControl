/**
 * Created by Administrator on 2017/7/21.
 */

const util = (function () {
    return {
        /**
         * 时间格式化
         * @param time 时间参数
         * @param fmt 格式化类型
         * @returns {*}
         */
        timeFormat: function (time,fmt) {
            time = time || new Date();
            if (typeof  time === "string") {
                time = Date.parse(time);
                if (isNaN(time)) {
                    throw new Error("时间字符串格式不正确！");
                }
            }
            if (typeof time === "number") {
                time = new Date(time)
            }

            var o = {
                "M+": time.getMonth() + 1,                 //月份
                "d+": time.getDate(),                    //日
                "h+": time.getHours(),                   //小时
                "m+": time.getMinutes(),                 //分
                "s+": time.getSeconds(),                 //秒
                "q+": Math.floor((time.getMonth() + 3) / 3), //季度
                "S": time.getMilliseconds()             //毫秒
            };
            if (/(y+)/.test(fmt)) {
                fmt = fmt.replace(RegExp.$1, (time.getFullYear() + "").substr(4 - RegExp.$1.length));
            }
            for (var k in o) {
                if (new RegExp("(" + k + ")").test(fmt)) {
                    fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
                }
            }
            return fmt;
        },
        /**
         * 获取年
         * @param time
         */
        getYear: function (time) {
            time = time || new Date();
            if (typeof  time === "string") {
                time = Date.parse(time);
                if (isNaN(time)) {
                    throw new Error("时间字符串格式不正确！");
                }
            }
            if (typeof time === "number") {
                time = new Date(time)
            }
            return time.getFullYear();
        },
        /**
         * 获取月
         * @param time
         */
        getMonth: function (time) {
            time = time || new Date();
            if (typeof  time === "string") {
                time = Date.parse(time);
                if (isNaN(time)) {
                    throw new Error("时间字符串格式不正确！");
                }
            }
            if (typeof time === "number") {
                time = new Date(time)
            }
            return time.getMonth() + 1;
        },
        /**
         * 获取旬
         * @param time
         */
        getTen: function (time) {
            time = time || new Date();
            if (typeof  time === "string") {
                time = Date.parse(time);
                if (isNaN(time)) {
                    throw new Error("时间字符串格式不正确！");
                }
            }
            if (typeof time === "number") {
                time = new Date(time)
            }
            let date = time.getDate();
            return date < 11 ? "01" : date < 21 ? '02' : '03';
        },
        /**
         * 显示等待
         */
        showWaiting: function () {
            waitModal.modal({backdrop: 'static', keyboard: false});
        },
        /**
         * 隐藏等待
         */
        hideWaiting: function () {
            waitModal.modal('hide');
        }
    }
})()


