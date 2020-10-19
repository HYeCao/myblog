$(document).ready(function () {
    console.log("加载成功")
    //填充浏览统计数据
//    $.ajax({
//               url: "/admin/sys/view",
//               type: "GET",
//               dataType: "json",
//               success: function (json) {
//                   console.log("返回成功")
//                   $('#count-visits').append(json.length)
//
//                   $.each(json, function (i, item) {
//                       $('#tbody-visits').append(
//                           '<tr><td>' + item.id +
//                           '</td><td>' + item.topic +
//                           '</td><td>' + item.views + '</td></tr>');
//                   });
//                   $('#dataTables-visits').dataTable();
//               }
//           });
//
    $.ajax({
        url: "/admin/sys/view",
        type: "GET",
        dataType: "json",
        success: function (json) {
            console.log("返回成功")
            $('#count-views').append(json.length)

            $.each(json, function (i, item) {
                $('#tbody-views').append(
                    '<tr><td>' + item.id +
                    '</td><td>' + item.ip +
                    '</td><td>' + item.createBy + '</td></tr>');
            });
            $('#dataTables-views').dataTable();
        }
    });
    // 填充日志统计数据
    $.ajax({
        url: "/admin/sys/log",
        type: "GET",
        dataType: "json",
        success: function (json) {
            console.log(json);
            $('#count-logs').append(json.length)
            $.each(json, function (i, item) {
                $('#tbody-logs').append(
                    '<tr><td>' + item.id +
                    '</td><td>' + item.ip +
                    '</td><td>' + item.createBy +
                    '</td><td>' + item.remark +
                    '</td><td>' + item.operateUrl +
                    '</td><td>' + item.operateBy + '</td></tr>');
            });
            $('#dataTables-logs').dataTable();
        }
    });

    // 填充评论统计数据
    $.ajax({
        url: "/api/comment/list",
        type: "GET",
        dataType: "json",
        success: function (json) {
            $('#count-comments').append(json.length)
            $.each(json, function (i, item) {
                $('#tbody-comments').append(
                    '<tr><td>' + item.id +
                    '</td><td>' + item.userName +
                    '</td><td>' + item.comment +
                    '</td><td>' + item.blog_ID +
                    '</td><td><button class="btn btn-danger deleteBtn" onclick="deleteComment(\'' + item.id + '\')"><i class="fa fa-trash-o"></i>删除</button></td></tr>');

            });
            $('#dataTables-comments').dataTable();
        }
    });

});

// 删除评论
function deleteComment(id) {
    $('#confirmBtn').attr("commentId", id);
    $('#myModal').modal();
};

// 确认删除留言点击事件
$('#confirmBtn').click(function () {
    var id = $(this).attr("commentId");
    $.ajax({
        type: "DELETE",
        url: "/admin/comment/" + id,
        success: function () {
            // 刷新页面
            location.reload();
        }
    });
});