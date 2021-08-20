// 主体框架js
// 加载模块
layui.use(['data'], function () {
    var laydate = layui.laydate //日期

    // 时间控件 执行一个laydate实例 
    laydate.render({
        elem: "#test10" //指定元素
    });
});
