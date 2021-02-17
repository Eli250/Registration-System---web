<%-- 
    Document   : ChooseCourses
    Created on : Feb 15, 2021, 8:48:09 AM
    Author     : Eli
--%>
<%@page import="edu.eli.model.StudentModel"%>
<%@page import="edu.eli.model.Student"%>
<link href="css/styles.css" rel="stylesheet">
<%@page import="edu.eli.controller.CourseInfo"%>
<%@page import="java.util.List"%>
<%@page import="edu.eli.model.Courses"%>
<%@page import="edu.eli.dao.GenericDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Courses</title>
    </head>
    <body>

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
        <%
            if (stdData == null) {
        %>
        <h4> Session Terminated, Please goto<a href="StudentInfo.jsp"> Student Registration Page</a></h4>
        <%
                return;
            }
        %>
        <header id="main-header">
            <div class="container">
                <h1>Student Registration System</h1>
            </div>
        </header>
        <div class="main-block">
            <h3>Select Courses that you want to learn</h3>

            <table class="my-table" >
                <thead>
                    <tr>
                        <th>Code</th>
                        <th>Names</th>
                        <th>Credits</th>
                        <th>Course Fee</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>

                    <%
                        GenericDao<Courses> cdao = new GenericDao<>(Courses.class);
                        List<Courses> list = cdao.findAll();
                        for (Courses c : list) {
                    %>

                    <tr>
                        <td><%= c.getC_code()%></td>
                        <td><%= c.getC_name()%></td>
                        <td><%= c.getC_credits()%></td>
                        <td><%= c.getC_fees()%></td>

                     <td><a href="AddCourse.jsp?code=<%=c.getC_code()%>">Add </a> <a href="RemoveCourse.jsp?code=<%=c.getC_code()%>">| Remove</a></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>

        <div class="block">
            <h3>Your Current Selection</h3>
            <table class="sel-table">
                <tr>
                    <td>Number of Courses:</td>
                    <td><%= csInfo.countCourses()%></td>
                </tr>
                <tr>
                    <td>Total Credits:</td>
                    <td><%=csInfo.calculateCredits()%></td>
                </tr>
                <tr>
                    <td>Total Fee:</td>
                    <td><%=csInfo.totalFees()%></td>
                </tr>
            </table>
            <div class="clr"></div>
            <div class="pos-link">
                <a class="my-links" href="SelectedCourses.jsp">View Details</a>
                <div class="clr"></div>
                <a class="my-links" href="RegistrationSummary.jsp">Complete Registration</a>
            </div>
        </div>   
    </body>
</html>
