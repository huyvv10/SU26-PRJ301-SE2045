/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controllers;

import dal.CategoryDAO;
import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import javax.naming.InitialContext;
import models.Category;
import models.Product;

/**
 *
 * @author VU VAN HUY
 */
public class DisplayAllProductServlet extends HttpServlet {
    protected int size=7;
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
            out.println("<title>Servlet DisplayAllProductServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DisplayAllProductServlet at " + request.getContextPath () + "</h1>");
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
        try {
            CategoryDAO catDao = new CategoryDAO();
            List<Category> catList = new ArrayList<>();
            catList = catDao.getAllCategories();
            request.setAttribute("catList", catList);

            String numPerPage = getServletContext().getInitParameter("prdPerPage");
            size = Integer.parseInt(numPerPage);
            
            ProductDAO prdDao = new ProductDAO();
            List<Product> prdList = new ArrayList<>();
            prdList = prdDao.getAllProducts();
            
            int totalProduct = prdList.size();
            int totalPages = totalProduct%size ==0 ? totalProduct/size : totalProduct/size +1;
            request.setAttribute("numPerPage", numPerPage);
            request.setAttribute("totalPages", totalPages);
            
            String strPage = request.getParameter("page");
            int page=1;
            if (strPage==null)
                page=1;
            else
                page=Integer.parseInt(strPage);
            prdList = prdDao.pagingProducts(page, size);
            request.setAttribute("prdList", prdList);
            
            request.getRequestDispatcher("displayproducts.jsp")
                    .forward(request, response);
        } catch (Exception e) {
            System.out.println(e);
        }        
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
        try {
            CategoryDAO catDao = new CategoryDAO();
            List<Category> catList = new ArrayList<>();
            catList = catDao.getAllCategories();
            request.setAttribute("catList", catList);
            
            String strKwName = request.getParameter("txtKw");
            String strCatId = request.getParameter("cboCat");

            ProductDAO prdDao = new ProductDAO();
            List<Product> prdList = new ArrayList<>();
            prdList = prdDao.searchProductByName(strKwName, strCatId);            
            request.setAttribute("prdList", prdList);
                       
            request.getRequestDispatcher("displayproducts.jsp")
                    .forward(request, response);
            
        } catch (Exception e) {
            System.out.println(e);
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
