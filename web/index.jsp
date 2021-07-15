<%-- 
    Document   : index
    Created on : Nov 8, 2017, 10:11:33 PM
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
        <title>Home | Chat</title>


    </head>
    <body>
        <div class="container">
            <div class="row login-body">
                <div class="col-md-5 offset-md-3">
                    <div class="modal-content">
                        <form method="POST">
                            <div class="modal-header">
                                <h3>Log in</h3>
                            </div>
                            <div class="modal-body">
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="User Name" name="uname">
                                </div>
                                <div class="form-group">
                                    <input type="password" class="form-control" placeholder="Password" name="pass">
                                </div>
                                <%

                                    if (request.getParameter("msg") != null) {
                                       // out.write("<h1>" + request.getParameter("msg") + "</h1>");
                                        if (request.getParameter("msg").equals("1")) {
                                %>
                                <div class="alert alert-danger" role="alert">
                                    Error Login Please check User Name And Password
                                </div>
                                <%
                                        }
                                    }
                                %>


                            </div>

                            <div class="modal-body">
                                <div><hr></div>
                                <button type="submit" class="btn btn-primary btn-block" formaction="Login">Log in</button>
                                <button type="sumbit" class="btn btn-default btn-block" formaction="userregistration.jsp">Create New Account</button>
                            </div>  
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
