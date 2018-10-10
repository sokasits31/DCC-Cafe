package com.doorCreekCafe.controller;

import com.doorCreekCafe.persistence.TestHistoryDao;


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
        name = "adminServlet",
        urlPatterns = {"/adminDashboard"}
)

public class Admin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        TestHistoryDao testHistoryDao = new TestHistoryDao();

        req.setAttribute("userTests", testHistoryDao.getAllTests() );
        //if (req.getParameter("submit").equals("Display All Resources")) {
        //    req.setAttribute("users", userDao.getAllUsers());
        //}
        RequestDispatcher dispatcher = req.getRequestDispatcher("/content/admin/displayAllResources.jsp");
        dispatcher.forward(req, resp);
    }
}


