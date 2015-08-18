<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Filter Contacts</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    
    
    <body>
                
            <div>
                <form method="post" action="FilterContacts">
                 <table style="width:55%">
                <tr>
                    <td><label>Name:</label></td>
                    <td><input type="text" readonly="true" id="name" name="name" value=""/></td>
                    <td><button type="submit" disabled="true" id="confirmn">Confirm</button></td>
                </tr>
                <tr>
                    <td><label>Phone:</label></td>
                    <td><input type="text" readonly="true" id="phone" name="phone" value=""/></td>
                    <td><button type="submit" disabled="true" id="confirmp">Confirm</button></td>
                </tr>
                 </table> 
                </form>
                
                </div>      
<button onclick ="redirect()" id="cancel">Cancel</button>
                <button onclick="enableName()">Name</button>
                <button onclick="enablePhone()">Phone</button>
                <script>
             function enableName() {   
             document.getElementById("name").removeAttribute("readonly"); 
             document.getElementById("confirmn").removeAttribute("disabled");
         }
         
             function enablePhone() {   
             document.getElementById("phone").removeAttribute("readonly"); 
             document.getElementById("confirmp").removeAttribute("disabled");
         }
        
    function redirect() {
          window.location.href = "filterContacts.jsp";   
         }

                </script>


                <form method="get" action="logout">
                    <button type="logout">Logout</button>
        </form>

        <div></div>
    </body>
</html>
