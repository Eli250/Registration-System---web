<%-- 
    Document   : errorPage
    Created on : Feb 16, 2021, 1:52:37 PM
    Author     : Eli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
    </head>
    <body>
        <h1>There Was an Error!!!</h1><br>
        <p><%=request.getAttribute("errorMessage") %></p>
    </body>
</html>
