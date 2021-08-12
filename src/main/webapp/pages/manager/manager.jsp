<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" language="java"%>
<html>
<head>
<title>后台管理</title>
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
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">后台管理系统</span>
		<%@ include file="/pages/common/manage_menu.jsp"%>
	</div>
	
	<div id="main">
		<h1>欢迎管理员进入后台管理系统</h1>
	</div>

	<!--静态包含页脚-->
	<%@ include file="/pages/common/footer.jsp"%>
</body>
</html>