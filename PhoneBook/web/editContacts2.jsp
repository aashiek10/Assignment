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
       ArrayList<BeanClass> list = new ArrayList();
       list = (ArrayList) request.getAttribute("BCObjectList");
       BeanClass b = new BeanClass();
       for(BeanClass bc : list) { %>
            <div>
                <form method="post" action="FilterContacts">
                 <table style="width:55%">
                <tr>  
                    <td><label>Name:</label></td>
                    <td><input type="text" id="name" name="name" value="<%=bc.getName()%>"/></td>
                </tr><tr>
                    <td><label>Address:</label></td>
                    <td><input type="text" id="address" name="address" size="50" value="<%=bc.getAddress()%>"/></td>
                </tr><tr>
                 <select name="countries">
                 <option value="India">India</option> 
                 <option value="Pakistan">Pakistan</option>
                 </select>
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
                
                <button onclick="redirect()">Discard</button>
               
                <script>
                  
         function redirect() {             
          window.location.href = "displayContacts.jsp";   
         }
                </script>

                </form>
            </div>
            <div></div>
    </body>
</html>
