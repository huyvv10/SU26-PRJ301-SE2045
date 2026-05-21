/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controlers;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author VU VAN HUY
 */
public class ElectricityCostServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String num = request.getParameter("num");
        int S=0;
        try {
            int eNum = Integer.parseInt(num);            
            if (eNum<=50)
                S=eNum*1984;
            else if (eNum<=100)
                S=50*1984 + (eNum-50)*2050;
            else if (eNum<200)
                S=50*1984 + 50*2050 + (eNum-100)*2380;
            else if (eNum<300)
                S=50*1984 + 50*2050 + 100*2380 + (eNum-200)*2998;
            else if (eNum<400)
                S=50*1984 + 50*2050 + 100*2380 + 100*2998 + (eNum-200)*3350;
            else
                S=50*1984 + 50*2050 + 100*2380 + 100*2998 + 100*3350 + (eNum-400)*3460;            
        } catch (Exception e) {
            System.out.println(e);
        }
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ElectricityCostServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>The electricity cost for " + num + " (Kwh): "+ S +"</h1>");
            out.println("<p><h1>VAT 10%: " + S*0.1 +"</h1></p>");
            out.println("<p><h1>The total electricity cost for " + num + " (Kwh): "+ S*1.1 +" (vnd)</h1></p>");
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
        processRequest(request, response);
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
