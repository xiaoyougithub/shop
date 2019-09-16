<%--
  Created by IntelliJ IDEA.
  User: ThinkPad
  Date: 2019/8/13
  Time: 8:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="site-nav-bg">
    <div class="site-nav w1200">
        <p class="sn-back-home">
            <i class="layui-icon layui-icon-home"></i>
            <a href="#">首页xx</a>
        </p>
        <div class="sn-quick-menu">
            <div class="login">
                <c:if test="${userInfo !=null}">
                    <a href="#">${userInfo.username}</a>
                </c:if>
                <c:if test="${userInfo ==null}">
                    <a href="${pageContext.request.contextPath}/jsp/login.jsp">登录</a>
                </c:if>




            </div>
            <div class="sp-cart"><a href="${pageContext.request.contextPath}/toCart">购物车</a><span>2</span></div>
        </div>
    </div>
</div>

<div class="header">
    <div class="headerLayout w1200">
        <div class="headerCon">
            <h1 class="mallLogo">
                <a href="#" title="母婴商城">
                    <img src="${pageContext.request.contextPath}/res/static/img/logo.png">
                </a>
            </h1>
            <div class="mallSearch">
                <form action="" class="layui-form" novalidate>
                    <input type="text" name="title" required  lay-verify="required" autocomplete="off" class="layui-input" placeholder="请输入需要的商品">
                    <button class="layui-btn" lay-submit lay-filter="formDemo">
                        <i class="layui-icon layui-icon-search"></i>
                    </button>
                    <input type="hidden" name="" value="">
                </form>
            </div>
        </div>
    </div>
</div>