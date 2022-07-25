<%-- 
    Document   : reset
    Created on : 22-Jul-2022, 1:12:05 PM
    Author     : alira
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reset Password</title>
    </head>
    <body>
        <h1>Reset Password</h1>
        <div>Please enter your email address to reset your password.</div><br>
        <form method="POST" action="">
            <div>
                <label>Email Address: </label>
                <input type="email" name="email">
            </div>
            <div>
                <input type="submit" value="Submit" id="reset">
                <input type="hidden" name="action" value="reset">
            </div>
        </form>
    </body>
</html>
