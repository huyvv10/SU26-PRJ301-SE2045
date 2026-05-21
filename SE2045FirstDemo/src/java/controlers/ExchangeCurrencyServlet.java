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
public class ExchangeCurrencyServlet extends HttpServlet {

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
        String amount = request.getParameter("amount");
        String method = request.getParameter("method");
        String moneytype = request.getParameter("moneytype");
        String rs = "";
        boolean flag = false;
        if (amount.isEmpty()) {
            rs += "Please input amount of moneys";
        } else {
            flag = true;
            try {
                double m = Double.parseDouble(amount);
                switch (method) {
                    case "buy":
                        if (moneytype.equals("usd")) {
                            rs += m*26391;            
                        } else
                            rs+=m*31448.04;
                        break;
                    case "sell":
                        if (moneytype.equals("eur")) {
                            rs += m*26131;            
                        } else
                            rs+=m*29873.24;
                        break;                        
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ExchangeCurrencyServlet</title>");
            out.println("</head>");
            out.println("<body>");
            if (flag)
                out.println("<h1>"+amount +" "+ moneytype+ " to VND is "+ rs + "</h1>");
            else
                out.println("<h1>"+rs+"</h1>");
            
            out.println("</body>");
            out.println("</html>");
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
//        processRequest(request, response);
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
