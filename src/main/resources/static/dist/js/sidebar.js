$(function () {
    // 侧边栏弹出
    $(document).mouseup(function (e) {
        let wrapper = $('#wrapper');
        let _con = $(".task,.taskInput,.layui-layer-shade,.layui-layer-page,.layui-layer-move");   // 设置目标区域
        if (!_con.is(e.target) && _con.has(e.target).length === 0) { // Mark 1
            let left = $(wrapper)[0].offsetLeft;
            if (left === 0) {
                $(wrapper).offset({
                    'left': 220
                });
                $('.headSculpture img').addClass('img');
                $('.headSculpture p').addClass('opacity');
                setTimeout(function () {
                    $('.option ul>li').addClass('li');
                }, 500)
            } else {
                $(wrapper).offset({
                    'left': 0
                });
                setTimeout(function () {
                    $('.headSculpture img').removeClass('img');
                    $('.headSculpture p').removeClass('opacity');
                    $('.option ul>li').removeClass('li');
                }, 300)
            }
        }
    })

// 页面转跳
    $('.option ul>li').click(function () {
        let information = $(this).children().next().text();
        switch (information) {
            case "今天":
                window.location.href = "../../../../..";
                break;
            case "明天":
                window.location.href = "tom";
                break;
            case "这周":
                window.location.href = "wee";
                break;
            case "日历":
                window.location.href = "cal";
                break;
            case "任务":
                window.location.href = "tas";
                break;
            case "清单":
                window.location.href = "che";
                break;
        }
    });
});