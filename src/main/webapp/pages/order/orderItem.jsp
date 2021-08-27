<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" language="java"%>
<html>
<head>
    <title>订单详情</title>
    <!--静态包含base标签，css，js-->
    <%@ include file="/pages/common/head.jsp"%>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif" >
    <span class="wel_word">订单详情</span>
    <%@ include file="/pages/common/manage_menu.jsp"%>
</div>

<div id="main">
    <table>
        <tr>
            <td>商品</td>
            <td>数量</td>
            <td>单价</td>
            <td>总价</td>
        </tr>
        <c:forEach items="${requestScope.orderItems}" var="orderItem">
            <tr>
                <td>${orderItem.goodName}</td>
                <td>${orderItem.count}</td>
                <td>${orderItem.price}</td>
                <td>${orderItem.totalPrice}</td>
            </tr>
        </c:forEach>
    </table>
</div>

<!--静态包含页脚-->
<%@ include file="/pages/common/footer.jsp"%>
</body>
</html>
