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

// 左侧导航选中
$(function () {
    switch ($("title").text()) {
        case "DoIt-Day":
            $("#DoIt-Day").attr("class", "layui-nav-item layui-this")
            break;
        case "DoIt-Tom":
            $("#DoIt-Tom").attr("class", "layui-nav-item layui-this")
            break;
        case "DoIt-Wee":
            $("#DoIt-Wee").attr("class", "layui-nav-item layui-this")
            break;
        case "DoIt-Cal":
            $("#DoIt-Cal").attr("class", "layui-nav-item layui-this")
            break;
        case "DoIt-Tas":
            $("#DoIt-Tas").attr("class", "layui-nav-item layui-this")
            break;
        case "DoIt-Che":
            $("#DoIt-Che").attr("class", "layui-nav-item layui-this")
            break;
    }
});