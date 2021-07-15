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
@WebServlet(name = "LoadMsg", urlPatterns = {"/LoadMsg"})
public class LoadMsg extends HttpServlet {

    LoadMsgDaoImp loadmsg = new LoadMsgDaoImp();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            Chatroom ch = new Chatroom();
            ch.setCrId(Integer.parseInt(request.getParameter("valchatroom")));
            Criterion cf = Restrictions.eq("chatroom", ch);
            int userid = Integer.parseInt(request.getParameter("valuserid"));
            int currentuser = Integer.parseInt(request.getParameter("valcurrentuser"));
            String retmsg = "";
            //int msgid =0;

            //List<Message> l = loadmsg.loadMsg(Integer.parseInt(request.getParameter("valmsgid")), cf);
            List<Message> l = loadmsg.loadMsg(cf);
            for (Message message : l) {
                System.out.println(message.getMsg() + "  " + message.getMsgId());
               // msgid = message.getMsgId();
                if (userid != message.getUser().getUId()) {
                    userid = message.getUser().getUId();

                    if (userid == currentuser) {

                        retmsg += "<div class='col-md-3 user-img '><p>You</p></div>";

                    } else {

                        retmsg += "<div class='col-md-3 offset-md-9 user-img-other'><p>";
                        retmsg += "@" + message.getUser().getUsername() + "</p></div>";
                    }

                }
                if (userid == currentuser) {

                    retmsg += "<div class='col-md-10 user-msg'><div class='msgcontent'><p>";
                    retmsg += message.getMsg() + "</p></div><div class='msgtime'><p>" + message.getMsgTime() + "</p></div></div>";

                } else {

                    retmsg += "<div class='col-md-10 offset-md-2 user-msg-other'><div class='msgcontent'><p>";
                    retmsg += message.getMsg() + "</p></div>";
                    retmsg += "<div class='msgtime'><p>" + message.getMsgTime() + "</p></div></div>";
                }

            }

       out.write(retmsg);
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
