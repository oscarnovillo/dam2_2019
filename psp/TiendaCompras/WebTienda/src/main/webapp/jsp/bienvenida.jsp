<%--
  Created by IntelliJ IDEA.
  User: emily
  Date: 28/10/2020
  Time: 12:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Bienvenida</title>
</head>
<body style="margin: 3%">
<h1>BIENVENID@ A NUESTRA TIENDA <c:out value="${nombreUsuario}"/></h1>

<a style="margin: 2%" href="productos">Ver productos</a>
<br><br>
<form method="post" action="cesta">
    <a style="margin: 2%" href="cesta">Ver cesta</a>
    <input type="hidden" name="opcion" value="show"/>
</form>
<form method="post" action="logout" style="margin-left: 40%">
    <button style="margin-left:7%" name="logout" class="btn btn-primary btn-block btn-large">Cerrar
        sesión
    </button>
</form>
</body>
</html>
