package com.doorCreekCafe.controller;


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


/**
 * A simple servlet to welcome the user.
 * @author pwaite
 */

@WebServlet(
        name = "volsimulatorStartServlet",
        urlPatterns = {"/vol/simulator/settings"}
)

public class VolSimulatorStart extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        HttpSession session = req.getSession();

        logger.debug("User Id: " + session.getAttribute("userId"));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/testSimulator/testSettings.jsp");
        dispatcher.forward(req, resp);
    }

}


