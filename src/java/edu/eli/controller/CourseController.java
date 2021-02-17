/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eli.controller;

import edu.eli.dao.GenericDao;
import edu.eli.model.Courses;
import edu.eli.model.Gender;
import edu.eli.model.Student;
import edu.eli.model.StudentModel;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

/**
 *
 * @author Eli
 */
@WebServlet(name = "CourseController", urlPatterns = {"/CourseController"})
public class CourseController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

                 
            StudentModel stdData = (StudentModel)request.getSession().getAttribute("stdModel");
            if(stdData==null){
                stdData = new StudentModel();
                request.getSession().setAttribute("stdModel", stdData);
            }
     
            CourseInfo csInfo = (CourseInfo) request.getSession().getAttribute("CourseSelected");
            if (csInfo == null) {
                csInfo = new CourseInfo();
                request.getSession().setAttribute("CourseSelected", csInfo);
            }

            GenericDao<Student> stDao = new GenericDao<>(Student.class);
        try {
            
            Student student = new Student();
            student.setsId(stdData.getsIdInput());
            student.setNames(stdData.getsNameInput());
            student.setGender(Gender.valueOf(stdData.getGenderInput()));
            student.setDateOfBirth(stdData.getDobValue());
            
            List<Courses> coures = csInfo.getCourseList();
            student.setRegisteredCourses(coures);
            
            stDao.create(student);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Feedback.jsp");
            dispatcher.forward(request, response);
        }catch(IOException | ServletException ex){
            RequestDispatcher dispatcher = request.getRequestDispatcher("errorPage.jsp");
            request.setAttribute("errorMessage", ex);
            dispatcher.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
