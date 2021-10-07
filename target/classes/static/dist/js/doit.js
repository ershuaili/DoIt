$(function () {
    // lay-ui 加载模块
    layui.use(['element', 'laydate', 'layer', 'util'], function () {
        const element = layui.element; //框架
        const laydate = layui.laydate; //日期
        const layer = layui.layer;     //弹出层

        //执行一个laydate实例
        laydate.render({
            //指定元素
            elem: "#endTime",
            format: "yyyy-MM-dd",//日期格式
            // 得到元素后执行的方法
            done: function (value) {
                $("#endTime").val(value);
            }
        });
    });

    // 日期格式化工具
    Date.prototype.format = function (fmt) {
        let o = {
            "M+": this.getMonth() + 1, //月份
            "d+": this.getDate(), //日
            "h+": this.getHours(), //小时
            "m+": this.getMinutes(), //分
            "s+": this.getSeconds(), //秒
            "q+": Math.floor((this.getMonth() + 3) / 3), //季度
            "S": this.getMilliseconds() //毫秒
        };
        if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
        for (let k in o)
            if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length === 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        return fmt;
    }
});
