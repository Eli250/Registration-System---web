<%-- 
    Document   : RemoveCourse
    Created on : Feb 15, 2021, 9:35:48 PM
    Author     : Eli
--%>

<%@page import="edu.eli.model.Courses"%>
<%@page import="edu.eli.controller.CourseInfo"%>
<%@page import="edu.eli.dao.GenericDao"%>
<%
    String code = request.getParameter("code");
    GenericDao<Courses> cdao = new GenericDao<>(Courses.class);
    Courses c = cdao.findById(code);
    CourseInfo csInfo = (CourseInfo)session.getAttribute("CourseSelected");
            if(csInfo==null){
                csInfo= new CourseInfo();
                session.setAttribute("CourseSelected", csInfo);
            }
            csInfo.removeCourse(c);
%>
<jsp:forward page="ChooseCourses.jsp"/>