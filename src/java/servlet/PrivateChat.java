/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.PrivateChatDaoImp;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojos.Chatroom;
import pojos.User;

/**
 *
 * @author Shakthi Dilshan
 */
@WebServlet(name = "PrivateChat", urlPatterns = {"/PrivateChat"})
public class PrivateChat extends HttpServlet {
    PrivateChatDaoImp prvtchat = new PrivateChatDaoImp();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {

            int otheruser = Integer.parseInt(request.getParameter("otheruser"));
            int currentuser = Integer.parseInt(request.getParameter("currentuser"));
            int chatroomid =0;
            User u1 = new User();
            u1.setUId(otheruser);
            User u2 = new User();
            u2.setUId(currentuser);
            Chatroom checkChatRoom = prvtchat.checkChatRoom(u1, u2);
            chatroomid = checkChatRoom.getCrId();
           
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewServlet at " + checkChatRoom.getCrId() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            if(checkChatRoom.getCrId()>0){
            response.sendRedirect("privatechatbox.jsp?currentuser="+currentuser+"&otheruser="+otheruser+"&chatroom="+chatroomid);
            }
            
            

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
