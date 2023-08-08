<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.solider.bean.Student" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
	<head>
		<!-- 指定字符集 -->
		<meta charset="utf-8">
		<!-- 使用Edge最新的浏览器的渲染方式 -->
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
		width: 默认宽度与设备的宽度相同
		initial-scale: 初始的缩放比，为1:1 -->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="../StudentManagementSystem/css/bootstrap.min.css">
		<title>QueryStudentByName</title>
	</head>
	<body>
		<table border="1" class="table table-bordered table-hover">
			<tr class="success">
				<th><input type="checkbox" id="firstCb"></th>
				<th>姓名</th>
				<th>年龄</th>
				<th>性别</th>
				<th>年级</th>
			</tr>

			<c:forEach items="${students}" var="student">
				<tr>
					<td><input type="checkbox"></td>
					<td>${student.name}</td>
					<td>${student.age}</td>
					<td>${student.sex}</td>
					<td>${student.grade}</td>
				</tr>
			</c:forEach>

		</table>
	</body>
</html>
