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
       while(rs.next()) { %>
            <div>
                <form method="post" action="UpdateDetails">
                 <table style="width:55%">
                <tr>  
                    <td><label>ID:</label></td>
                    <td><input type="text" readonly="" id="id" name="id" value="<%=rs.getString("id")%>"/></td>
                </tr>
                <tr>
                    <td><label>First Name:</label></td>
                    <td><input type="text" readonly="true" id="fname" name="fname" value="<%=rs.getString("first_name")%>"/></td>
                </tr>
                <tr>
                    <td><label>Last Name:</label></td>
                    <td><input type="text" readonly="true" id="lname" name="lname" value="<%=rs.getString("last_name")%>"/></td>
                </tr>
                <tr>
                    <td><label>E-mail:</label></td>
                    <td><input type="text" readonly="" id="email" name="email" value="<%=rs.getString("e_mail")%>"/></td>
                </tr>
                <tr>
                    <td><label>Address:</label></td>
                    <td><input type="text" readonly="true" id="address" name="address" size="50" value="<%=rs.getString("address")%>"/></td>
                </tr>
                 </table> 
                <button type="submit" disabled="true" id="apply">Apply</button>
                </form>
                <button onclick ="redirect()" disabled="true" id="cancel">Cancel</button>
                </div>
                <%}%>
                
      

                <button onclick="enableEdit()">Edit</button>
                <script>
             function enableEdit() {
                 
             document.getElementById("fname").removeAttribute("readonly"); 
             document.getElementById("lname").removeAttribute("readonly");
             document.getElementById("address").removeAttribute("readonly");
             document.getElementById("apply").removeAttribute("disabled");
             document.getElementById("cancel").removeAttribute("disabled");
         }
         function redirect() {
          window.location.href = "DisplayDetails";   
         }

                </script>


                <form method="get" action="logout">
                    <button type="logout">Logout</button>
        </form>
        
        <div></div>
    </body>
</html>
