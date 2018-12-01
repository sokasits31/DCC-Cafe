package com.doorCreekCafe.controller;


import com.doorCreekCafe.entity.MenuCategory;
import com.doorCreekCafe.entity.MenuItem;
import com.doorCreekCafe.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        logger.debug("in simulator:menuItem");

        String answerStatus;
        HttpSession session = req.getSession();

        logger.debug("CURRENT TEST ITEM: " + session.getAttribute("currentTestMenuItem"));
        logger.debug("SELECTED ITEM: " + req.getParameter("submit"));

        if (session.getAttribute("currentTestMenuItem").equals(req.getParameter("submit"))) {
            logger.debug("correct");
        } else {
            logger.debug("incorrect");
        }



        final JFrame f= new JFrame("PopupMenu Example");
        final JPopupMenu popupmenu = new JPopupMenu("Edit");



        // Determine if selected menu item is correct

        GenericDao genericDao = new GenericDao(MenuItem.class);

        List <MenuItem> menuItems = genericDao.getByPropertyEqual("description",req.getParameter("submit"));

        MenuItem selectedItem = menuItems.get(0);


        if (selectedItem.getDescription().equals("happy")) {
            answerStatus = "You are correct";
        } else {
            answerStatus = "Need a hint?????" +  selectedItem.getDescription();
        }


        session.setAttribute("categoryId", selectedItem.getMenuCategory().getId());


        logger.debug("categoryId: " + req.getParameter("categoryId"));

        session.setAttribute("answerStatus", answerStatus);

        String url = "/doorCreekCafe/simulator";
        resp.sendRedirect(url);

    }
}


