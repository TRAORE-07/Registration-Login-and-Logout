<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LOGIN</title>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <h1>Welcome  to the login page!!!!!</h1>
        <form action="LoginServlet" method="post">
            Username: <input type="text" name="username" required>
            <br/><br/>
            Password: <input type="password" name="password" required>
            <br/><br/>
            <input type="submit" value="submit"/>
            <br><br>
            <a href="index.html">Back to the Home Page!!</a>
        </form>
    </body>
</html>
