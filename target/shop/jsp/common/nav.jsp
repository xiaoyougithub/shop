<%--
  Created by IntelliJ IDEA.
  User: ThinkPad
  Date: 2019/8/13
  Time: 8:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<div class="main-nav">
    <div class="inner-cont0">
        <div class="inner-cont1 w1200">
            <div class="inner-cont2">
                <a href="${pageContext.request.contextPath}/findProductByPage" class="active">所有商品</a>
                <a href="${pageContext.request.contextPath}/jsp/buytoday.jsp">今日团购</a>
                <a href="${pageContext.request.contextPath}/jsp/information.jsp">母婴资讯</a>
                <a href="${pageContext.request.contextPath}/jsp/about.jsp">关于我们</a>
            </div>
        </div>
    </div>
</div>