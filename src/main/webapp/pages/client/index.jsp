<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>书城首页</title>
    <!--静态包含base标签，css，js-->
    <%@ include file="/pages/common/head.jsp"%>
    <script type="text/javascript">
        $(function(){
            $(".addCartBtn").click(function(){
                var bookId = $(this).attr("bookId");
                var pageNo = $(this).attr("pageNo");
                $.getJSON("http://localhost:8080/book/cart","action=addGood&bookId="+bookId+"&pageNo="+pageNo,function (data){
                    $("#cartTotalCount").text("您的购物车中有"+data.totalCount+"件商品")
                    $("#cartLastName").text("您刚刚将"+data.goodName+"加入到了购物车中")
                })
            })
        })
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.png" >
    <span class="wel_word">网上书城</span>
    <div>
        <!--如果用户信息为空-->
        <c:if test="${empty sessionScope.user}">
            <a href="pages/user/login.jsp">登录</a>
            <a href="pages/user/regist.jsp">注册</a> &nbsp;&nbsp;
        </c:if>
        <!--如果用户信息不空-->
        <c:if test="${not empty sessionScope.user}">
            <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临尚硅谷书城</span>
            <a href="order?action=showMyOrders">我的订单</a>
            <a href="user?action=logout">注销</a>&nbsp;
        </c:if>
        <!--未登录则跳转到登录界面-->
        <a href="${sessionScope.user==null?"pages/user/login.jsp":"pages/cart/cart.jsp"}">购物车</a>
        <a href="pages/manager/manager.jsp">后台管理</a>
    </div>
</div>
<div id="main">
    <div id="book">
        <div class="book_cond">
            <form action="client/bookServlet" method="get">
                <input type="hidden" name="action" value="pageByPrice">
                价格：<input id="min" type="text" name="min" value="${param.min}"> 元 -
                <input id="max" type="text" name="max" value="${param.max}"> 元
                <input type="submit" value="查询" />
            </form>
        </div>
        <div style="text-align: center">
            <c:choose>
                <c:when test="${sessionScope.cart.totalCount == 0}">
                    <span></span>
                    <div>
                        <span style="color: red">您的购物车为空</span>
                    </div>
                </c:when>
                <c:otherwise>
                    <span id="cartTotalCount"></span>
                    <div>
                        <span id="cartLastName" style="color: red"></span>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>

        <c:forEach items="${requestScope.page.items}" var="book">
            <div class="b_list">
                <div class="img_div">
                    <img class="book_img" alt="" src="static/img/book/${book.imageUrl}" />
                </div>
                <div class="book_info">
                    <div class="book_name">
                        <span class="sp1">书名:</span>
                        <span class="sp2">${book.name}</span>
                    </div>
                    <div class="book_author">
                        <span class="sp1">作者:</span>
                        <span class="sp2">${book.author}</span>
                    </div>
                    <div class="book_price">
                        <span class="sp1">价格:</span>
                        <span class="sp2">${book.price}</span>
                    </div>
                    <div class="book_sales">
                        <span class="sp1">销量:</span>
                        <span class="sp2">${book.sale}</span>
                    </div>
                    <div class="book_amount">
                        <span class="sp1">库存:</span>
                        <span class="sp2">${book.stock}</span>
                    </div>
                    <div class="book_add">
                        <button bookId="${book.id}" pageNo="${requestScope.page.pageNo}" class="addCartBtn">加入购物车</button>
                    </div>
                </div>
            </div>
        </c:forEach>

        <div id="page_nav">
            <c:if test="${requestScope.page.pageNo > 1}">
                <a href="${page.url}&pageNo=1">首页</a>
                <a href="${page.url}&pageNo=${requestScope.page.pageNo-1}">上一页</a>
            </c:if>

            <c:choose>
                <c:when test="${requestScope.page.pageTotal<=5}">
                    <c:forEach begin="1" end="${requestScope.page.pageTotal}" var="i">
                        <c:if test="${requestScope.page.pageNo == i}">
                            【${i}】
                        </c:if>
                        <c:if test="${requestScope.page.pageNo != i}">
                            <a href="${page.url}&pageNo=${i}">${i}</a>
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
                                    <a href="${page.url}&pageNo=${i}">${i}</a>
                                </c:if>
                            </c:forEach>
                        </c:when>
                        <c:when test="${requestScope.page.pageNo>requestScope.page.pageTotal-3}">
                            <c:forEach begin="${requestScope.page.pageTotal-4}" end="${requestScope.page.pageTotal}" var="i">
                                <c:if test="${requestScope.page.pageNo == i}">
                                    【${i}】
                                </c:if>
                                <c:if test="${requestScope.page.pageNo != i}">
                                    <a href="${page.url}&pageNo=${i}">${i}</a>
                                </c:if>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <c:forEach begin="${requestScope.page.pageNo-2}" end="${requestScope.page.pageNo+2}" var="i">
                                <c:if test="${requestScope.page.pageNo == i}">
                                    【${i}】
                                </c:if>
                                <c:if test="${requestScope.page.pageNo != i}">
                                    <a href="${page.url}&pageNo=${i}">${i}</a>
                                </c:if>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                </c:when>
            </c:choose>

            <c:if test="${requestScope.page.pageNo < requestScope.page.pageTotal}">
                <a href="${page.url}&pageNo=${requestScope.page.pageNo+1}">下一页</a>
                <a href="${page.url}&pageNo=${requestScope.page.pageTotal}">末页</a>
            </c:if>
            共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录 到第<input value="${requestScope.page.pageNo}" name="pn" id="pn_input"/>页
            <input id="serachBtn" type="button" value="确定">
            <script type="text/javascript">
                $(function(){
                    $("#serachBtn").click(function(){
                        var pageNo = $("#pn_input").val();
                        location.href = "http://localhost:8080/book/${page.url}&pageNo="+pageNo;
                    })
                })
            </script>
        </div>

</div>
<!--静态包含页脚-->
<%@ include file="/pages/common/footer.jsp"%>
</body>
</html>
