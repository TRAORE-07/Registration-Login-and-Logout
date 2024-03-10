<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>WELCOME</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <h1>WELCOME USER <%= session.getAttribute("username") %> !</h1>
    <form>
        <a href="LogoutServlet">Logout</a>
    </form>
</body>
</html>
