<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" language="java"%>
<html>
<head>
<title>我的订单</title>
	<!--静态包含base标签，css，js-->
	<%@ include file="/pages/common/head.jsp"%>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.png" >
			<span class="wel_word">我的订单</span>
			<div>
				<span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临尚硅谷书城</span>
				<a href="order?action=showMyOrders">我的订单</a>
				<a href="user?action=logout">注销</a>&nbsp;&nbsp;
				<a href="client/bookServlet?action=page">返回</a>
			</div>
	</div>
	
	<div id="main">
		
		<table>
			<tr>
				<td>日期</td>
				<td>金额</td>
				<td>状态</td>
				<td>详情</td>
			</tr>
				<c:forEach items="${requestScope.orders}" var="order">
					<tr>
						<td>${order.createTime}</td>
						<td>${order.price}</td>
						<td>
							<c:choose>
								<c:when test="${order.status==0}">未发货</c:when>
								<c:when test="${order.status==1}">已发货</c:when>
								<c:otherwise>已签收</c:otherwise>
							</c:choose>
						</td>
						<td><a href="order?action=showOrderDetail&orderId=${order.orderId}">查看详情</a></td
					</tr>
				</c:forEach>
		</table>
		
	
	</div>

	<!--静态包含页脚-->
	<%@ include file="/pages/common/footer.jsp"%>
</body>
</html>