/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eli.controller;

import edu.eli.model.StudentModel;
import java.io.IOException;
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
@WebServlet("/processInfo")
public class StudentController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            StudentModel stdData = (StudentModel) request.getSession().getAttribute("stdModel");
            if (stdData == null) {
                stdData = new StudentModel();
                request.getSession().setAttribute("stdModel", stdData);
            }
            stdData.applyRequestValue(request);

            if (stdData.convertValues()) {
                RequestDispatcher stdInfo = request.getRequestDispatcher("StudentInfo.jsp");
                stdInfo.forward(request, response);
                request.getSession().invalidate();
            }
            if (stdData.validateValues()) {
                RequestDispatcher stdInfo = request.getRequestDispatcher("StudentInfo.jsp");
                stdInfo.forward(request, response);
                //new codes
                request.getSession().invalidate();
            }
            RequestDispatcher stdInfo = request.getRequestDispatcher("ChooseCourses.jsp");
            stdInfo.forward(request, response);
        } catch (IOException | ServletException e) {

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
