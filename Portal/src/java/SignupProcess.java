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
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cb-aashiek
 */
public class SignupProcess extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SignupProcess</title>");            
            out.println("<title>Servlet SignupProcess</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SignupProcess at " + request.getContextPath() + "</h1>");
            out.println("<h1>Servlet SignupProcess at " + request.getParameter("first_name") + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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

            String s = "SELECT * FROM details WHERE e_mail = ?";
            PreparedStatement stmnt=connection.prepareStatement(s);
            stmnt.setString(1, request.getParameter("email"));
            ResultSet result = stmnt.executeQuery();
            if(result.next()){
                request.setAttribute("signupprocess", "fail");
                request.getRequestDispatcher("signup.jsp").forward(request, response);
            }
            else {
            String tempo = " INSERT INTO details (first_name, last_name, e_mail, password) VALUES (?,?,?,SHA(?))";
            PreparedStatement statement=connection.prepareStatement(tempo);
            statement.setString(1, request.getParameter("first_name"));
            statement.setString(2, request.getParameter("last_name"));
            statement.setString(3, request.getParameter("email"));
            statement.setString(4, request.getParameter("password"));         
            statement.executeUpdate();
            
            response.sendRedirect("login.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
