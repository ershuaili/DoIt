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

// 输入提示按钮
$(function () {
    // 获得焦点
    $(taskInput).focus(function () {
        $(inputIcon).attr("class", "layui-icon  layui-icon-edit");
    });
    // 失去焦点
    $(taskInput).blur(function () {
        $(inputIcon).attr("class", "layui-icon layui-icon-add-1");
    });
});

//获取任务列表
$(function () {
    $.ajax({
        // 请求路径
        url: "/tasks",
        type: 'get',
        success: function (data) {
            // 拿到数据后执行的方法
            for (let i = 0; i < data.length; i++) {
                if (data[i].isFinish === false) {
                    let str = "";
                    str += '<div class="task">' +
                        '<i class="layui-icon layui-icon-circle"></i>' +
                        '<div class="taskMain">' +
                        '<input type="hidden" value=' + data[i].id + '>' +
                        '<p class="taskText">' + data[i].taskName + '</p>' +
                        '<p class="taskTime">' + (data[i].endTime == null ? "" : data[i].endTime) + '</p>' +
                        '</div>' +
                        '</div>';
                    $("#tasks").prepend(str);
                } else {
                    let str = "";
                    str += '<div class="task">' +
                        '<i class="layui-icon layui-icon-ok-circle"></i>' +
                        '<div class="taskMain">' +
                        '<input type="hidden" value=' + data[i].id + '>' +
                        '<p class="taskText"><del>' + data[i].taskName + '</del></p>' +
                        '<p class="taskTime">' + (data[i].endTime == null ? "" : data[i].endTime) + '</p>' +
                        '</div>' +
                        '</div>';
                    $("#finishTasks").prepend(str);
                }
            }
        }
    });
});

// 添加任务
$(function () {
    $("#inputBtn").click(function () {
        // 表单验证
        let txtVal = $("#taskInput").val();
        if (txtVal === '') {
            layer.msg('不能添加空内容', {time: 1000});
        } else {
            // 提交任务
            $.ajax({
                url: '/taskInput',
                type: 'post',
                async: false,
                // 获取数据发送给后端
                data: $('#addTask').serialize(),
                success: function (data) {
                    if (data === null) {
                        alert("添加失败");
                    } else {
                        // 更新页面
                        let str = '';
                        str += '<div class="task">' +
                            '<i class="layui-icon layui-icon-circle"></i>' +
                            '<div class="taskMain">' +
                            '<input type="hidden" value=' + data.id + '>' +
                            '<p class="taskText">' + data.taskName + '</p>' +
                            '<p class="taskTime">' + (data.endTime == null ? "" : $(endTime).val()) + '</p>' +
                            '</div>' +
                            '</div>';
                        $("#tasks").prepend(str);
                        // 清空输入框内容
                        $(taskInput).val("");
                        $(endTime).val("");
                    }
                }
            });
        }
    });
});

// 完成任务
$(function () {
    $("#tasks").on("click", ".layui-icon-circle", function () {
        let taskUpdate = {id: $(this).next().children().val(), isFinish: true};
        $.ajax({
            url: '/taskUpdate',
            type: 'post',
            data: taskUpdate,
            success: function (data) {
                // 为完成的任务列表添加任务
                let str = '';
                str += '<div class="task">' +
                    '<i class="layui-icon layui-icon-ok-circle"></i>' +
                    '<div class="taskMain">' +
                    '<input type="hidden" value=' + data.id + '>' +
                    '<p class="taskText"><del>' + data.taskName + '</del></p>' +
                    '<p class="taskTime">' + data.endTime + '</p>' +
                    '</div>'
                $("#finishTasks").prepend(str);
            }
        })
        // 移除当前任务列表
        $(this).parent().remove();
    });
});

// 取消完成任务
$(function () {
    $("#finishTasks").on("click", ".layui-icon-ok-circle", function () {
        let taskUpdate = {id: $(this).next().children().val(), isFinish: false};
        console.log(taskUpdate);
        $.ajax({
            url: '/taskUpdate',
            type: 'post',
            data: taskUpdate,
            success: function (data) {
                // 为完成的任务列表添加任务
                let str = '';
                str += '<div class="task">' +
                    '<i class="layui-icon layui-icon-circle"></i>' +
                    '<div class="taskMain">' +
                    '<input type="hidden" value=' + data.id + '>' +
                    '<p class="taskText">' + data.taskName + '</p>' +
                    '<p class="taskTime">' + data.endTime + '</p>' +
                    '</div>'
                $("#tasks").prepend(str);
            }
        })
        // 移除当前任务列表
        $(this).parent().remove();
    });
});

// 步骤列表
$(".tasks").on("click", ".taskMain", function () {
    const typeIcon = $(this).prev().attr('class');
    const taskText = $(this).children().first().next().text();
    let title =
        '<i class ="' + typeIcon + '"></i>' +
        '<i>' + taskText + '</i>';
    let content =
        '<div class="popup">' +
        '<div class="myDay"><i class="layui-icon layui-icon-light"></i>我的一天</div>' +
        '<div class="recur"><i class="layui-icon layui-icon-refresh"></i>任务重复</div>' +
        '<div class="addStep"><i class="layui-icon layui-icon-add-1"></i>添加步骤</div>' +
        '<div class="steps"><i class="layui-icon layui-icon-circle"></i>步骤列表</div>' +
        '<div class="delete"><i class="layui-icon layui-icon-delete"></i>删除</div>' +
        '</div>';
    layer.open({
        type: 1,
        title: title,                 // 头部内容
        content: content,             // 这里content是一个普通的String
        area: ['500px', '100%'],      // 窗口大小
        offset: 'rt',                 // 窗口位置
        anim: 5,                      // 窗口动画
        shadeClose: true,             // 阴影 关闭
        moveOut: true,                // 是否允许拖动到窗口外
    });
});
