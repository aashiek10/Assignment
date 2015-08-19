/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import utills.UserContact;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cb-aashiek
 */
public class EditContacts extends HttpServlet {

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
            out.println("<title>Servlet EditContacts</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditContacts at " + request.getContextPath() + "</h1>");
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

            if (request.getSession().getAttribute("userId") == null) {
                response.sendRedirect("login.jsp");
            }

            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/user_info", "root", "");
            if (!request.getParameter("idedit").equalsIgnoreCase("") && request.getParameter("idedit") != null) {
                String filter = "SELECT * FROM phone_book WHERE id = '" + request.getParameter("idedit") + "'";
                PreparedStatement statement = connection.prepareStatement(filter);
                ResultSet result = statement.executeQuery();

                ArrayList<UserContact> list = new ArrayList();
                String[] names = {"mobile", "home", "work"};

                while (result.next()) {
                    int id = result.getInt("id");
                    UserContact bc = new UserContact();

                    bc.setId(result.getString(1));
                    bc.setName(result.getString("name"));
                    bc.setAddress(result.getString("address"));

                    Statement statement2 = connection.createStatement();
                    for (String s : names) {
                        String tempo = "SELECT number FROM " + s + "_number WHERE id = '" + id + "'";
                        ResultSet result2 = statement2.executeQuery(tempo);
                        String num = "";
                        while (result2.next()) {
                            num = num + result2.getInt("number") + "  ";
                        }
                        switch (s) {
                            case "mobile":
                                bc.setMobileNumber(num);
                                break;
                            case "home":
                                bc.setHomeNumber(num);
                                break;
                            case "work":
                                bc.setWorkNmber(num);
                                break;
                        }
                    }
                    list.add(bc);
                }

                request.setAttribute("BCObjectList", list);
                request.getRequestDispatcher("editContacts2.jsp").forward(request, response);

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
