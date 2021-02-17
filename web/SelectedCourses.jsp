<%-- 
    Document   : SelectedCourses
    Created on : Feb 15, 2021, 9:07:30 PM
    Author     : Eli
--%>
<link href="css/styles.css" rel="stylesheet">
<%@page import="edu.eli.controller.CourseInfo"%>
<%@page import="edu.eli.model.Courses"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Selected Courses</title>
    </head>
    <body>
        <h1>Details of Selected Courses</h1>
        <%
            CourseInfo csInfo = (CourseInfo) session.getAttribute("CourseSelected");
            if (csInfo == null) {
                csInfo = new CourseInfo();
                session.setAttribute("CourseSelected", csInfo);
            }
        %>
        <table class ="my-table"  border="1">
            <thead>
                <tr>
                    <th>Code</th>
                    <th>Names</th>
                    <th>Credits</th>
                    <th>Course Fee</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Courses> list = csInfo.getCourseList();
                    for (Courses c : list) {
                %>

                <tr>
                    <td><%= c.getC_code()%></td>
                    <td><%= c.getC_name()%></td>
                    <td><%= c.getC_credits()%></td>
                    <td><%= c.getC_fees()%></td>

                </tr>
                <%}%>
            <td>Total </td>
            <td></td>
            <td><%= csInfo.calculateCredits() %></td>
            <td><%= csInfo.totalFees()%></td>
        </tbody>
    </table>
        
   
        <a class="my-links" href="RegistrationSummary.jsp">Complete Registration</a>
       
        <a class="my-links go-back" href="ChooseCourses.jsp">Go Back</a>
   
</body>
</html>
