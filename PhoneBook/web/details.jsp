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
        <link rel="stylesheet" type="text/css" href="designs.css" media="screen" />
    </head>
    <body>
        
        
        <%
       ResultSet rs=(ResultSet) request.getAttribute("resultObject");
       while(rs.next()) { %>
            <div>
                <form method="post" action="UpdateDetails">
                    <center>
                        <div style="
                     height: 375px;
                     width: 300px;
                     position: absolute;
                     top:125px;
                     margin: 0 auto;
                     left:415px;"> 
                 <table style="width:40%">
                     <h4>Details</h4>
                <tr>  
                    <td><label></label></td>
                    <td><input type="text" hidden="true" class="signupField" readonly="" id="id" name="id" value="<%=rs.getString("id")%>"/></td>
                </tr>
                <tr>
                    <td><label>Name:</label></td>
                    <td><input type="text" class="signupField" readonly="true" id="fname" name="fname" value="<%=rs.getString("first_name")%>"/></td>
                
                    <td><label></label></td>
                    <td><input type="text" class="signupField" readonly="true" id="lname" name="lname" value="<%=rs.getString("last_name")%>"/></td>
                </tr>
                <tr>
                    <td><label>E-mail:</label></td>
                    <td><input type="text" class="signupField" readonly="" id="email" name="email" value="<%=rs.getString("e_mail")%>"/></td>
                </tr>
                <tr>
                    <td><label>Address:</label></td>
                    <td><input type="text" class="signupField" readonly="true" id="address" name="address" value="<%=rs.getString("address")%>"/></td>
                
                    <td><label></label></td>
                    <td><input type="text" class="signupField" readonly="true" id="address2" name="address2" value="Address Line 2" onfocus="if (this.value==='Address Line 2') this.value='';"/></td>                
                    </tr>
                    
                    <tr>
                        <td><label></label></td>
                        <td><select class="signupField" id="state" name="state">
                 <option value=""></option>
                                <option value="Tamil Nadu">Tamil Nadu</option> 
                 <option value="California">California</option></td>
                    <td><label></label></td>
                    <td><select class="signupField" id="country" name="country">
                 <option value=""></option>
                            <option value="India">India</option> 
                 <option value="USA">USA</option></td>
                    </tr>
                    <tr>
                    <td><label></label></td>
                    <td><button type="submit" class="btn" disabled="true" id="apply">Apply</button></td>
                
                    <td><label></label></td>
                    <td><button onclick ="redirect()" class="btn" disabled="true" id="cancel">Cancel</button></td>                
                    </tr>
                    
                 </table> 
                
                    
                </form>
                
        </div>    
        </center>    
            </div>
                <%}%>
                
      
    <center>
        <div style="
                     height: 375px;
                     width: 300px;
                     position: absolute;
                     top:30px;
                     margin: 0 auto;
                     left:1000px;">
                <button class="btn" onclick="enableEdit()">Edit</button>
                <script>
             function enableEdit() {
                 
             document.getElementById("fname").removeAttribute("readonly"); 
             document.getElementById("lname").removeAttribute("readonly");
             document.getElementById("address").removeAttribute("readonly");
             document.getElementById("address2").removeAttribute("readonly");
             document.getElementById("apply").removeAttribute("disabled");
             document.getElementById("cancel").removeAttribute("disabled");
         }
         function redirect() {
          window.location.href = "DisplayDetails";   
         }

                </script>


                <form method="get" action="logout">
                    <button class="btn" type="logout">Logout</button>
        </form>
                </div>
    </center>
        <div></div>
    </body>
</html>
