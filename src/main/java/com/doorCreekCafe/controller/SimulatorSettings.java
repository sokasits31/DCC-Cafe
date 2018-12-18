package com.doorCreekCafe.controller;


import com.doorCreekCafe.entity.MenuCategory;
import com.doorCreekCafe.entity.MenuItem;
import com.doorCreekCafe.entity.TestHistory;
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
import java.time.LocalTime;
import java.util.List;


/**
 * A servlet that gathers test menu items based on user preferences and start the test.
 * @author pwaite
 */

@WebServlet(
      name = "simulatorSettingsServlet",
      urlPatterns = {"/simulator/test/start"}
)

public class SimulatorSettings extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        logger.debug("in Simulator Settings");

        HttpSession session = req.getSession();

        // set user Id.... this is needed if no login has been chosen
        String userId = null;

        // If user has logged in userID will be used to select menu item to be tested.
        if (session.getAttribute("userId") != null) {
            userId = String.valueOf(session.getAttribute("userId"));
        }

        // Gather menu items to be tested
        GenericDao genericDao = new GenericDao(TestHistory.class);

        // set number of question in test session
        int size = Integer.parseInt(req.getParameter("testSize"));

        // Gather test questions
        List<TestHistory> testMenuItems = genericDao.getQueryResults(generateSQL(userId), size);

        // Get all menu items
        GenericDao genericDao2 = new GenericDao(MenuCategory.class);

        // setup session attributes
        session.setAttribute("testSize", req.getParameter("testSize"));
        session.setAttribute("freq", req.getParameter("freq"));
        session.setAttribute("language", req.getParameter("language"));
        session.setAttribute("testMenuItems", testMenuItems);
        session.setAttribute("question", 1);
        session.setAttribute("categoryId", 1);
        session.setAttribute("categoryColumn", "A");
        session.setAttribute("categoryRow", 1);
        session.setAttribute("menuCategories", genericDao2.getAll());


        // Save menu Item being tested
        session.setAttribute("currentTestHistory", testMenuItems.get(0));
        session.setAttribute("currentTestMenuItem", testMenuItems.get(0).getDescription());
        session.setAttribute("currentTestArrayIndex", 0);
        session.setAttribute("currentTestMenuCategory", testMenuItems.get(0).getMenuCategory());


        logger.debug("TEST MENU CAT: " + testMenuItems.get(0).getMenuCategory());


        RequestDispatcher dispatcher = req.getRequestDispatcher("/testSimulator/register2.jsp");
        dispatcher.forward(req, resp);
    }

    private String generateSQL (String userId) {

        String sql;

        sql = "select " +
              "    m.id as id" +
              "   ,m.id as item_id" +
              "   ,m.description" +
              "   ,m.alt_description" +
              "   ,case " +
              "           when m.frequency_level = 'High' then 1" +
              "           when m.frequency_level = 'Med'  then 2" +
              "           when m.frequency_level = 'Low'  then 3" +
              "           when m.frequency_level = 'None' then 9" +
              "           when m.frequency_level = 'Add on' then 9" +
              "       end as frequency_order" +
              "      ,rand() * 10000 as random_number" +
              "      ,m.short_Hand as short_hand" +
              "      ,c.category_description as menu_category" +
              "      ,0 as response_time_in_sec" +
              "      ,'fail' as response_status" +
              "      ," + userId + " as user_id" +
              "      ,now() as question_start_time" +
              "      ,now() as question_end_time" +
              " FROM   menuItem m" +
              "        inner join" +
              "        menuCategory c" +
              "            on m.menuCategory_id = c.id" +
              "        left outer join" +
              "        testHistory h" +
              "           on h.user_id = " + userId +
              " where  not exists (" +
              "        select 1" +
              "        from   testHistory x" +
              "        where  x.item_id = m.id" +
              "        and    TIMESTAMPDIFF(SECOND, x.question_start_time, x.question_end_time) < 15" +
              "        and    x.user_id = h.user_id" +
              "        )" +
              " and    m.frequency_level in ('High', 'Med', 'Low') " +
              " order by 5, 6";

        return sql;

    }

}


