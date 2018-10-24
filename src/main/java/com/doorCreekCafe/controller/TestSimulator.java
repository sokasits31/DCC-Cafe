package com.doorCreekCafe.controller;


import com.doorCreekCafe.entity.User;
import com.doorCreekCafe.persistence.GenericDao;

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
        urlPatterns = {"/testSimulator"}
)

public class TestSimulator extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        //RequestDispatcher dispatcher = req.getRequestDispatcher("/volunteerHome.jsp");
        //dispatcher.forward(req, resp);

        GenericDao userDao = new GenericDao(User.class);

        //userDao.getByPropertyEqual("userName", )

        //req.setAttribute("users", userDao.getAll());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/content/adminDashboard.jsp");
        dispatcher.forward(req, resp);
    }
}


