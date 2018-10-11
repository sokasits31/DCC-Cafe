package com.doorCreekCafe.controller;


import com.doorCreekCafe.persistence.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * A simple servlet to welcome the user.
 * @author pwaite
 */

@WebServlet(
        urlPatterns = {"/grantAccess"}
)

public class GrantAccess extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        //RequestDispatcher dispatcher = req.getRequestDispatcher("/volunteerHome.jsp");
        //dispatcher.forward(req, resp);

        UserDao userDao = new UserDao();

        req.setAttribute("users", userDao.getAllUsers());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/content/adminDashboard.jsp");
        dispatcher.forward(req, resp);
    }
}


