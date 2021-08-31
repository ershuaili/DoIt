$(function () {
    // 侧边栏弹出
    $('button').click(function () {
        let wrapper = $('#wrapper')
        let left = $(wrapper)[0].offsetLeft;
        if (left === 0) {
            $(wrapper).offset({
                'left': 220
            });
            $(this).css('transform', 'rotate(450deg)');
            $('.headSculpture img').addClass('img');
            $('.headSculpture p').addClass('opacity');
            setTimeout(function () {
                $('.option ul>li').addClass('li');
            }, 300)
        } else {
            $(wrapper).offset({
                'left': 0
            });
            $(this).css('transform', 'rotate(0deg)');
            setTimeout(function () {
                $('.headSculpture img').removeClass('img');
                $('.headSculpture p').removeClass('opacity');
                $('.option ul>li').removeClass('li');
            }, 300)
        }
    });
    // 页面转跳
    $('.option ul>li').click(function () {
        let information = $(this).children().next().text();
        switch (information) {
            case "今天":
                window.location.href = "/";
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
    })
});
