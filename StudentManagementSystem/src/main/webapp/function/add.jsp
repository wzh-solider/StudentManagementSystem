<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">

	<head>
		<!-- 指定字符集 -->
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>修改</title>

		<link href="../css/bootstrap.min.css" rel="stylesheet">
		<!-- <script src="js/jquery-2.1.0.min.js"></script>
			<script src="js/bootstrap.min.js"></script>
			<script src="js/common.js"></script> -->
		<script src="../js/option.js"></script>

	</head>


	<body>
		<div class="container" style="width: 400px;">
			<h3 style="text-align: center;">添加学生</h3>
			<form action="${pageContext.request.contextPath}/addStudent" method="post">

				<div class="form-group">
					<label for="name">姓名：</label>
					<input type="text" class="form-control" id="name" name="name" placeholder="请输入姓名"/>
				</div>

				<div class="form-group">
					<label for="age">年龄：</label>
					<input type="text" class="form-control" id="age" name="age" placeholder="请输入年龄"/>
				</div>

				<div class="form-group">
					<label>性别：</label>
					<input type="radio" name="sex" value="男" checked/>男
					<input type="radio" name="sex" value="女"/>女
				</div>

				<!-- 创建一个下拉表单 -->
				<select name="grade" id="grade">
				</select>


				<div class="form-group" style="text-align: center">
					<input class="btn btn-primary" type="submit" value="提交"/>
					<input class="btn btn-default" id="back" type="button" value="返回"/>
				</div>
			</form>
		</div>
	</body>

</html>