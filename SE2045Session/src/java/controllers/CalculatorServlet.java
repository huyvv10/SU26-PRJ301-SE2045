/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import model.data;

/**
 *
 * @author VU VAN HUY
 */
public class CalculatorServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CalculatorServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CalculatorServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
//        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String strNum1 = request.getParameter("txtNum1");
        String strNum2 = request.getParameter("txtNum2");
        String strOp = request.getParameter("op");
        String err="";
        double n1, n2, rs=0.0;
        if (strNum1!=null && !strNum1.isEmpty() && strNum2!=null && !strNum2.isEmpty()){
            try {
                n1 = Double.parseDouble(strNum1);
                n2 = Double.parseDouble(strNum2);
                switch (strOp){
                    case "+":
                        rs = n1+n2; break;
                    case "-":
                        rs = n1-n2; break;
                    case "*":
                        rs = n1*n2; break;
                    case "/":
                        if (n2!=0)
                            rs = n1/n2; 
                        else{
                            rs=0;
                            err+="Number 2 must not be zero.";
                        }
                        break;
                }
                //Create a session
                HttpSession session = request.getSession();
                
                //Create a list to store all data
                List<data> lstData;
                if (session.getAttribute("lstData")==null){
                    lstData = new ArrayList<>();
                } else {
                    lstData = (List<data>)session.getAttribute("lstData");
                }                
                
                data x = new data(n1, n2, strOp, rs);
                lstData.add(x);
                //Set or store list to session with the name as lstData
                session.setAttribute("lstData", lstData);
                request.getRequestDispatcher("calculator.jsp")
                        .forward(request, response);
                
            } catch (NumberFormatException e) {
                err+="Number must be digits";
            }
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
