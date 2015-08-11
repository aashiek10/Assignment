<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Home</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    
    <body>
        
        <% 
        if (request.getSession().getAttribute("userId")==null) { 
              response.sendRedirect("login.jsp"); %>
              <h1>Please Login!</h1>
              <%}
        %>
        
        <form method="get" action="DisplayDetails">
            <button type="submit">Details</button>
        </form>
        
        <form method="get" action="deactivate">
            <button type="submit">Deactivate Account</button>
        </form>
        
        <form method="get" action="logout">
            <button type="logout">Logout</button>
        </form>
        
      <!--  <a href="updateDetails.jsp">Edit Details</a>
        <a href="deactivate">Deactivate Account</a>
        <a href="logout">Logout</a>    -->
    </body>
</html>
