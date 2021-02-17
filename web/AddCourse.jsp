<%-- 
    Document   : AddCourse
    Created on : Feb 15, 2021, 9:35:36 PM
    Author     : Eli
--%>
<%@page import="java.util.List"%>
<%@page import="edu.eli.model.Courses"%>
<%@page import="edu.eli.controller.CourseInfo"%>
<%@page import="edu.eli.dao.GenericDao"%>
<%
    String c_code = request.getParameter("code");
    GenericDao<Courses> cdao = new GenericDao<>(Courses.class);
    Courses c = cdao.findById(c_code);
    CourseInfo csInfo = (CourseInfo)session.getAttribute("CourseSelected");
            if(csInfo==null){
                csInfo= new CourseInfo();
                session.setAttribute("CourseSelected", csInfo);
            }
    
   //Checking for duplicates
   CourseInfo checkDup = (CourseInfo)session.getAttribute("CourseSelected");
    
    List<Courses> selectedC = checkDup.getCourseList();
    boolean exists = false;
    Courses c1 = new Courses();
    for(Courses cs : selectedC){
        c1 = cs;
        if(c1==c){
            exists=true;
        }
    }
    
    if(!exists){
        csInfo.addCourse(c);
    }
%>
<jsp:forward page="ChooseCourses.jsp"/>
    