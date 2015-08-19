<%@page import="java.util.List"%>
<%@page import="utills.UserContact"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Edit Contacts</title>
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
        
              <%
       List<Object> list = (ArrayList) request.getAttribute("BCObjectList");   
       for(Object b1 : list) {  UserContact bc=(UserContact)b1; %>
            <div>
                <form method="post" action="AddContacts">
                 <center>
                    <div style="
                     height: 375px;
                     width: 300px;
                     position: absolute;
                     top:125px;
                     margin: 0 auto;
                     left:415px;">
                        
                    <table style="width:55%">
                        <tr>
                            <td><input hidden="true" type="text" class="signupField" id="id3" name="id3" value="<%=bc.getId()%>"/></td>
                        </tr>
                        <tr>
                    <td><label>Name:</label></td>
                    <td><input type="text" class="signupField" id="name" name="name" value="<%=bc.getName()%>"/></td>
                
                    <td><label></label></td>
                    <td></td>
                </tr>
                <tr>
                    <td><label>Address:</label></td>
                    <td><input type="text" class="signupField" id="address" name="address" value="<%=bc.getAddress()%>"/></td>
                
                    <td><label></label></td>
                    <td><input type="text" class="signupField" id="address2" name="address2" value="Address Line 2" onfocus="if (this.value==='Address Line 2') this.value='';"/></td>                
                    </tr>
                    
                    <tr>
                        <td><label>State & Country:</label></td>
                        <td><select class="signupField" id="state" name="state">
                 <option value=""></option>
                                <option value="Tamil Nadu">Tamil Nadu</option> 
                 <option value="California">California</option></td>
                    <td><label></label></td>
                    <td><select class="signupField" id="country" name="country">
                 <option value=""></option>
                            <option value="India">India</option> 
                 <option value="USA">USA</option></td>
                    </tr><tr>
                    <td><label>Home Number:</label></td>
                    <td><input type="text" id="homenum" name="homenum" value="<%=bc.getHomeNumber()%>"/></td>
                </tr><tr>
                    <td><label>Work Number:</label></td>
                    <td><input type="text" id="worknum" name="worknum" value="<%=bc.getWorkNmber()%>"/></td>
                </tr><tr>
                    <td><label>Mobile Number:</label></td>
                    <td><input type="text" id="mobilenum" name="mobilenum" value="<%=bc.getMobileNumber()%>"/></td>
                </tr>
                  
                <td><button type="submit" name="appychng" id="appychng">Apply</button></td>
                <%}%>
                </table>
                 </center>
                </div>
                <input type="button" onclick="redirect()" value="Discard"/>
               
                <script>
                  
         function redirect() {             
          window.location.href = "FetchDetails";   
         }
                </script>

                </form>
            </div>
            <div></div>
    </body>
</html>
