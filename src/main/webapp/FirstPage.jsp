<%--
  Created by IntelliJ IDEA.
  User: hasan
  Date: 6/29/2024
  Time: 12:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>OSS</title>
    <link rel="stylesheet" href="res/FirstPage.css">
</head>
<body>
<form method="post">
    <%if (request.getMethod().equals("GET")) {%>
    <div>
        <label for="username">Username : </label>
        <input type="text" name="username" id="username">
    </div>
    <div>
        <label for="password">Password : </label>
        <input type="password" name="password" id="password">
    </div>
    <div>
        <button name="sub" type="submit">Submit</button>
    </div>
    <%}%>
    <%if (request.getMethod().equals("POST")){%>
    <h1>Username</h1>
    <h1><%= request.getParameter("username")%></h1>
    <h1>Password</h1>
    <h1><%= request.getParameter("password")%></h1>
    <%}%>


</form>
</body>
</html>
