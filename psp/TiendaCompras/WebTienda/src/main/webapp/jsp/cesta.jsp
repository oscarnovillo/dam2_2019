<%--
  Created by IntelliJ IDEA.
  User: emily
  Date: 27/10/2020
  Time: 20:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Cesta</title>
</head>
<body style="margin: 2%">
<h1>CESTA</h1>
<c:if test="${!listaCesta.isEmpty()&&listaCesta!=null}">
    <table style="margin: 3%">
        <tr style="padding: 1%">
            <td style="text-align: center; font-weight: bold;padding: 1%">PRODUCTOS</td>
        </tr>
        <c:forEach var="producto" items="${listaCesta}">
            <tr style="padding: 1%">
                <td style="padding: 1%"><c:out value="${producto}"/></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<c:if test="${listaCesta.isEmpty() || listaCesta==null}">
    <br><h4 style="margin-left: 5%"> <c:out value="${cestaMensaje}"/></h4>
</c:if>
<form method="post" action="cesta">
    <button style="margin-left:7%" type="submit" name="comprar" class="btn btn-primary btn-block btn-large">COMPRAR
    </button>
    <input type="hidden" name="opcion" value="buy"/>
</form>
<form method="post" action="cesta">
    <button style="margin-left:7%" type="submit" name="vaciar" class="btn btn-primary btn-block btn-large">VACIAR CARRITO
    </button>
    <input type="hidden" name="opcion" value="clear"/>
</form>
<div style="margin-left: 40%">
    <a href="productos">volver a productos </a>
    <br/>
    <a href="logout">Cerrar sesión </a>

</div>
</body>
</html>
