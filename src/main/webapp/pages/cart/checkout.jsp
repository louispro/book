<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" language="java"%>
<html>
<head>
<title>结算页面</title>
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
			<span class="wel_word">结算</span>
			<div>
				<span>欢迎<span class="um_span">韩总</span>光临尚硅谷书城</span>
				<a href="pages/order/order.jsp">我的订单</a>
				<a href="user?action=logout">注销</a>&nbsp;&nbsp;
				<a href="client/bookServlet?action=page">返回</a>
			</div>
	</div>
	
	<div id="main">
		
		<h1>你的订单已结算，订单号为2937474382928484747</h1>
		
	
	</div>

	<!--静态包含页脚-->
	<%@ include file="/pages/common/footer.jsp"%>
</body>
</html>