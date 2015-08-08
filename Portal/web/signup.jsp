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
        <form action="signupProcessor" id="signupform" method="post">
            <div>
                <label>First Name:</label>
                <input type="text" id="first_name" name="first_name" required/>
            </div>
            <div>
                <label>Last Name:</label>
                <input type="text" id="last_name" name ="last_name" required/>
            </div>
            <div>
                <label>E-mail:</label>
                <input type="email" id="mail" name ="email" required/>
            </div>
            <div>
                <label>Confirm E-mail:</label>
                <input type="email" id="confirm_mail" name="emailconf" required/>
            </div>
            <div>
                <label>Password:</label>
                <input type="password" pattern=".{5,10}" title ="Min 5, Max 10" id="password" name="password" required/>
            </div>
            <div>
                <label>Confirm Password:</label>
                <input type="password" pattern=".{5,10}" title ="Min 5, Max 10" id="confirm_password" name="passwordconf" required/>
            </div>    
            <div class="button">
                <button type="submit" id="submit">Submit</button>
            </div>
        </form>
    </body>
</html>
