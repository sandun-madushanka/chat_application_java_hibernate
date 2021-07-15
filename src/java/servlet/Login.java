/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.LoginDaoImp;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pojos.User;

/**
 *
 * @author Shakthi Dilshan
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {
    LoginDaoImp logindao = new LoginDaoImp();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try (PrintWriter out = response.getWriter()) {

             User u = new User();
             u.setUsername(request.getParameter("uname"));
             u.setPassword(request.getParameter("pass"));
             User login = logindao.login(u);
             //System.out.println(login.getUId());
             if(login!=null){
             response.sendRedirect("chatbox.jsp");
                 HttpSession httses = request.getSession();
                 httses.setAttribute("user", login);
             }else{
              response.sendRedirect("index.jsp?msg=1");
             }
             
        }
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
