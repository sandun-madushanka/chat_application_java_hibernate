/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.SaveDaoImp;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojos.User;

/**
 *
 * @author Shakthi Dilshan
 */
@WebServlet(name = "SaveNewUser", urlPatterns = {"/SaveNewUser"})
public class SaveNewUser extends HttpServlet {

    SaveDaoImp savedao = new SaveDaoImp();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try (PrintWriter out = response.getWriter()) {

            User u = new User();
            u.setFname(request.getParameter("fname"));
            u.setLname(request.getParameter("lname"));
            u.setDob(request.getParameter("bday"));
            u.setUsername(request.getParameter("uname"));
            u.setPassword(request.getParameter("pass"));

            if (request.getParameter("pass").equals(request.getParameter("passr"))) {
                //System.out.println();
                //  User user = (User) savedao.saveData(u);
                Object ob = savedao.saveData(u);
                int val = Integer.parseInt(ob.toString());

                if (val > 0) {
                    response.sendRedirect("userregistration.jsp?msg=1&userid=" + val);
                } else {
                    response.sendRedirect("userregistration.jsp?msg=0&userid=" + val);
                }
            } else {
                response.sendRedirect("userregistration.jsp?msg=2");
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
    }// </editor-fold>

}
