package com.doorCreekCafe.controller;


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
     urlPatterns = {"/admin/userDelete/Status"}
)

public class UserDBDelete extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // set default status of update
        String statusOfUpdate = "fail";

        //Create User Dao
        GenericDao genericDao = new GenericDao(User.class);

        int userId = Integer.parseInt(req.getParameter("userId"));

        genericDao.delete(genericDao.getById(userId));
        if (genericDao.getById(userId) == null) {
            statusOfUpdate = "success";
        }

        req.setAttribute("status", statusOfUpdate);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/dataBaseStatus.jsp");
        dispatcher.forward(req, resp);

    }

}


