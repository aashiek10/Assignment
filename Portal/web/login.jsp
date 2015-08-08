<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>

    <body>
        <% if (request.getAttribute("loginprocess") != null) { %>
        <h1>Login Failed!</h1>
        <%} %>
        
        <% 
        if (request.getSession().getAttribute("userId")!=null) { 
              response.sendRedirect("home.jsp");
        }
        %>

        <form action="loginProcessor" method="post">
            <div>
                <label>E-mail:</label>
                <input type="email" id="mail" name ="email" value="<%=request.getParameter("email")==null?"":request.getParameter("email")%>"/>
            </div>

            <div>
                <label>Password:</label>
                <input type="password" id="password" name="password"/>
            </div>

            <div class="button">
                <button type="submit" >Submit</button>
            </div>
            
        <!--    <a href="Signup.jsp">Signup</a> -->

        </form>
    </body>
</html>
