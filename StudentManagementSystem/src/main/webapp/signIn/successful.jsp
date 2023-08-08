<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.solider.bean.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="com.solider.service.StudentService" %>
<%@ page import="com.solider.service.impl.StudentServiceImpl" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
	<head>
		<!-- 指定字符集 -->
		<meta charset="utf-8">
		<!-- 使用Edge最新的浏览器的渲染方式 -->
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
		width: 默认宽度与设备的宽度相同
		initial-scale: 初始的缩放比，为1:1 -->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
		<link rel="stylesheet" href="../css/bootstrap.min.css">
		<script src="../js/successful.js"></script>
		<title>学生信息管理系统</title>
		<style type="text/css">
            td, th {
                text-align: center;
            }
		</style>
	</head>
	<body>
		<div class="container">
			<h3 style="text-align: center">学生信息列表</h3>

			<div style="float: left;">

				<form class="form-inline" action="${pageContext.request.contextPath}/findStudent"
				      method="post">
					<div class="form-group">
						<label for="exampleInputName2">学生姓名</label>
						<input type="text" name="name" class="form-control"
						       id="exampleInputName2">
					</div>
					<button type="submit" class="btn btn-default">查询</button>
				</form>

			</div>

			<div style="float: right;margin: 5px;">
				<a class="btn btn-primary" href="#">退出</a>
				<a class="btn btn-primary" href="${pageContext.request.contextPath}/function/add.jsp">添加学生</a>
				<a class="btn btn-primary" id="unCheckSelected">取消选中</a>

			</div>
			<form id="form" action="${pageContext.request.contextPath}/delSelected" method="post">
				<table border="1" class="table table-bordered table-hover">
					<tr class="success">
						<th><input type="checkbox" id="firstBox"></th>
						<th>姓名</th>
						<th>年龄</th>
						<th>性别</th>
						<th>年级</th>
					</tr>

					<%
						StudentService studentService = new StudentServiceImpl();
						List<Student> students = studentService.studentList();
					%>
					<c:forEach items="<%=students%>" var="student">
						<tr>
							<td><input type="checkbox" name="checkbox" value="${student.id}"></td>
							<td>${student.name}</td>
							<td>${student.age}</td>
							<td>${student.sex}</td>
							<td>${student.grade}</td>
						</tr>
					</c:forEach>
					<button type="submit" class="btn btn-primary" id="delSelected">删除选中数据</button>
				</table>
			</form>
			<%--			<div>--%>
			<%--				<nav aria-label="Page navigation">--%>
			<%--					<ul class="pagination">--%>
			<%--						<c:if test="${pb.currentPage == 1}">--%>
			<%--						<li class="disabled">--%>
			<%--							</c:if>--%>

			<%--							<c:if test="${pb.currentPage != 1}">--%>
			<%--						<li>--%>
			<%--							</c:if>--%>


			<%--							<a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${pb.currentPage - 1}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}"--%>
			<%--							   aria-label="Previous">--%>
			<%--								<span aria-hidden="true">&laquo;</span>--%>
			<%--							</a>--%>
			<%--						</li>--%>


			<%--						<c:forEach begin="1" end="${pb.totalPage}" var="i">--%>


			<%--							<c:if test="${pb.currentPage == i}">--%>
			<%--								<li class="active"><a--%>
			<%--										href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${i}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}">${i}</a>--%>
			<%--								</li>--%>
			<%--							</c:if>--%>
			<%--							<c:if test="${pb.currentPage != i}">--%>
			<%--								<li>--%>
			<%--									<a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${i}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}">${i}</a>--%>
			<%--								</li>--%>
			<%--							</c:if>--%>

			<%--						</c:forEach>--%>


			<%--						<li>--%>
			<%--							<a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${pb.currentPage + 1}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}"--%>
			<%--							   aria-label="Next">--%>
			<%--								<span aria-hidden="true">&raquo;</span>--%>
			<%--							</a>--%>
			<%--						</li>--%>
			<%--						<span style="font-size: 25px;margin-left: 5px;">--%>
			<%--                    共${pb.totalCount}条记录，共${pb.totalPage}页--%>
			<%--                </span>--%>
			<%--					</ul>--%>
			<%--				</nav>--%>
			<%--			</div>--%>
		</div>
	</body>
</html>
