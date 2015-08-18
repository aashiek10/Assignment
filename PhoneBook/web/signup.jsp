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
           <table style="width:40%">
               <tr>
            <div>
                <td><label>First Name:</label></td>
                <td><input type="text" id="first_name" name="first_name" required/></td>
            </div>
               </tr>
               <tr>
            <div>
                <td><label>Last Name:</label></td>
                <td><input type="text" id="last_name" name ="last_name" required/></td>
            </div>
               </tr><tr>
            <div>
               <td> <label>E-mail:</label></td>
               <td> <input type="email" id="mail" name ="email" required/></td>
            </div>
               </tr><tr>
            <div>
                <td><label>Confirm E-mail:</label></td>
                <td><input type="email" id="confirm_mail" name="emailconf" required/></td>
            </div>
               </tr><tr>
            <div>
                <td><label>Password:</label></td>
                <td><input type="password" pattern=".{5,10}" title ="Min 5, Max 10" id="password" name="password" required/></td>
            </div>
               </tr><tr>
            <div>
               <td> <label>Confirm Password:</label></td>
               <td> <input type="password" pattern=".{5,10}" title ="Min 5, Max 10" id="confirm_password" name="passwordconf" required/></td>
            </div>
               </tr>
           </table>
            <div class="button">
                <button type="submit" id="submit">Submit</button>
            </div>
        </form>
            </div>
    </body>
</html>
