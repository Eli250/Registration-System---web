<%-- 
    Document   : Feedback
    Created on : Feb 16, 2021, 11:39:19 AM
    Author     : Eli
--%>
<link href="css/styles.css" rel="stylesheet">
<%@page import="edu.eli.controller.CourseInfo"%>
<%@page import="edu.eli.model.StudentModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Final Page</title>
    </head>
    <body class="submission-form">
          <%
            StudentModel stdData = (StudentModel)session.getAttribute("stdModel");
            if(stdData==null){
                stdData = new StudentModel();
                session.setAttribute("stdModel", stdData);
            }
        %>
           <%
            CourseInfo csInfo = (CourseInfo) session.getAttribute("CourseSelected");
            if (csInfo == null) {
                csInfo = new CourseInfo();
                session.setAttribute("CourseSelected", csInfo);
            }
        %>
        <h1>Registration Feedback</h1>
        <p>
            Dear <%=stdData.getsNameInput() %>, Thank you for registering.<br><br>
            You are requested to pay  <%=csInfo.totalFees() %>           
        </p>
        <a href="StudentInfo.jsp"> <button type="button">END OF SESSION</button></a>
        <%
            session.removeAttribute("CourseSelected");
            session.removeAttribute("stdModel");
            session.invalidate();
        %>
    </body>
</html>
