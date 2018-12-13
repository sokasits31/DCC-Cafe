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
import java.io.IOException;


/**
 * A simple servlet to welcome the user.
 * @author pwaite
 */

@WebServlet(
      name = "volServlet",
      urlPatterns = {"/vol"}
)

public class Vol extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getUserPrincipal().getName();

        logger.debug("userName= " + username );

        GenericDao genericDao = new GenericDao(User.class);

        req.setAttribute("users", genericDao.getByPropertyEqual("userName",username));




        RequestDispatcher dispatcher = req.getRequestDispatcher("/vol/vol.jsp");
        dispatcher.forward(req, resp);
    }


}


