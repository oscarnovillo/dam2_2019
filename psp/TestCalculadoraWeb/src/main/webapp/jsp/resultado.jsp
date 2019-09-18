<%-- 
    Document   : resultado
    Created on : 18 sept. 2019, 9:40:03
    Author     : oscar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <img src="/primera/assert/img/gato.jpg" />
        <h1>Hello World!</h1>
        <c:out value="${test}"/>
        <table border="1">
        <c:forEach var="item" items="${numList}"  >
            <tr><td>${item}</td></tr>
        </c:forEach>
         </table>
    </body>
</html>
