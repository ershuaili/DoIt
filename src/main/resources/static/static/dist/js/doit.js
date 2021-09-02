const taskInput = $("#taskInput");
const inputIcon = $("#inputIcon");
const endTime = $("#endTime")

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