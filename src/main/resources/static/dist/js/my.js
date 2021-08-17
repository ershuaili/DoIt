$(document).ready(function () {
    'use strict'
    // 获取任务列表
    $(function () {
        $.ajax({
            // 请求路径
            url: "/tasks",
            type: 'get',
            success: function (data) {
                // 拿到数据后执行的方法
                // console.log(data);
                let html = "";
                for (let i = 0; i < data.length; i++) {
                    html += "<li id=task value=" + data[i].id + ">" + data[i].taskName + "</li>" + "<br>"
                }
                $("#tasks").append(html);
            }
        })
    });

    // 添加任务
    $("#taskInput").submit(function () {
        $.ajax({
            url: '/taskInput',
            type: 'post',
            data: $('#taskInput').serialize(),
            success: function (data) {
                console.log(data);
                // if (data===true){
                //     alert("添加成功")
                // }else {
                //     alert("添加失败")
                // }
            }
        });
        return false;
    });

    // 获取步骤列表
    // on可以动态创建元素绑定事件
    $("#tasks").on("click", "li", function () {
        $.ajax({
            // 请求路径
            url: "/steps",
            type: 'get',
            // 方法回调将#name的值赋值给id
            // 取到当前的元素的value
            data: {id: $(this).val()},
            success: function (data) {
                // 拿到数据后执行的方法
                let html = "";
                for (let i = 0; i < data.length; i++) {
                    html += data[i].content + "<a href='javascript:;'> 删除</a>" + "<br>"
                    // 设置步骤的父级任务id
                    document.getElementById('taskId').value = data[i].taskId
                }
                $("#steps").html(html);
            }
        });
    });

    // 添加步骤
    $("#stepInput").submit(function () {
        $.ajax({
            url: '/stepInput',
            type: 'post',
            data: $('#stepInput').serialize(),
            success: function (data) {
                console.log(data);
                if (data === false) {
                    alert("添加成功")
                } else {
                    alert("添加失败")
                }
            }
        });
    });
});