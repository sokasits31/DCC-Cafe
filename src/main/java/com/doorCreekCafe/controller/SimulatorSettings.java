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
      urlPatterns = {"/simulator/activeTest"}
)

public class SimulatorSettings extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        logger.debug("in Simulator Settings");

        // Gather menu items to be tested
        GenericDao genericDao = new GenericDao(SimulatorTest.class);

        String sql =
                "SELECT m.id" +
                "   ,m.description" +
                "   ,m.altDescripton" +
                "   ,m.frequencyLevel" +
                "   ,case " +
                "           when m.frequencyLevel = 'High' then 1" +
                "           when m.frequencyLevel = 'Med'  then 2" +
                "           when m.frequencyLevel = 'Low'  then 3" +
                "           when m.frequencyLevel = 'None' then 9" +
                "           when m.frequencyLevel = 'Add on' then 9" +
                "       end as rank" +
                "      ,m.shortHand" +
                "      ,rand() * 10000 as random_number" +
                " FROM   MenuItem m" +
                " where  not exists (" +
                "        select 1" +
                "        from   TestHistory x" +
                "        where  x.menuId = m.id" +
                "        and    x.status <> 'pass' " +
                "        )" +
                " order by 5, 6";

        int size = Integer.parseInt(req.getParameter("testSize"));

        List<SimulatorTest> testMenuItems = genericDao.getQueryResults(sql, size);

        // Get all menu items
        GenericDao genericDao2 = new GenericDao(MenuCategory.class);



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


        RequestDispatcher dispatcher = req.getRequestDispatcher("/testSimulator/register2.jsp");
        dispatcher.forward(req, resp);
    }

}


