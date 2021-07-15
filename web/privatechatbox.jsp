<%-- 
    Document   : privatechatbox
    Created on : Nov 10, 2017, 3:00:35 PM
    Author     : Shakthi Dilshan
--%>

<%@page import="org.hibernate.criterion.Restrictions"%>
<%@page import="pojos.Chatroom"%>
<%@page import="dao.LoadMsgDaoImp"%>
<%@page import="pojos.Message"%>
<%@page import="org.hibernate.criterion.Criterion"%>
<%@page import="java.util.List"%>
<%@page import="dao.LoadDaoImp"%>
<%@page import="pojos.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" type="text/css" rel="stylesheet">
        <link href="css/test.css" type="text/css" rel="stylesheet">
        <title>Chat Box Private    | Chat</title>


        <%
            int chatroom = 1;
            int msg = 0;
            int userid = 0;
            int currentuser = 0;
            int otheruser =0;
            if ((User) request.getSession().getAttribute("user") == null) {
                response.sendRedirect("index.jsp");

            } else {
                //currentuser = Integer.parseInt(request.getParameter("currentuser"));
                otheruser = Integer.parseInt(request.getParameter("otheruser"));
                chatroom = Integer.parseInt(request.getParameter("chatroom"));
               // out.write(chatroom+"  "+currentuser);
                

            }

        %>


    </head>
    <body onload="scrollmsg()">
        <%            User us = new User();
            //User us = null;
            if ((User) request.getSession().getAttribute("user") != null) {
                us = (User) request.getSession().getAttribute("user");
                currentuser = us.getUId();
            }

            //out.print(us.getUId());

        %>
         <nav class="navbar navbar-default nav-bar">
            <div class="container-fluid">
                <div class="navbar-header nav-bar">
                    <a class="navbar-brand nav-bar" href="#">Chat Application</a>
                </div>
                <ul class="nav navbar-nav">
                    <li class="active "><a href="LogOut"><button class="btn">Log Out</button></a></li>
                </ul>
            </div>
        </nav>
        <div class="container headding">
            <div class="row">
                <div class="col-md-3"><h4>Current User <br>
                        <%                            if (us.getUsername() != null) {
                                // User us = (User) request.getSession().getAttribute("user");
                                out.write("@"+us.getUsername());
                            } else {
                                out.write("Invalid User");
                            }

                        %></h4></div>
                <div class="col-md-9">
                    <h1>Private Chat</h1>
                </div>
            </div>
        </div>

        <div class="container">
            <div class="row">
                <!--contacts-->

                <div class="col-md-3 contact-content">
                    <div class="lobby"><h6>Chat Room ID <% out.print(chatroom); %> </h6></div>
                    <ul class="list-group">
                        <%                            LoadDaoImp loaddao = new LoadDaoImp();
                            User u = new User();
                            List<Criterion> cr = null;
                            List<Object> use = loaddao.loadData(u, cr);
                            User un;
                            for (Object o : use) {
                                un = (User) o;
                                if (un.getUId() == currentuser || un.getUId() == otheruser) {
                        %>
                        <li class="list-group-item contact-name">
                            <div class="input-group">
                                <h6 class="form-control contact-name-group"><%  out.write("@"+un.getUsername()); %></h6>
                            </div>
                        </li>
                        <%
                                }

                            }
                        %>

                        <!--end of contacts-->

                    </ul>
                </div>
                <div class="col-md-9 msg-content">
                    <div class="container-fluid row">
                        <div id="message-body" class="col-md-12 msg-body">

                            <%
                                LoadMsgDaoImp loadmsg = new LoadMsgDaoImp();
                                Message me = new Message();

                                Chatroom ch = new Chatroom();
                                ch.setCrId(chatroom);
                                Criterion cf = Restrictions.eq("chatroom", ch);

                                List<Message> msob = loadmsg.loadMsg(cf);;
                                Message msun;
                            %>
                            <div class="row" id="msg-inner-body">
                                <%
                                    for (Object o : msob) {
                                        msun = (Message) o;
                                        msg = msun.getMsgId();
                                        String uname = msun.getUser().getPassword();
                                        if (userid != msun.getUser().getUId()) {
                                            userid = msun.getUser().getUId();

                                            if (userid == currentuser) {
                                %>
                                <div class="col-md-3 user-img ">
                                    <p>You</p>
                                </div>
                                <%
                                } else {
                                %>
                                <div class="col-md-3 offset-md-9 user-img-other">
                                    <p><% out.print("@" + msun.getUser().getUsername());%></p>
                                </div>
                                <%
                                        }

                                    }
                                    if (userid == currentuser) {
                                %>
                                <div class="col-md-10 user-msg">
                                    <div class="msgcontent"><p><% out.write(msun.getMsg() + " "); %></p></div>
                                    <div class="msgtime"><p><% out.write(msun.getMsgTime() + ""); %></p></div>
                                </div>
                                <%
                                } else {
                                %>
                                <div class="col-md-10 offset-md-2 user-msg-other">
                                    <div class="msgcontent"><p><% out.write(msun.getMsg() + " "); %></p></div>
                                    <div class="msgtime"><p><% out.write(msun.getMsgTime() + ""); %></p></div>
                                </div>
                                <%
                                        }

                                    }
                                %>
                            </div>

                        </div>
                        <div class="col-md-12 msg-send-body">
                            <div class="container">

                                <div class="input-group">
                                    <input id="msg" type="text" class="form-control msg-send-input" placeholder="Your Message" name="msg">
                                    <input id="chatroom" type="number" value="<%=chatroom%>" name="chatroom" hidden="">
                                    <input id="userid" type="text" value="<%

                                        if (us != null) {
                                            //User us = (User) request.getSession().getAttribute("user");
                                            out.print(us.getUId());
                                        } else {
                                            out.print(0);
                                        }

                                           %>" name="userid" hidden="" >
                                    <span class="input-group-btn">
                                        <button class="btn btn-success msg-send-button" type="button" onclick="sendMsg()">Send</button>
                                    </span>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div>
            <%              
//                out.print("Chat Room -" + chatroom);
//                out.print("Current User-" + currentuser);
//                out.print("Messeg ID -" + msg);
//                out.print("User ID -" + userid);

            %>
            <input type="text" value="<% out.print(chatroom); %>" id="valchatroom" hidden="">
            <input type="text" value="<% out.print(currentuser); %>" id="valcurrentuser" hidden="">
            <input type="text" value="<% out.print(msg); %>" id="valmsgid" hidden="" >
            <input type="text" value="<% out.print(userid);%>" id="valuserid" hidden="">
<!--                       <button onclick="twome()">click</button>
                        <button onclick="loadmcount()">click</button>-->
        </div>


        <script src="js/jquery-3.2.1.min.js" type="text/javascript"></script>
        <script src="js/propper.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/scriptchat.js" type="text/javascript"></script>
    </body>
</html>
