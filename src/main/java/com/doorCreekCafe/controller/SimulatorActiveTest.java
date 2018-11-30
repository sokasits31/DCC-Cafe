package com.doorCreekCafe.controller;


import com.doorCreekCafe.entity.MenuCategory;
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
import java.awt.*;
import java.io.IOException;
import java.util.List;


/**
 * A simple servlet to welcome the user.
 * @author pwaite
 */

@WebServlet(
      name = "simulatorTestServlet",
      urlPatterns = {"/simulator/test/continue"}
)

public class SimulatorActiveTest extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao genericDao = new GenericDao(MenuCategory.class);

        List <MenuCategory> categories = genericDao.getByPropertyEqual("categoryDescription",req.getParameter("submit"));

        MenuCategory category = categories.get(0);
        logger.debug("category is... " +  req.getParameter("submit"));
        logger.debug("id is.........." + category.getId());

        HttpSession session = req.getSession();
        session.setAttribute("menuCategories", genericDao.getAll());
        session.setAttribute("categoryId", category.getId());
        session.setAttribute("categoryColumn",category.getColumnPosition());
        session.setAttribute("categoryRow", category.getRowPosition());
        session.setAttribute("answerStatus",null);

        //String url = "/doorCreekCafe/simulator/test/continue";
        //resp.sendRedirect(url);

        //req.setAttribute("menuCategories", genericDao.getAll());
        //req.setAttribute("categoryId", category.getId());
        //req.setAttribute("categoryColumn", category.getColumnPosition());
        //req.setAttribute("categoryRow", category.getRowPosition());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/testSimulator/register2.jsp");
        dispatcher.forward(req, resp);

    }


}


