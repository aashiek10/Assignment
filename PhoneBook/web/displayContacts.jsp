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
    </head>
    
    
    <body>
         <% 
        if (request.getSession().getAttribute("userId")==null) { 
              response.sendRedirect("login.jsp"); %>
              <h1>Please Login!</h1>
              <%}
        %>
        
              <%
       ArrayList<BeanClass> list = new ArrayList();
       list = (ArrayList) request.getAttribute("BCObjectList");
       BeanClass b = new BeanClass();
       for(BeanClass bc : list) { %>
            <div>
                <form>
                 <table style="width:55%">
                <tr>  
                    <td><label>ID:</label></td>
                    <td><input type="text" readonly="" id="id" name="id" value="<%=bc.getId()%>"/></td>
                    
                    <td><label>Name:</label></td>
                    <td><input type="text" readonly id="name" name="name" value="<%=bc.getName()%>"/></td>
                
                    <td><label>Address:</label></td>
                    <td><input type="text" readonly id="address" name="address" size="50" value="<%=bc.getAddress()%>"/></td>
                
                    <td><label>Home Number:</label></td>
                    <td><input type="text" readonly id="homenum" name="homenum" value="<%=bc.getHomeNumber()%>"/></td>
                
                    <td><label>Work Number:</label></td>
                    <td><input type="text" readonly id="worknum" name="worknum" value="<%=bc.getWorkNmber()%>"/></td>
                
                    <td><label>Mobile Number:</label></td>
                    <td><input type="text" readonly id="mobilenum" name="mobilenum" value="<%=bc.getMobileNumber()%>"/></td>
                </tr>
                  
                
                <%}%>
                </table>
                <button onclick="redirect1()">Edit Contact</button>
                <button onclick="redirect2()">Filter Contact</button>
               
                <script>
                  function redirect1() {
          window.location.href = "editContacts.jsp";   
         }
         function redirect2() {             
          window.location.href = "filterContacts.jsp";   
         }
                </script>

                </form>
            </div>
            <div></div>
    </body>
</html>

