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
public class FilterContacts extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FilterContacts</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FilterContacts at " + request.getContextPath() + "</h1>");
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

            if (request.getSession().getAttribute("userId") == null) {
                response.sendRedirect("login.jsp");
            }

            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/user_info", "root", "");
            if (!request.getParameter("name").equalsIgnoreCase("") && request.getParameter("name") != null) {
                String filter = "SELECT * FROM phone_book WHERE name LIKE '%"+ request.getParameter("name") +"%'";
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
                request.getRequestDispatcher("displayContacts.jsp").forward(request, response);

            } else {
                String tempo2 = "SELECT m.id, m.number FROM mobile_number AS m INNER JOIN home_number AS h ON m.id = h.id "
                        + "INNER JOIN work_number AS w ON w.id = m.id "
                        + "WHERE m.number = '" + request.getParameter("phone") + "' OR w.number = '" + request.getParameter("phone") + "' "
                        + "OR h.number = '" + request.getParameter("phone") + "'";
                Statement statement2 = connection.createStatement();
                ResultSet res = statement2.executeQuery(tempo2);
                res.next();
                int id = res.getInt("id");

                String tempo = "SELECT * FROM phone_book WHERE id = '" + Integer.toString(id) +"'";
                PreparedStatement statement = connection.prepareStatement(tempo);

                ResultSet result = statement.executeQuery();

                ArrayList<UserContact> list = new ArrayList();
                String[] names = {"mobile", "home", "work"};

                while (result.next()) {
                    UserContact bc = new UserContact();

                    bc.setId(result.getString(1));
                    bc.setName(result.getString("name"));
                    bc.setAddress(result.getString("address"));

                    Statement statement3 = connection.createStatement();
                    for (String s : names) {
                        String tempo3 = "SELECT number FROM " + s + "_number WHERE id = '" + id + "'";
                        ResultSet result2 = statement3.executeQuery(tempo3);
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
                request.getRequestDispatcher("displayContacts.jsp").forward(request, response);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        // request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
