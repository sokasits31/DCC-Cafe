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
     urlPatterns = {"/admin/user/update"}
)

public class UserUpdateSelect extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao genericDao = new GenericDao(User.class);
        User user = (User) genericDao.getById(Integer.parseInt(req.getParameter("userId")));

        req.setAttribute("action", req.getParameter("submit"));

        req.setAttribute("userId", user.getId());
        req.setAttribute("emailAddress" , user.getEmailAddress());
        req.setAttribute("firstName", user.getFirstName());
        req.setAttribute("lastName", user.getLastName());
        req.setAttribute("skillLevel", user.getSkillLevel());
        req.setAttribute("primaryPhoneNumber", user.getPrimaryPhoneNumber());
        req.setAttribute("userName", user.getUserName());


        RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/userUpdate.jsp");
        dispatcher.forward(req, resp);
    }

}


