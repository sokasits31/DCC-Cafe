package com.doorCreekCafe.controller;


import com.doorCreekCafe.entity.MenuCategory;
import com.doorCreekCafe.entity.User;
import com.doorCreekCafe.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * A simple servlet to welcome the user.
 * @author pwaite
 */

@WebServlet(
      name = "testSimulatorServlet",
      urlPatterns = {"/testSimulator/1"}
)

public class TestSimulator extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao genericDao = new GenericDao(MenuCategory.class);

        req.setAttribute("menuCategories", genericDao.getAll());
        req.setAttribute("categoryId", 1);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/testSimulator/register.jsp");
        dispatcher.forward(req, resp);
    }


}


