package com.doorCreekCafe.controller;


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


        //if (req.getParameter("submit").equals("Submit")) {
        //    req.setAttribute("users", userDao.getAllUsers());
        //}

        RequestDispatcher dispatcher = req.getRequestDispatcher("/volunteerHome.jsp");
        dispatcher.forward(req, resp);
    }
}


