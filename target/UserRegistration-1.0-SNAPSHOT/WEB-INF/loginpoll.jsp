<%@ page import="java.util.List" %>
<%@ page import="com.epam.model.Poll" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Test</title>
</head>
<body>
<h1>Выберете опрос</h1>
    <ul type="*">
        <c:forEach var="poll" items="${poll}"> *
            <a href="/question?id=${poll.getId()}" class="title">
                <c:out value="${poll.getName()}"/> </a>

            <p class="description">
                <c:out value="${poll.getDescription()}"/></p>

            <form action="" method="get"  >

            </form>
        </c:forEach>
    </ul>
</body>
</html>
