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
        <link rel="stylesheet" type="text/css" href="designs.css" media="screen" />
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
            <center>
                <div class="boxed" style="
                     height: 375px;
                     width: 300px;
                     position: absolute;
                     top:125px;
                     margin: 0 auto;
                     left:415px;">
                    
            <table style="width:8%">
                <h2>'The' Portal</h2>
                 <h5>Login</h5>

                <tr>
                <div>
                    <td><label></label></td>
                    <td><input type="email" id="mail" name ="email" class="fields" value="<%=request.getParameter("email")==null?"Username":request.getParameter("email")%>"/></td>
            </div>
</tr>
<tr>
            <div>
                <td><label></label></td>
                <td><input type="password" id="password" class="fields" name="password" value="password"/></td>
            </div>
</tr> 

            <div class="button">
                <td><label></label></td>
                <td height="100"><button class="btn" type="submit" >LOGIN</button></td>
            </div>
<tr>
<div class="button">
                <td><label></label></td>
                <td><button type="submit" onclick ="redirect()" style="width: 135px;
  height: 65px;
  width: 280px;
  color: #fff;
  text-shadow: none;
  background-color: #6666FF;
  box-shadow: inset 0 0 0 1px #27496d;
  border: none;
  border-radius: 3px;">New around here?</button></td>
            </div>
</tr>
            </table>
        <!--    <a href="Signup.jsp">Signup</a> -->
            </div>
            </center>
        </form>
            <script>
         function redirect() {
          window.location.href = "signup.jsp";   
         }

                </script>

    </body>
</html>
