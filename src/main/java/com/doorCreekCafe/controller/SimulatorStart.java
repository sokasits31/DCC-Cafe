package com.doorCreekCafe.controller;



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
        name = "simulatorStartServlet",
        urlPatterns = {"/simulator/settings"}
)

public class SimulatorStart extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        logger.debug("User Id: " + req.getParameter("userName"));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/testSimulator/testSettings.jsp");
        dispatcher.forward(req, resp);
    }

}


