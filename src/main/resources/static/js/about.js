window.onload = function () {
    // 获取留言信息
    $.ajax({
        url: "http://10.2.3.235:80/api/comment/list",
        type: "GET",
        dataType: "json",
        success: function (json) {
            $.each(json, function (i, item) {
                $('#commentList').append(
                    '<div class="comment">' +
                    '<label class="commentName">' + item.name + '</label> <label class="commentTime">' + item.createBy + '</label><br />' +
                    '<lable class="commentContent">' + item.content + '</lable>' +
                    '</div></div>'
                );
            });
        }
    })
};

// 增加留言
$('#addComment').click(function () {
    var blog_ID = 0;
    var userName = $('#commentName').val();
    var email = $('#commentEmail').val();
    var comment = $('#commentContent').val();

    // 判断是否为空
    if ("" == userName || "" == comment) {
        $('#modal').modal();
        return;
    }

    // 不为空才能增加
    var comment = {
        userName: userName,
        email: email,
        comment: comment,
        blog_ID: blog_ID
    }
    // 提交AJAX请求
    $.ajax({
        url: "/api/comment/article",
        type: "POST",
        dataType: "json",
        contentType: "application/json;charset=utf-8",
        data: JSON.stringify(comment),
        success: function () {
            // 显示成功提示信息
            $('#addModal').modal();
        },
        error: function () {
            $('#addModal').modal();
        }
    })
});

// 模态框确认按钮点击事件
$('#addConfirmBtn').click(function () {
    // 刷新页面
    location.reload();
});