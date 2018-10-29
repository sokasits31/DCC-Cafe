package com.doorCreekCafe.controller;


import com.doorCreekCafe.entity.User;
import com.doorCreekCafe.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * A simple servlet to welcome the user.
 * @author pwaite
 */

@WebServlet(
     urlPatterns = {"/admin/userUpdateStatus"}
)

public class UserUpdate extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String statusOfUpdate = "fail";


        GenericDao genericDao = new GenericDao(User.class);

        String updateNeeded = req.getParameter("submit");

        if (updateNeeded.equals("delete")) {
            int id = Integer.parseInt(req.getParameter("removeUserId"));
            genericDao.delete(genericDao.getById(id));

            if (genericDao.getById(id) == null) {
                statusOfUpdate = "success";
            }

        }

        req.setAttribute("status", statusOfUpdate);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/userUpdateStatus.jsp");
        dispatcher.forward(req, resp);



    }

}


