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
    <link rel="stylesheet" type="text/css" href="designs.css" media="screen" />
    </head>
    
    <body>
    <center>   
        <div style="
                     height: 375px;
                     width: 300px;
                     position: absolute;
                     top:125px;
                     margin: 0 auto;
                     left:415px;">
        <% 
        if (request.getSession().getAttribute("userId")==null) { 
              response.sendRedirect("login.jsp"); %>
              <h1>Please Login!</h1>
              <%}
        %>
               
        <form method="get" action="DisplayDetails">
            <button class="btn" type="submit">Details</button>
        </form>
        
        <form method="get" action="deactivate">
            <button class="btn" type="submit">Deactivate</button>
        </form>
<br><br>
        <form method="get" action="FetchDetails">
           <button class="btn" type="submit">Contacts</button>
        </form>

        <form method="get" action="logout">
            <button class="btn" type="logout">Logout</button>
        </form>
       
      <!--  <a href="updateDetails.jsp">Edit Details</a>
        <a href="deactivate">Deactivate Account</a>
        <a href="logout">Logout</a>    -->
    </div>
    </center>
    </body>
</html>
