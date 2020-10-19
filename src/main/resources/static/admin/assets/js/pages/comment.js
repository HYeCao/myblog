$(document).ready(function() {
	// 填充文章列表数据
	$.ajax({
		type: "Get",
		url: "/api/comment/list",
		dataType: "json",
		contentType: "application/json;charset=utf-8",
		success: function(json) {
			// 先要清空原来的数据
			// $('#tbody-comments').html("");
			$.each(json, function(i, item) {
				console.log(item);
				$('#tbody-comments').append(
					'<tr><td>' + +item.id +
					'</td><td>' + item.comment +
					'</td><td>' + item.userName +
					'</td><td>' + item.email +
					'</td><td>' + item.blog_ID +
					'</td><td>' + item.date +
					'</td><td><button class="btn btn-danger deleteBtn" onclick="deleteArticleComment(\'' + item.id + '\')"><i class="fa fa-trash-o"></i>删除</button></td></tr>');
			});
			$('#dataTables-comments').dataTable();
		}
	});
});
// 监听文章Select改变，改变注入相应的评论
document.getElementById("articleList").onchange = function() {
	var articleId = $('#articleList option:selected').attr("articleId");
	//	alert(categoryId);
	addCommentList(articleId);
};

// 删除按钮点击事件
function deleteArticleComment(id) {
	$('#confirmBtn').attr("articleCommentId", id);
	$('#myModal').modal();
};

// 确认删除按钮点击事件
$('#confirmBtn').click(function() {
	var id = $(this).attr("articleCommentId");
	//	alert(id);
	$.ajax({
		type: "DELETE",
		url: "/admin/comment/article/" + id,
		success: function() {
			// 刷新页面
			location.reload();
		},
		error: function() {
			location.reload();
		}
	});
});