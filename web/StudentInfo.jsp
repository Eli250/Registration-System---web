<%-- 
    Document   : StudentInfo
    Created on : Feb 15, 2021, 8:43:11 AM
    Author     : Eli
--%>

<%@page import="edu.eli.model.StudentModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="css/styles.css" rel="stylesheet" >
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Info</title>
    </head>

    <body>
        <header id="main-header">
            <div class="container">
                <h1>Student Registration System</h1>
            </div>
        </header>
        <div class="">
            <%
                StudentModel stdData = (StudentModel) session.getAttribute("stdModel");
                if (stdData == null) {
                    stdData = new StudentModel();
                    session.setAttribute("stdModel", stdData);
                }
            %>

            <h2 id="sum-h1">Student Information Form</h2>
            <form class ="submission-form" action ="processInfo" method="POST">

                <label for="student-id"> 
                    Student ID: 
                </label>
                <input id="student-id" type="text" name="sid" value="<%= stdData.getsIdInput()%>">
                <label id="error"><%=stdData.getIdMsg()%></label>

                <label for="name">
                    Names: 
                </label>
                <input id="name" type="text" name="snames" value="<%= stdData.getsNameInput()%>">
                <label id="error"><%=stdData.getNameMsg()%></label>

                <label for="gender">
                    Gender:
                </label>
                <input type="text" name="sgender" value="<%=stdData.getGenderInput()%>">
                <label id="error"><%=stdData.getGenderMsg()%></label>
                <label for="dob">
                    Date of Birth: 
                </label>
                <input id="dob" type="text" name="sdob" placeholder="dd/MM/yyy" value="<%=stdData.getDobInput()%>">
                <label id="error"><%=stdData.getDateMessage()%></label>
                <input id="submitBtn" type="submit" value="Next">
            </form>
        </div>
    </body>
</html>
