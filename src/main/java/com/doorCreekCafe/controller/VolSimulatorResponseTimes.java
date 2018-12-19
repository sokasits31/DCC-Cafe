package com.doorCreekCafe.controller;


import com.doorCreekCafe.entity.User;
import com.doorCreekCafe.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


/**
 * A simple servlet to welcome the user.
 * @author pwaite
 */

@WebServlet(

        urlPatterns = {"/vol/responseTimes"}
)

public class VolSimulatorResponseTimes extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        HttpSession session = req.getSession();

        GenericDao genericDao = new GenericDao(User.class);


        List<User> users = genericDao.getByPropertyEqual("id", String.valueOf(session.getAttribute("userId")));


        req.setAttribute("Users", users);


        RequestDispatcher dispatcher = req.getRequestDispatcher("/vol/volResponseTimes.jsp");
        dispatcher.forward(req, resp);
    }

}


