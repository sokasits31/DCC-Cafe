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

        // Update menu items based on newly selected menu category
        GenericDao genericDao = new GenericDao(MenuCategory.class);
        List <MenuCategory> categories = genericDao.getByPropertyEqual("categoryDescription",req.getParameter("submit"));
        MenuCategory category = categories.get(0);   // Will always have 1 row returned

        // Update session attributes
        HttpSession session = req.getSession();
        session.setAttribute("menuCategories", genericDao.getAll());
        session.setAttribute("categoryId", category.getId());
        session.setAttribute("categoryColumn",category.getColumnPosition());
        session.setAttribute("categoryRow", category.getRowPosition());

        // Reset test answerStatus
        session.setAttribute("answerStatus", null);

        // Refresh screen
        RequestDispatcher dispatcher = req.getRequestDispatcher("/testSimulator/register2.jsp");
        dispatcher.forward(req, resp);

    }


}


