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
        <link rel="stylesheet" type="text/css" href="designs.css" media="screen" />
    </head>
    
    
    <body>
            <center>   
        <div style="
                     height: 375px;
                     width: 300px;
                     position: absolute;
                     top:125px;
                     margin: 0 auto;
                     left:415px;">    
            <div>
                <form method="post" action="FilterContacts">
                 <table style="width:55%">
                <tr>
                    <td><label>Name:</label></td>
                    <td><input class="signupField" type="text" id="name" name="name" value=""/></td>
                    <td><button class="btn" type="submit" id="confirmn">Confirm</button></td>
                </tr>
                <tr>
                    <td><label>Phone:</label></td>
                    <td><input class="signupField" type="text" id="phone" name="phone" value=""/></td>
                    <td><button class="btn" type="submit" id="confirmp">Confirm</button></td>
                </tr>
                 </table> 
                </form>
                
                </div>
            </div>
            </center>>
            <center>
        <div style="
                     height: 375px;
                     width: 300px;
                     position: absolute;
                     top:30px;
                     margin: 0 auto;
                     left:1000px;">
<button class="btn" onclick ="redirect()" id="cancel">Cancel</button>
                <script>
    function redirect() {
          window.location.href = "filterContacts.jsp";   
         }

                </script>


                <form method="get" action="logout">
                    <button class="btn" type="logout">Logout</button>
        </form>

        <div></div>
        </div>
            </center>
    </body>
</html>
