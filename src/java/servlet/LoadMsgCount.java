/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.LoadMsgDaoImp;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import pojos.Chatroom;
import pojos.Message;

/**
 *
 * @author Shakthi Dilshan
 */
@WebServlet(name = "LoadMsgCount", urlPatterns = {"/LoadMsgCount"})
public class LoadMsgCount extends HttpServlet {

    LoadMsgDaoImp loadmsg = new LoadMsgDaoImp();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            Chatroom ch = new Chatroom();
            ch.setCrId(Integer.parseInt(request.getParameter("valchatroom")));
            Criterion cf = Restrictions.eq("chatroom", ch);
            int userid = Integer.parseInt(request.getParameter("valuserid"));
            int currentuser = Integer.parseInt(request.getParameter("valcurrentuser"));
            String retmsg = "";
            int msgid = 0;
            int returnuserid=0;

            List<Message> l = loadmsg.loadMsg(Integer.parseInt(request.getParameter("valmsgid")), cf);
            for (Message message : l) {
                System.out.println(message.getMsgId());
                msgid = message.getMsgId();
                returnuserid=message.getUser().getUId();

            }
            if(msgid==0){
            out.write(""+Integer.parseInt(request.getParameter("valmsgid"))+" "+Integer.parseInt(request.getParameter("valcurrentuser")));
            }else{
            out.write(""+msgid+" "+returnuserid);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
