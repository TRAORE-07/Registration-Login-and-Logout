<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>REGISTRATION</title>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <h1>Welcome  to the registration page!!!</h1>
        <form action="RegisterServlet" method="post">
            Username: <input type="text" name="username" required><br/><br/>
            Password: <input type="password" name="password" required><br/><br/>
            Email: <input type="text" name="email" required><br/><br/>
            Age: <input type="number" name="age" required><br/><br/>
            Contact: <input type="number" name="contact" required><br/><br/>
            Address: <input type="text" name="address" required><br/><br/>
            <input type="submit" value="Register"/><br><br>
            <a href="index.html">Back to the Home Page!!</a>
        </form>
    </body>
</html>
