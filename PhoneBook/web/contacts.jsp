<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Contacts</title>
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
        
        
        
        
        <div></div>
    </body>
</html>
