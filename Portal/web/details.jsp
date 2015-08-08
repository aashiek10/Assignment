<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Details</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        
        
        <%
       ResultSet rs=(ResultSet) request.getAttribute("resultObject");
       /*out.println("ID : " + rs.getString(1));
       out.println("First Name : " + rs.getString("first_name"));
       out.println("Last Name : " + rs.getString("last_name"));
       out.println("Email ID : " + rs.getString("e_mail"));
       out.println("Address : " + rs.getString("address"));
.        */%>
        <h1><%= rs.getString("first_name")%> </h1>
        <form method="post" action="editDetails">
                <button type="submit">Edit</button>
        </form>
        
        <div></div>
    </body>
</html>
