<html>
<%@ page contentType="text/html;charset=utf-8" %>
<body>
<h2>MOVIES</h2>
<form method = "post" action = "user/register">
    <input type = "text" name = "login"></input>
    <input type = "password" name = "password"></input>
    <button type = "submit" >registration</button>
</form>
<form method = "get" action = "user/login">
    <input type = "text" name = "login"></input>
    <input type = "password" name = "password"></input>
    <button type = "submit" >login</button>
</form>
<form method = "get" action = "hello">
    <button type = "submit" >hellosss</button>
</form>
</body>
</html>
