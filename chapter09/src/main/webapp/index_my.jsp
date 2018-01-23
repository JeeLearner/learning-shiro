<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--自定义标签--%>
<%@taglib prefix="jeeLearner" tagdir="/WEB-INF/tags" %>
<html>
<body>
<jeeLearner:hasAllRoles name="admin,user">
    用户[<shiro:principal/>]拥有角色admin和user<br/>
</jeeLearner:hasAllRoles>
<jeeLearner:hasAllPermissions name="user:create,user:update">
    用户[<shiro:principal/>]拥有权限user:create和user:update<br/>
</jeeLearner:hasAllPermissions>
<jeeLearner:hasAnyPermissions name="user:create,abc:update">
    用户[<shiro:principal/>]拥有权限user:create或abc:update<br/>
</jeeLearner:hasAnyPermissions>
</body>
</html>
