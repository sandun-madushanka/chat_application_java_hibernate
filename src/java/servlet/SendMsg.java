package servlet;

import dao.SaveDaoImp;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojos.Chatroom;
import pojos.Message;
import pojos.User;

/**
 *
 * @author Shakthi Dilshan
 */
@WebServlet(name = "SendMsg", urlPatterns = {"/SendMsg"})
public class SendMsg extends HttpServlet {
    SaveDaoImp savedao = new SaveDaoImp();




    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 try (PrintWriter out = response.getWriter()) {
     User u = new User();
     Chatroom croom = new Chatroom();
     Message msg = new Message();
     u.setUId(Integer.parseInt(request.getParameter("userid")));
     croom.setCrId(Integer.parseInt(request.getParameter("chatroom")));
     Date date = new Date();
     
     msg.setUser(u);
     msg.setChatroom(croom);
     msg.setMsgTime(date);
     msg.setMsg(request.getParameter("msg"));
     
     savedao.saveData(msg);
     
     
     
     
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
