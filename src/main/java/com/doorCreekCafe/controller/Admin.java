package com.doorCreekCafe.controller;


import com.doorCreekCafe.entity.User;
import com.doorCreekCafe.persistence.GenericDao;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.Principal;


/**
 * A simple servlet to welcome the user.
 * @author pwaite
 */

@WebServlet(
      name = "adminServlet",
      urlPatterns = {"/admin"}
)

public class Admin extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao userDao = new GenericDao(User.class);


        //req.setAttribute("users", userDao.getAll());
        //if (req.getParameter("submit").equals("Display All Resources")) {
        req.setAttribute("users", userDao.getByPropertyEqual("userName", "admin"));
        //req.setAttribute("users", userDao.getByPropertyEqual("userName", req.getParameter("j_username")));
        //}


        RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/admin.jsp");
        dispatcher.forward(req, resp);
    }


}


