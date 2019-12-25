/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mvc.model.ObjectsIO.HR_IO;

/**
 *
 * @author Kareem E.Farouk
 */
@WebServlet(name = "doSearch", urlPatterns = {"/doSearch"})
public class doSearch extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String url = request.getParameter("X");
            Vector v = new Vector();
            if(url.equals("Home")){
                response.sendRedirect("searching.jsp");
            }
            else if(url.equals("Searching")){
                HR_IO hrio = new HR_IO();
                String choice = (String) request.getParameter("Checked");
                String key = (String) request.getParameter("key");
                Vector results = new Vector();
                if(choice.equals("cName")){
                    out.print("Name");
                    v = hrio.getCbyName(key);
                }
                else if(choice.equals("cEmail")){
                    out.print("em");
                    v = hrio.getCbyEmail(key);
                }
                else if(choice.equals("TTYPE")){
                    if((key.equals("Python")) || (key.equals("python"))){
                        v = hrio.getE_Python(key);
                    }
                    else if((key.equals("Java")) || (key.equals("java"))){
                        v = hrio.getE_Java(key);
                    }
                     else if((key.equals("Database")) || (key.equals("database"))){
                         v = hrio.getE_Database(key);
                     }
                    else if((key.equals("IQ")) || (key.equals("iq")) || (key.equals("Iq"))){
                        v = hrio.getE_Iq(key);
                    }
                    else if((key.equals("English")) || (key.equals("english"))){
                         v = hrio.getE_English(key);
                    }
                }
                else if(choice.equals("e_Date")){
                    out.print("Date");
                    v = hrio.getEbyDate(key);
                }
                HttpSession se = request.getSession();
                se.setAttribute("result", v);
                request.getRequestDispatcher("/searchResult.jsp").forward(request, response);
            }
            else
               response.sendRedirect("HR_Home.jsp");
            
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
    }
}