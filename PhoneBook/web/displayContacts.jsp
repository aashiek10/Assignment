<%@page import="utills.UserContact"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>contacts</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
         <link rel="stylesheet" type="text/css" href="designs.css" media="screen" />
    </head>
    
    
    <body>
         <% 
        if (request.getSession().getAttribute("userId")==null) { 
              response.sendRedirect("login.jsp"); %>
              <h1>Please Login!</h1>
        <%}
        %>
        <form>
            <table class="tfTable" style="width:50%">
                <tr>  
                    <td><label></label></td>
                    <td><%="ID"%></td>
                    
                    <td><label></label></td>
                    <td><%="Name"%></td>
                
                    <td><label></label></td>
                    <td><%="Address"%></td>
                
                    <td><label></label></td>
                    <td><%="Home Number"%></td>
                
                    <td><label></label></td>
                    <td><%="Work Number"%></td>
                
                    <td><label></label></td>
                    <td><%="Mobile Number"%></td>
                </tr>
                  
              <%
       List<Object> list = (ArrayList) request.getAttribute("BCObjectList");   
       for(Object b1 : list) {  UserContact bc=(UserContact)b1; %>
            <div>
                                <tr>  
                    <td><label></label></td>
                    <td><%=bc.getId()%></td>
                    
                    <td><label></label></td>
                    <td><input class="signupField" type="text" readonly id="name" name="name" value="<%=bc.getName()%>"/></td>
                
                    <td><label></label></td>
                    <td><input class="signupField" type="text" readonly id="address" name="address" value="<%=bc.getAddress()%>"/></td>
                
                    <td><label></label></td>
                    <td><input class="signupField" type="text" readonly id="homenum" name="homenum" value="<%=bc.getHomeNumber()%>"/></td>
                
                    <td><label></label></td>
                    <td><input class="signupField" type="text" readonly id="worknum" name="worknum" value="<%=bc.getWorkNmber()%>"/></td>
                
                    <td><label></label></td>
                    <td><input class="signupField" type="text" readonly id="mobilenum" name="mobilenum" value="<%=bc.getMobileNumber()%>"/></td>
                </tr>
                  
                
              <%}%>
                </table>
                <input class="btn" type="button" onclick="redirect1()" value="Edit Contact"/>
                <button class="btn" onclick="return redirect2()">Filter Contact</button>
               
                <script>
                  function redirect1() {
                      window.location.href = "editContacts.jsp";
             
         }
         function redirect2() {             
          window.location.href = "filterContacts.jsp"; 
          return false;
         }
                </script>

                </form>
            </div>
            <div></div>
    </body>
</html>

