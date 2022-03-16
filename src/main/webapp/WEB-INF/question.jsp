<%@ page import="com.epam.model.Question" %>
<%@ page import="java.util.List" %>
<%@ page import="com.epam.model.Answer" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<%--    <link rel="stylesheet" href="css/question.css">--%>
    <title>Questions</title>
</head>
<body>
<div class="limiter">
    <div class="container-login100">
        <form action="${getContext.request.contextPath}/results" method="get">
            <c:forEach var="question" items="${question}">
                <input type="hidden" name="questionId" value="${question.id}">
                <p class="question">
                    <c:out value="${question.getId()}"/>
                    <c:out value="${question.getText()}"/>
                </p>
                <c:forEach var="answer" items="${answer}">
                    <c:if var="question.getId" test="${ question.getId() == answer.getQuestion_id()}">

                        <p class="answer">
                            <input type="radio" name="marked${question.id}" value="${answer.getId()}">
                                ${answer.getText()} ️
                        </p>
                    </c:if>
                </c:forEach>
            </c:forEach>
            <div class="container-login100-form-btn">
                <button type="submit" value="Check" class="login100-form-btn">
                    Check
                </button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
