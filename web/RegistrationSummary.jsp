<%-- 
    Document   : RegistrationSummary
    Created on : Feb 16, 2021, 11:30:49 AM
    Author     : Eli
--%>
<link href="css/styles.css" rel="stylesheet">
<%@page import="java.util.List"%>
<%@page import="edu.eli.model.Courses"%>
<%@page import="edu.eli.controller.CourseInfo"%>
<%@page import="edu.eli.model.StudentModel"%>
<link href="css/style.css" rel="stylesheet" type="text/css"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Summary</title>
    </head>
    <body>
        <h1 id="sum-h1">Registration Summary</h1>
        <%
            StudentModel stdData = (StudentModel) session.getAttribute("stdModel");
            if (stdData == null) {
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
        <table class="submission-form">
            <tr>
                <td><label>Student ID: </label></td>
                <td><%=stdData.getsIdInput()%></td>
            </tr>
            <tr>
                <td><label>Names: </label></td>
                <td><%=stdData.getsNameInput()%></td>
            </tr>
            <tr>
                <td><label>Gender: </label></td>
                <td><%=stdData.getGenderInput()%></td>
            </tr>
            <tr>
                <td><label>Date of Birth: </label></td>
                <td><%=stdData.getDobValue()%></td>
            </tr>

            <tr>
                <td><label>Number of Courses: </label></td>
                <td><%=csInfo.countCourses()%></td>
            </tr>
            <tr>
                <td><label>Total Credits: </label></td>
                <td><%=csInfo.calculateCredits()%></td>
            </tr>
            <tr>
                <td><label>Total School Fee: </label></td>
                <td><%=csInfo.totalFees()%></td>
            </tr>
            <br>
            <br>
           
        </table>
            <div class="clr"></div>
            <div class="register-now">
                <a href="CourseController">Register Now</a>
            </div>
    </body>
</html>
