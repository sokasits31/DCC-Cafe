package com.doorCreekCafe.controller;


import com.doorCreekCafe.entity.MenuCategory;
import com.doorCreekCafe.entity.MenuItem;
import com.doorCreekCafe.entity.TestHistory;
import com.doorCreekCafe.entity.User;
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


        // Determine of test is over
        String questionNumberString = String.valueOf(session.getAttribute("currentTestArrayIndex"));
        int currentIndex = Integer.parseInt(questionNumberString);
        int index = (Integer.parseInt(questionNumberString)) + 1;

        String numberOfQuestions = String.valueOf(session.getAttribute("testSize"));
        int maxIndex = (Integer.parseInt(numberOfQuestions));


        if (index == maxIndex && session.getAttribute("currentTestMenuItem").equals(req.getParameter("submit"))) {

            logger.debug(session.getAttribute("userId") + "user id");
            logger.debug("test over");


            GenericDao genericDao = new GenericDao(TestHistory.class);

            // set approx time question was test item was answered correctly
            testMenuItems.get(currentIndex).setQuestionEndTime(LocalDateTime.now());

            // get
            //List<TestHistory> testMenuItems = (List<TestHistory>) session.getAttribute("testMenuItems");


            int insertId;

            for (TestHistory item: testMenuItems) {
                if (item.getUser() != null) {
                    insertId = genericDao.insert(item);


                    logger.debug(item.getDescription());
                    logger.debug(item.getQuestionStartTime());
                    logger.debug(item.getQuestionEndTime());
                } else {
                    logger.debug("finally here!!!");
                }

            }


            RequestDispatcher dispatcher = req.getRequestDispatcher("/testSimulator/testResults.jsp");
            dispatcher.forward(req, resp);

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

    private String generateSQL(int testHistoryId) {
        String sql =
               " SELECT CASE" +
               "           WHEN TIMESTAMPDIFF(SECOND, t.question_start_time, t.question_end_time) < p.response_time then 'pass'" +
               "           WHEN TIMESTAMPDIFF(SECOND, t.question_start_time, t.question_end_time) >= p.response_time then 'fail'" +
               "       end as result" +
               " FROM  testHistory t" +
               "       inner join" +
               "       user u" +
               "           on t.user_id = u.id" +
               "       inner join" +
               "       test_parm p" +
               "           on u.skill_level = p.id" +
               " where t.id < 4";
        return sql;
    }
}


