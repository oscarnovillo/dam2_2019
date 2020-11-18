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
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Productos</title>
</head>
<body style="margin: 2%">
<h1>PRODUCTOS</h1>
<form method="post" action="cesta">
    <c:if test="${!listaProductos.isEmpty()}">
        <table style="margin: 3%">
            <tr style="padding: 1%">
                <td style="text-align: center; font-weight: bold;padding: 1%">NOMBRE PRODUCTO</td>
                <td style="text-align: center; font-weight: bold;padding: 1%">PRECIO</td>
            </tr>
            <c:forEach var="producto" items="${listaProductos}">
                <tr style="padding: 1%">
                    <td style="padding: 1%"><input type="checkbox" name="producto" value="<c:out
                            value="${producto.getNombreProducto()}"/>">
                        <c:out value="${producto.getNombreProducto()}"/>
                    </td>
                    <td style="padding: 1%"><c:out value="${producto.getPrecioProducto()}"/></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <c:if test="${listaProductos.isEmpty()}">
        <br><h4 style="margin-left: 5%"> No hay productos disponibles</h4>
    </c:if>
    <br>
    <button style="margin-left:7%" type="submit" name="entrar" class="btn btn-primary btn-block btn-large">AÑADIR A LA
        CESTA
    </button>
    <input type="hidden" name="opcion" value="add"/>
</form>
<div style="margin-left: 40%">
    <form method="post" action="logout">
        <button style="margin:2%" name="logout" class="btn btn-primary btn-block btn-large">Cerrar
            sesión
        </button>
    </form>
</div>
</body>
</html>
