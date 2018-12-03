package com.doorCreekCafe.controller;


import com.doorCreekCafe.entity.MenuCategory;
import com.doorCreekCafe.entity.MenuItem;
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
import javax.swing.*;
import java.io.IOException;
import java.util.List;


/**
 * A simple servlet to welcome the user.
 * @author pwaite
 */

@WebServlet(
      name = "simulatorMenuServlet",
      urlPatterns = {"/simulator/test/answer"}
)

public class SimulatorSelectMenuItem extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        logger.debug("in simulator:menuItem");


        HttpSession session = req.getSession();

        logger.debug("CURRENT TEST ITEM: " + session.getAttribute("currentTestMenuItem"));
        logger.debug("SELECTED ITEM: " + req.getParameter("submit"));



        // Determine of test is over
        String questionNumberString = String.valueOf(session.getAttribute("currentTestArrayIndex"));
        int index = (Integer.parseInt(questionNumberString)) + 1;

        String numberOfQuestions = String.valueOf(session.getAttribute("testSize"));
        int maxIndex = (Integer.parseInt(numberOfQuestions));




        if (index == maxIndex && session.getAttribute("currentTestMenuItem").equals(req.getParameter("submit"))) {

            logger.debug("test over");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/testSimulator/testResults.jsp");
            dispatcher.forward(req, resp);

        } else {

            String answerStatus;

            if (session.getAttribute("currentTestMenuItem").equals(req.getParameter("submit"))) {
                logger.debug("CORRECT");
                // Set Answer Status
                session.setAttribute("answerStatus", "CORRECT");

                // Increment question number
                int question = index + 1;

                // Get question list
                List<SimulatorTest> testMenuItems = (List) session.getAttribute("testMenuItems");

                // set session attributes for next question
                session.setAttribute("currentTestMenuItem", testMenuItems.get(index).getDescription());
                session.setAttribute("currentTestMenuCategory", testMenuItems.get(index).getMenuCategory());
                session.setAttribute("currentTestArrayIndex", index);
                session.setAttribute("question", question);
            } else {
                logger.debug("incorrect");
                session.setAttribute("answerStatus", "INCORRECT");
            }

            // Refresh screen
            RequestDispatcher dispatcher = req.getRequestDispatcher("/testSimulator/register2.jsp");
            dispatcher.forward(req, resp);
        }
    }
}


