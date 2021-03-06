<%@ page import="com.louis.bean.Book" %>
<%@ page import="com.louis.bean.Page" %>
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

			<c:forEach items="${requestScope.page.items}" var="book">
				<tr>
					<td>${book.name}</td>
					<td>${book.price}</td>
					<td>${book.author}</td>
					<td>${book.sale}</td>
					<td>${book.stock}</td>
					<td><a href="manager/book?action=getBook&id=${book.id}&pageNo=${requestScope.page.pageNo}">修改</a></td>
					<td><a class="deleteHref" href="manager/book?action=delete&id=${book.id}&imageUrl=${book.imageUrl}&pageNo=${requestScope.page.pageNo}">删除</a></td>
				</tr>
			</c:forEach>
			
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/manager/book_edit.jsp?pageNo=${requestScope.page.pageTotal}">添加图书</a></td>
			</tr>	
		</table>

		<div id="page_nav">
			<c:if test="${requestScope.page.pageNo > 1}">
				<a href="manager/book?action=page&pageNo=1">首页</a>
				<a href="manager/book?action=page&pageNo=${requestScope.page.pageNo-1}">上一页</a>
			</c:if>

			<c:choose>
				<c:when test="${requestScope.page.pageTotal<=5}">
					<c:forEach begin="1" end="${requestScope.page.pageTotal}" var="i">
						<c:if test="${requestScope.page.pageNo == i}">
							【${i}】
						</c:if>
						<c:if test="${requestScope.page.pageNo != i}">
							<a href="manager/book?action=page&pageNo=${i}">${i}</a>
						</c:if>
					</c:forEach>
				</c:when>
				<c:when test="${requestScope.page.pageTotal>5}">
					<c:choose>
						<c:when test="${requestScope.page.pageNo<3}">
							<c:forEach begin="${1}" end="${5}" var="i">
								<c:if test="${requestScope.page.pageNo == i}">
									【${i}】
								</c:if>
								<c:if test="${requestScope.page.pageNo != i}">
									<a href="manager/book?action=page&pageNo=${i}">${i}</a>
								</c:if>
							</c:forEach>
						</c:when>
						<c:when test="${requestScope.page.pageNo>requestScope.page.pageTotal-3}">
							<c:forEach begin="${requestScope.page.pageTotal-4}" end="${requestScope.page.pageTotal}" var="i">
								<c:if test="${requestScope.page.pageNo == i}">
									【${i}】
								</c:if>
								<c:if test="${requestScope.page.pageNo != i}">
									<a href="manager/book?action=page&pageNo=${i}">${i}</a>
								</c:if>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<c:forEach begin="${requestScope.page.pageNo-2}" end="${requestScope.page.pageNo+2}" var="i">
								<c:if test="${requestScope.page.pageNo == i}">
									【${i}】
								</c:if>
								<c:if test="${requestScope.page.pageNo != i}">
									<a href="manager/book?action=page&pageNo=${i}">${i}</a>
								</c:if>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</c:when>
			</c:choose>

			<c:if test="${requestScope.page.pageNo < requestScope.page.pageTotal}">
				<a href="manager/book?action=page&pageNo=${requestScope.page.pageNo+1}">下一页</a>
				<a href="manager/book?action=page&pageNo=${requestScope.page.pageTotal}">末页</a>
			</c:if>
			共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录 到第<input value="${requestScope.page.pageNo}" name="pn" id="pn_input"/>页
			<input id="serachBtn" type="button" value="确定">
			<script type="text/javascript">
				$(function(){
					$("#serachBtn").click(function(){
						var pageNo = $("#pn_input").val();
						location.href = "http://localhost:8080/book/manager/book?action=page&pageNo="+pageNo;
					})
				})
			</script>
		</div>
	</div>

	<!--静态包含页脚-->
	<%@ include file="/pages/common/footer.jsp"%>
</body>
</html>