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
                    
                <label>ID:</label><input type="text" readonly="" id="id" name="id" value="<%=rs.getString("id")%>"/><br>
                <label>First Name:</label><input type="text" readonly="true" id="fname" name="fname" value="<%=rs.getString("first_name")%>"/><br>
                <label>Last Name:</label><input type="text" readonly="true" id="lname" name="lname" value="<%=rs.getString("last_name")%>"/><br>
                <label>E-mail:</label><input type="text" readonly="" id="email" name="email" value="<%=rs.getString("e_mail")%>"/><br>
                <label>Address:</label><input type="text" readonly="true" id="address" name="address" size="50" value="<%=rs.getString("address")%>"/><br>
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
