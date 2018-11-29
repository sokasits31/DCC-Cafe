package com.doorCreekCafe.controller;


import com.doorCreekCafe.entity.MenuCategory;
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
import java.util.SortedSet;


/**
 * A simple servlet to welcome the user.
 * @author pwaite
 */

@WebServlet(
      name = "simulatorServlet",
      urlPatterns = {"/simulator"}
)

public class SimulatorStartup extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        logger.debug("in Simulator Startup");

        // capture redirect info (if exists)
        HttpSession session = req.getSession();
        logger.debug("categoryId: " + session.getAttribute("categoryId"));
        logger.debug("answer status: " + session.getAttribute("answerStatus"));


        // Local Variables to determine category
        int id;
        String column;
        int row;

        // If categoryId == null test is basically beginning
        if (session.getAttribute("categoryId") == null) {
            id = 1;
            column = "A";
            row = 1;
        }
        else {
            id = (int) session.getAttribute("categoryId");
            column = (String) session.getAttribute("categoryColumn");
            row = (int) session.getAttribute("categoryRow");
        }


        // Get all menu items
        GenericDao genericDao = new GenericDao(MenuCategory.class);

        req.setAttribute("menuCategories", genericDao.getAll());
        req.setAttribute("categoryId", id);
        req.setAttribute("categoryColumn",column);
        req.setAttribute("categoryRow", row);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/testSimulator/register2.jsp");
        dispatcher.forward(req, resp);
    }

    private void getTestMenuItems () {

    }


}


