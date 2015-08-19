<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Signup</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script type="text/javascript" src="JS/jquery-1.11.1.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                $("#submit").click(function (event) {
                    var email = $("#mail").val();
                    var confirmEmail = $("#confirm_mail").val();
                    var password = $("#password").val();
                    var confirmPassword = $("#confirm_password").val();

                    if (email !== confirmEmail) {
                        alert('email and confirm email are not equal!');
                        event.preventDefault();
                    }

                    if (password !== confirmPassword) {
                        alert('password and confirmPassword are not equal!');
                        event.preventDefault();
                    }

                    if ((password === null && confirmPassword === null) || (password === "" && confirmPassword === "")) {
                        alert('Please enter valid password!');
                        event.preventDefault();
                    }
                });
            });
        </script>
<link rel="stylesheet" type="text/css" href="designs.css" media="screen" />
    </head>

    <body>
        <% if (request.getAttribute("signupprocess") != null) { %>
        <h1>Email Id already exists!</h1>
        <%} %>
        
        <% if (request.getSession().getAttribute("userId") != null) {
                response.sendRedirect("home.jsp");
            }%>
        <div style="width:400px; margin-right:auto; margin-left:auto; text-align:center;">

            <form action="signupProcessor" id="signupform" method="post">
                <center>
                    <div style="
                     height: 375px;
                     width: 300px;
                     position: absolute;
                     top:125px;
                     margin: 0 auto;
                     left:415px;">
                        
                <table style="width:40%">
                 <h4>Register</h4>

               <tr>
            <div>
                <td><label></label></td>
                <td><input type="text" id="first_name" class="signupField" name="first_name" value="First Name"  required onfocus="if (this.value==='First Name') this.value='';"/></td>
            </div>
               
            <div>
                <td><label></label></td>
                <td><input type="text" id="last_name" class="signupField" name ="last_name" value="Last Name" required onfocus="if (this.value==='Last Name') this.value='';"/></td>
            </div>
               </tr><tr>
            <div>
               <td> <label></label></td>
               <td> <input type="email" id="mail" class="signupField" name ="email" value="E-mail" required onfocus="if (this.value==='E-mail') this.value='';"/></td>
            </div>
            <div>
                <td><label></label></td>
                <td><input type="email" id="confirm_mail" class="signupField" name="emailconf" value="Confirm E-mail" required onfocus="if (this.value==='Confirm E-mail') this.value='';"/></td>
            </div>
               </tr><tr>
            <div>
                <td><label></label></td>
                <td><input type="password" pattern=".{5,10}" title ="Min 5, Max 10" id="password" value="Password" class="signupField" name="password" required/></td>
            </div>
               
            <div>
               <td> <label></label></td>
               <td> <input type="password" pattern=".{5,10}" title ="Min 5, Max 10" id="confirm_password" value="Confirm Password" class="signupField" name="passwordconf" required/></td>
            </div>
               </tr>
           </table>
            <div class="button">
                <td height="100"><button class="btn" type="submit" id="submit">Submit</button></td>
            </div>
                    </div>
                    </center>
        </form>
            </div>
    </body>
</html>
