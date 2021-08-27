
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>购物车</title>
	<!--静态包含base标签，css，js-->
	<%@ include file="/pages/common/head.jsp"%>
	<script type="text/javascript">
		$(function(){
			/**
			 * 删除商品显示确认框
			 */
			$(".deleteGood").click(function (){
				return confirm("确定删除"+$(this).parent().parent().find("td:first").text()+"吗？");
			})

			/**
			 * 清空购物车
			 */
			$("#clearCart").click(function (){
				return confirm("确定清空购物车吗？")
			})

			/**
			 * 修改商品数量
			 * change表示内容修改
			 */
			$(".updateCount").change(function(){
				var name = $(this).parent().parent().find("td:first").text();
				var count = this.value;
				if(count <= 0 || count == null){
					alert("商品数量不正确")
					this.value = this.defaultValue;
				}else{
					var goodId = $(this).attr("goodId");
					if( confirm("确定要修改"+name+"数量吗？") ) {
						location.href = "http://localhost:8080/book/cart?action=updateCount&count="+count+"&goodId="+goodId;
					}else{
						this.value = this.defaultValue;
					}
				}
			})
		})
	</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.png" >
			<span class="wel_word">购物车</span>
			<div>
				<span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临尚硅谷书城</span>
				<a href="order?action=showMyOrders">我的订单</a>
				<a href="user?action=logout">注销</a>&nbsp;&nbsp;
				<a href="client/bookServlet?action=page">返回</a>
			</div>
	</div>
	<c:choose>
		<c:when test="${sessionScope.cart.totalCount == 0}">
			<div id="main">
				<table>
					<tr>
						<td>商品名称</td>
						<td>数量</td>
						<td>单价</td>
						<td>金额</td>
						<td>操作</td>
					</tr>
					<tr>
						<a href="client/bookServlet?action=page">亲！您的购物车空空如也，去商城买点吧！</a>
					</tr>
				</table>
			</div>
		</c:when>
		<c:otherwise>
			<div id="main">

				<table>
					<tr>
						<td>商品名称</td>
						<td>数量</td>
						<td>单价</td>
						<td>金额</td>
						<td>操作</td>
					</tr>
					<c:forEach items="${sessionScope.cart.items}" var="good">
						<tr>
							<td>${good.goodName}</td>
							<td><input goodId="${good.goodId}" class="updateCount" style="width:80px;" type="text" value="${good.goodCount}"></td>
							<td>${good.goodPrice}</td>
							<td>${good.totalPrice}</td>
							<td><a class="deleteGood" href="cart?action=deleteGood&cartId=${sessionScope.cart.cartId}&goodId=${good.goodId}">删除</a></td>
						</tr>
					</c:forEach>
				</table>

				<div class="cart_info">
					<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
					<span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
					<span class="cart_span"><a id="clearCart" href="cart?action=clear&cartId=${sessionScope.cart.cartId}">清空购物车</a></span>
					<span class="cart_span"><a href="order?action=createOrder">去结账</a></span>
				</div>

			</div>
		</c:otherwise>
	</c:choose>

	<!--静态包含页脚-->
	<%@ include file="/pages/common/footer.jsp"%>
</body>
</html>