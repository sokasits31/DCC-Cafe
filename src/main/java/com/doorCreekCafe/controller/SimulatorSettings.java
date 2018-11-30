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
      name = "simulatorSettingsServlet",
      urlPatterns = {"/simulator/test/start"}
)

public class SimulatorSettings extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        logger.debug("in Simulator Settings");

        // Gather menu items to be tested
        GenericDao genericDao = new GenericDao(SimulatorTest.class);

        String sql = "select " +
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
                "      ,m.short_Hand as shortHand" +
                " FROM   menuItem m" +
                " where  not exists (" +
                "        select 1" +
                "        from   testHistory x" +
                "        where  x.menu_id = m.id" +
                "        and    x.status <> 'pass' " +
                "        )" +
                " and    m.frequency_level in ('High', 'Med', 'Low') " +
                " order by 5, 6";

        int size = Integer.parseInt(req.getParameter("testSize"));

        logger.debug("sql: " + sql);
        logger.debug("size: " + size);

        List<SimulatorTest> testMenuItems = genericDao.getQueryResults(sql, size);


        for (SimulatorTest x:testMenuItems) {
            logger.debug("test " + x.getDescription());
            logger.debug(x.getRandomNumber());
            logger.debug(x.getAltDescription());
        }
        // Get all menu items
        GenericDao genericDao2 = new GenericDao(MenuCategory.class);

        logger.debug(testMenuItems);

        // set session attributes
        HttpSession session = req.getSession();
        session.setAttribute("testSize", req.getParameter("testSize"));
        session.setAttribute("freq", req.getParameter("freq"));
        session.setAttribute("language", req.getParameter("language"));
        session.setAttribute("testMenuItems", testMenuItems);
        session.setAttribute("question", 1);
        session.setAttribute("categoryId", 1);
        session.setAttribute("categoryColumn", "A");
        session.setAttribute("categoryRow", 1);
        session.setAttribute("menuCategories", genericDao2.getAll());
        session.setAttribute("testSize", req.getParameter("testSize"));


        RequestDispatcher dispatcher = req.getRequestDispatcher("/testSimulator/register2.jsp");
        dispatcher.forward(req, resp);
    }

}


