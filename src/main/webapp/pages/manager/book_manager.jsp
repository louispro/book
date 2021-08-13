<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>图书管理</title>
	<!--静态包含base标签，css，js-->
	<%@ include file="/pages/common/head.jsp"%>
	<script type="text/javascript">
		$(function (){
			$(".deleteHref").click(function(){
				return confirm("确定删除" + $(this).parent().parent().find("td:first").text()+ "吗？");
			})
		})
	</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">图书管理系统</span>
		<%@ include file="/pages/common/manage_menu.jsp"%>
	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>作者</td>
				<td>销量</td>
				<td>库存</td>
				<td colspan="2">操作</td>
			</tr>

			<c:forEach items="${requestScope.bookList}" var="book">
				<tr>
					<td>${book.name}</td>
					<td>${book.price}</td>
					<td>${book.author}</td>
					<td>${book.sale}</td>
					<td>${book.stock}</td>
					<td><a href="manager/book?action=getBook&id=${book.id}">修改</a></td>
					<td><a class="deleteHref" href="manager/book?action=delete&id=${book.id}&imageUrl=${book.imageUrl}">删除</a></td>
				</tr>
			</c:forEach>
			
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/manager/book_edit.jsp">添加图书</a></td>
			</tr>	
		</table>
	</div>

	<!--静态包含页脚-->
	<%@ include file="/pages/common/footer.jsp"%>
</body>
</html>