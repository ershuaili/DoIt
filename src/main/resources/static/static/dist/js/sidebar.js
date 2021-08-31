$(function () {
    // 侧边栏弹出
    $('button').click(function () {
        var left = $('#wrapper')[0].offsetLeft;
        if (left == 0) {
            $('#wrapper').offset({
                'left': 220
            });
            $(this).css('transform', 'rotate(450deg)');
            $('.headSculpture img').addClass('img');
            $('.headSculpture p').addClass('opacity');
            setTimeout(function () {
                $('.option ul>li').addClass('li');
            }, 500)
        } else {
            $('#wrapper').offset({
                'left': 0
            });
            $(this).css('transform', 'rotate(0deg)');
            setTimeout(function () {
                $('.headSculpture img').removeClass('img');
                $('.headSculpture p').removeClass('opacity');
                $('.option ul>li').removeClass('li');
            }, 300)
        }
    })

    $('.option ul>li').click(function () {
        let infor = $(this).children().next().text();
        switch (infor) {
            case "今天":
                window.location.href = "index.html";
                break;
            case "明天":
                window.location.href = "tomorrow.html";
                break;
            case "这周":
                window.location.href = "week.html";
                break;
            case "日历":
                window.location.href = "calendar.html";
                break;
            case "任务":
                window.location.href = "task.html";
                break;
            case "清单":
                window.location.href = "checklist.html";
                break;
        }
    })
})
