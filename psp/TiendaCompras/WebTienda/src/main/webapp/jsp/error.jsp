<%--
  Created by IntelliJ IDEA.
  User: oscar
  Date: 06/10/2020
  Time: 22:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
<h1>ERROR</h1>
<c:out value="${errores}"/>
<form method="post" action="logout" style="margin-left: 40%">
    <button style="margin-left:7%" name="logout" class="btn btn-primary btn-block btn-large">Volver al login</button>
</form>
</body>
</html>
