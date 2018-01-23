<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--导入标签库--%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<body>
<%--User相关--%>
<shiro:guest>
    欢迎游客访问，<a href="${pageContext.request.contextPath}/login.jsp">点击登录</a><br/>
</shiro:guest>
<shiro:user>
    欢迎[<shiro:principal/>]登录，<a href="${pageContext.request.contextPath}/logout">点击退出</a><br/>
</shiro:user>

<%--Authenticated相关--%>
<shiro:authenticated>
    用户[<shiro:principal/>]已身份验证通过<br/>
</shiro:authenticated>
<shiro:notAuthenticated>
    未身份验证（包括记住我）<br/>
</shiro:notAuthenticated>

<%--Role相关--%>
<shiro:hasRole name="admin">
    用户[<shiro:principal/>]拥有角色admin<br/>
</shiro:hasRole>
<shiro:hasAnyRoles name="admin,user">
    用户[<shiro:principal/>]拥有角色admin或user<br/>
</shiro:hasAnyRoles>
<shiro:lacksRole name="abc">
    用户[<shiro:principal/>]没有角色abc<br/>
</shiro:lacksRole>

<%--Permission相关--%>
<shiro:hasPermission name="user:create">
    用户[<shiro:principal/>]拥有权限user:create<br/>
</shiro:hasPermission>
<shiro:lacksPermission name="org:create">
    用户[<shiro:principal/>]没有权限org:create<br/>
</shiro:lacksPermission>

<%--Principal标签--%>
<%--显示用户身份信息，默认调用Subject.getPrincipal()获取，即Primary Principal--%>
<shiro:principal/>
<%--相当于Subject.getPrincipals().oneByType(String);--%>
<shiro:principal type="java.lang.String"/>
<%--相当于((User)Subject.getPrincipals()).getUsername();--%>
<shiro:principal property="username"/>

</body>
</html>
