<%--
  Created by IntelliJ IDEA.
  User: lyd
  Date: 2018/1/22
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>登录</title>
    <style>
        .error {
            color:red;
        }
    </style>
</head>
<body>
<div class="error">
    <c:if test="${not empty param.kickout}">您被踢出登录。</c:if>
    ${error}
</div>
    <form action="", method="post">
        用户名：<input type="text" name="username" value="<shiro:principal/>"><br/>
        密码：<input type="password" name="password"><br/>
        <%-- jcaptchaEbabled 在JCaptchaValidateFilter设置 --%>
        <c:if test="${jcaptchaEbabled}">
            验证码：
            <input type="text" name="jcaptchaCode">
            <img class="jcaptcha-btn jcaptcha-img" src="${pageContext.request.contextPath}/jcaptcha.jpg" title="点击更换验证码">
            <a class="jcaptcha-btn" href="javascript:;">换一张</a>
            <br/>
        </c:if>
        自动登录：<input type="checkbox" name="rememberMe" value="true"><br/>
        <input type="submit" value="登录">
    </form>
<script src="${pageContext.request.contextPath}/static/js/jquery-1.11.0.min.js"></script>
<script>
    $(function() {
        $(".jcaptcha-btn").click(function() {
            $(".jcaptcha-img").attr("src", '${pageContext.request.contextPath}/jcaptcha.jpg?'+new Date().getTime());
        });
    });
</script>
</body>
</html>
