<%-- 
    Document   : userregistration
    Created on : Nov 9, 2017, 10:10:31 PM
    Author     : Shakthi Dilshan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" type="text/css" rel="stylesheet">
        <link href="css/test.css" type="text/css" rel="stylesheet">
        <title>User Registration | Chat</title>


    </head>
    <body>
        <nav class="navbar navbar-default nav-bar">
            <div class="container-fluid">
                <div class="navbar-header nav-bar">
                    <a class="navbar-brand nav-bar" href="#">Chat Application</a>
                </div>
                <ul class="nav navbar-nav">
                    <li class="active "><a href="index.jsp"><button class="btn">Log in</button></a></li>
                </ul>
            </div>
        </nav>

        <div class="container">
            <div class="row login-body">
                <div class="col-md-5 offset-md-3">
                    <div class="modal-content">
                        <form method="GET" action="SaveNewUser">
                            <div class="modal-header">
                                <h3>Register New User</h3>
                            </div>
                            <div class="modal-body">
                                <div class="form-group">
                                    <label for="fnaem" >First Name</label>
                                    <input type="text" class="form-control" placeholder="First Name" id="fname" name="fname">
                                </div>
                                <div class="form-group">
                                    <label for="lname" >Last Name</label>
                                    <input type="text" class="form-control" placeholder="Last Name" id="lname" name="lname">
                                </div>
                                <div class="form-group">
                                    <label for="bday" >Birth day</label>
                                    <input type="date" class="form-control" placeholder="Birthday" id="bday" name="bday">
                                </div>
                                <div class="form-group">
                                    <label for="uname" >User Name</label>
                                    <input type="text" class="form-control" placeholder="User Name" id="uname" name="uname">
                                </div>
                                <div class="form-group">
                                    <label for="pass" >Password</label>
                                    <input type="password" class="form-control" placeholder="Password" id="pass" name="pass" required="">
                                </div>
                                <div class="form-group">
                                    <label for="pass" >Re-Type Password</label>
                                    <input type="password" class="form-control" placeholder="Password" id="pass" name="passr" required="">
                                </div>
                            </div>

                            <div class="modal-footer">
                                <button type="submit" class="btn btn-primary btn-block">Register</button>
                            </div> 
                            <%

                                if (request.getParameter("msg") != null) {
                                    // out.write("<h1>" + request.getParameter("msg") + "</h1>");
                                    if (request.getParameter("msg").equals("1")) {
                            %>
                            <div class="alert alert-success" role="alert">
                                User Add Sucsess ! <% //out.write(request.getParameter("userid")); %>
                            </div>
                            <%
                            } else if (request.getParameter("msg").equals("0")) {
                            %>
                            <div class="alert alert-danger" role="alert">
                                User Add Error !
                            </div>
                            <%
                            } else {
                            %>
                            <div class="alert alert-danger" role="alert">
                                Password not match
                            </div>
                            <%
                                    }
                                }
                            %>
                        </form>
                    </div>
                </div>
            </div>
        </div>



        <script src="js/jquery-3.2.1.min.js" type="text/javascript"></script>
        <script src="js/propper.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
    </body>
</html>
