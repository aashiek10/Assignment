/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cb-aashiek
 */
public class AddContacts extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddContacts</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddContacts at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/user_info", "root", "");

            if (request.getSession().getAttribute("userId")==null) { 
              response.sendRedirect("login.jsp"); 
              }
            
          String tempo = "UPDATE phone_book SET name=?, address=? WHERE id=? ";
            PreparedStatement statement=connection.prepareStatement(tempo);
            String address = request.getParameter("address") + " " + request.getParameter("address2") + " " + request.getParameter("state") + " " + request.getParameter("country");
            statement.setString(1, request.getParameter("name"));
            statement.setString(2, address);
            statement.setString(3, request.getParameter("id3"));         
            statement.executeUpdate();
            
            
            String deletequery = "DELETE FROM mobile_number WHERE id = ?";
            statement=connection.prepareStatement(deletequery);
            statement.setString(1, request.getParameter("id3"));
            statement.executeUpdate();
            
            String s = request.getParameter("mobilenum");
            if (s != null) {
            for (String retval : s.split(",")) {
            String tempo2 = "INSERT INTO mobile_number (id, number) VALUES (?,?)";
            statement=connection.prepareStatement(tempo2);
            statement.setString(1, request.getParameter("id3"));
            statement.setString(2, retval);
            statement.executeUpdate();
            }}
            
            deletequery = "DELETE FROM work_number WHERE id = ?";
            statement=connection.prepareStatement(deletequery);
            statement.setString(1, request.getParameter("id3"));
            statement.executeUpdate();
            
            s = request.getParameter("worknum");
            if (s != null) {
            for (String retval : s.split(",")) {
            String tempo2 = "INSERT INTO work_number (id, number) VALUES (?,?)";
            statement=connection.prepareStatement(tempo2);
            statement.setString(1, request.getParameter("id3"));
            statement.setString(2, retval);
            statement.executeUpdate();
            }}
            
            deletequery = "DELETE FROM home_number WHERE id = ?";
            statement=connection.prepareStatement(deletequery);
            statement.setString(1, request.getParameter("id3"));
            statement.executeUpdate();
            
            s = request.getParameter("homenum");
            if (s != null) {
            for (String retval : s.split(",")) {
            String tempo2 = "INSERT INTO home_number (id, number) VALUES (?,?)";
            statement=connection.prepareStatement(tempo2);
            statement.setString(1, request.getParameter("id3"));
            statement.setString(2, retval);
            statement.executeUpdate();
            }}
            
            
            response.sendRedirect("FetchDetails");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
