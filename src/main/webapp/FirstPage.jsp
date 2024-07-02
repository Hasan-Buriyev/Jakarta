<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>GULLIVER</title>
    <link rel="stylesheet" href="front/css/FirstPage.css">
</head>
<body>
<form method="post" id="form">
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
        <button class="sign" onclick="window.location.href='SignUp.jsp'">Sign Up</button>
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
