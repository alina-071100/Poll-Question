<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Results</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body>
<div class="limiter">
    <div class="container-login100">
        <h2 class="title"> Poll result :</h2>
        <p class="description"><c:out value="${weight.getExplanation()}"/></p>
        <form action="<%= request.getContextPath() %>/poll" method="get" class="login100-form validate-form">
            <div class="container-login100-form-btn">
                <button type="submit" value="Poll" class="login100-form-btn">
                    Poll
                </button>
            </div>
        </form>
        <form action="<%= request.getContextPath() %>/logout" method="get" class="login100-form validate-form">
            <div class="container-login100-form-btn">
                <button type="submit" value="Poll" class="login100-form-btn">
                    Log out
                </button>
            </div>
        </form>
    </div>
</div>
</body>
</html>