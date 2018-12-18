package com.doorCreekCafe.controller;


import com.doorCreekCafe.entity.*;
import com.doorCreekCafe.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.plugins.util.ResolverUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static java.time.LocalDateTime.now;


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

        // Get question list
        List<TestHistory> testMenuItems = (List<TestHistory>) session.getAttribute("testMenuItems");

        // Determine index for current and next question
        String questionNumberString = String.valueOf(session.getAttribute("currentTestArrayIndex"));
        int currentIndex = Integer.parseInt(questionNumberString);
        int index = (Integer.parseInt(questionNumberString)) + 1;

        //String numberOfQuestions = String.valueOf(session.getAttribute("testSize"));
        //int maxIndex = (Integer.parseInt(numberOfQuestions));

        //logger.debug("maxIndex:" + maxIndex);
        //logger.debug("size:" + testMenuItems.size());


        // test is over
        if (index == testMenuItems.size() && session.getAttribute("currentTestMenuItem").equals(req.getParameter("submit"))) {

            // Create genericDao object
            GenericDao genericDao = new GenericDao(TestHistory.class);

            // set approx time question was test item was answered correctly
            testMenuItems.get(currentIndex).setQuestionEndTime(LocalDateTime.now());

            int insertId;

            for (TestHistory item: testMenuItems) {
                if (item.getUser() != null) {
                    updateResponseStatus(item);
                    insertId = genericDao.insert(item);
                } else {
                    logger.debug("finally here!!!");
                }
            }

            RequestDispatcher dispatcher = req.getRequestDispatcher("/testSimulator/testResults.jsp");
            dispatcher.forward(req, resp);

        // test continues
        } else {

            String answerStatus;

            if (session.getAttribute("currentTestMenuItem").equals(req.getParameter("submit"))) {
                logger.debug("CORRECT");


                // Set Question approx quetion answer time
                testMenuItems.get(currentIndex).setQuestionEndTime(LocalDateTime.now());

                // Set Answer Status
                session.setAttribute("answerStatus", "CORRECT");

                // Increment question number
                int question = index + 1;

                // Set next question approx start time
                testMenuItems.get(index).setQuestionStartTime(LocalDateTime.now());
                logger.debug(testMenuItems.get(index).getQuestionStartTime());


                // set session attributes for next question
                session.setAttribute("currentTestHistory", testMenuItems.get(index));
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


    /*
     * Method will set response status and response time in seconds
     */
    private void updateResponseStatus (TestHistory item) {

        String status;

        Long diffInSeconds = java.time.Duration.between(item.getQuestionStartTime(),
                item.getQuestionEndTime()).getSeconds();

        logger.debug("diff in seconds" + diffInSeconds);

        if (diffInSeconds >= 10.0) {
            item.setResponseStatus("FAIL");
        } else {
            item.setResponseStatus("PASS");
        }

        item.setResponseTimeInSec(diffInSeconds.intValue());

    }
}


