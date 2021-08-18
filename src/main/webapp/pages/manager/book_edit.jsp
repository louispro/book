<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" language="java"%>
<html>
<head>
<title>编辑图书</title>
	<!--静态包含base标签，css，js-->
	<%@ include file="/pages/common/head.jsp"%>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}
	
	input {
		text-align: center;
	}
</style>
</head>
<body>
		<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">编辑图书</span>
			<%@ include file="/pages/common/manage_menu.jsp"%>
		</div>
		
		<div id="main" style="width:1400px">
			<form action="manager/book?action=${requestScope.book==null?"add":"update"}" method="post" enctype="multipart/form-data">
				<input type="hidden" name="pageNo" value="${param.pageNo}">
				<input type="hidden" name="id" value="${requestScope.book.id}">
				<table>
					<tr>
						<td>名称</td>
						<td>价格</td>
						<td>作者</td>
						<td>销量</td>
						<td>库存</td>
						<td>图片</td>
						<td colspan="2">操作</td>
					</tr>		
					<tr>
						<td><input name="name" type="text" value="${requestScope.book==null?"":requestScope.book.name}"/></td>
						<td><input name="price" type="text" value="${requestScope.book==null?"":requestScope.book.price}"/></td>
						<td><input name="author" type="text" value="${requestScope.book==null?"":requestScope.book.author}"/></td>
						<td><input name="sale" type="text" value="${requestScope.book==null?"":requestScope.book.sale}"/></td>
						<td><input name="stock" type="text" value="${requestScope.book==null?"":requestScope.book.stock}"/></td>
						<td><input name="imageUrl" type="file" value="上传图片"></td>
						<td><input type="submit" value="提交"/></td>
					</tr>	
				</table>
			</form>
			
	
		</div>


		<!--静态包含页脚-->
		<%@ include file="/pages/common/footer.jsp"%>
</body>
</html>