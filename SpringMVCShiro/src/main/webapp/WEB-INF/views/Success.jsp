<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html>
<head>
    <title>Success</title>
</head>
<body>
Login Success
<br/>
Welcome: <shiro:principal></shiro:principal> <%--显示用户身份--%>
<br/>

<shiro:hasRole name="user">
    <a href="/user">user</a>
</shiro:hasRole>

<shiro:hasRole name="admin">
    <a href="/admin">admin</a>
</shiro:hasRole>

<br/>

<a href="/testShiroAnnotation">Shiro Annotation</a>>
<a href="/logout">logout</a>
</body>
</html>
