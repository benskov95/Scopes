<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mozuh
  Date: 18-02-2020
  Time: 12:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Start</title>
</head>

<body>
<h1>Velkommen til min side</h1>

du er nu logget ind som ${requestScope.navn} på requestscopet
<br>
du er nu logget ind som ${sessionScope.bruger} på sessionscopet
<br>
<br>
Her kommer alle brugerne:
<br>
<br>
<c:forEach var="element" items="${applicationScope.brugere}">

    ${element}
    <br>

</c:forEach>
<br>

<form action="MinServlet", method="post">
    <label for="fname">First name:</label><br>
    <input type="text" id="fname" name="navn"><br>
    <input type="submit" value="Submit">
</form>

<br>
<br>
Nu går vi lige til en anden side.
<br>
<form action="MinServlet", method="get">
    <input type="submit" value="Gå til velkommen">
</form>


</body>
</html>
