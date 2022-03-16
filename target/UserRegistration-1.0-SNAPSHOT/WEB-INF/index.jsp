<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <form action="<%= request.getContextPath() %>/register" method="post"/>

    <title>User Register</title>

    <link rel="stylesheet" type="text/css" href="../style.css">
    <link href="https://fonts.googleapis.com/css2?family=Jost:wght@500&display=swap" rel="stylesheet">
</head>
<body>
<div class="main">

    <input type="checkbox" id="chk" aria-hidden="true">

    <div class="signup">
        <form>
            <label for="chk" aria-hidden="true">Sign up</label>
            <input type="text" name="first_name" placeholder="First name" required="">
            <input type="text" name="last_name" placeholder="Last name" required="">
            <input type="text" name="username" placeholder="User name" required="">
            <input type="password" name="password" placeholder="Password" required="">
            <input type="text" name="address"  placeholder="Address" required="">
            <input type="text" name="email" placeholder="Email" required="">
            <button>Sign up</button>
        </form>
    </div>

    <div class="login">

        <form action="/login" method="post">
            <form>
                <label for="chk" aria-hidden="true">Login</label>
                <input type="username" name="username" placeholder="Username" required="">
                <input type="password" name="password" placeholder="Password" required="">
                <button>Login</button>
            </form>
        </form>

    </div>

</div>
</body>
</html>

<%--    <div class="login">--%>
<%--        <form>--%>
<%--            <label for="chk" aria-hidden="true">Login</label>--%>
<%--            <input type="username" name="username" placeholder="Username" required="">--%>
<%--            <input type="password" name="pswd" placeholder="Password" required="">--%>
<%--            <button>Login</button>--%>
<%--        </form>--%>
<%--    </div>--%>
<%--</div>--%>
<%--</body>--%>
<%--</html>--%>


<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <meta charset="ISO-8859-1">--%>
<%--    <title>User Registration page</title>--%>


<%--</head>--%>
<%--<body>--%>
<%--<div align="center">--%>
<%--    <h1>User Register Form</h1>--%>
<%--    <form action="<%= request.getContextPath() %>/login" method="post">--%>
<%--        <table style="with: 100%">--%>

<%--            <td>Username</td>--%>
<%--            <td><input type="text" name="username" /></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>Password</td>--%>
<%--                <td><input type="password" name="password" /></td>--%>
<%--            </tr>--%>

<%--        </table>--%>
<%--        <input type="submit" value="Log In" />--%>

<%--    </form>--%>
<%--    <form action="<%= request.getContextPath() %>/register.jsp" method="post">--%>

<%--        <input type="submit" value="Register" />--%>
<%--    </form>--%>
<%--</div>--%>
<%--</body>--%>
<%--</html>--%>

