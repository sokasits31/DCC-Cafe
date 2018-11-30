package com.doorCreekCafe.controller;


import com.doorCreekCafe.entity.MenuCategory;
import com.doorCreekCafe.entity.SimulatorTest;
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
      name = "simulatorStartServlet",
      urlPatterns = {"/simulator/settings"}
)

public class SimulatorStart extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        logger.debug("in Simulator Start");

        RequestDispatcher dispatcher = req.getRequestDispatcher("/testSimulator/testSettings.jsp");
        dispatcher.forward(req, resp);
    }

}


