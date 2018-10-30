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
     urlPatterns = {"/admin/userUpdate/select/status"}
)

public class UserDBUpdate extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String statusOfUpdate = "fail";
        GenericDao genericDao = new GenericDao(User.class);



        int userId = Integer.parseInt(req.getParameter("userId"));

        if (req.getParameter("submit").equals("Delete")) {

            genericDao.delete(genericDao.getById(userId));
            if (genericDao.getById(userId) == null) {
                statusOfUpdate = "success";
            }

        } else {
            //Create User Dao

            User user = (User) genericDao.getById(userId);

            user.setEmailAddress(req.getParameter("emailAddress"));
            user.setFirstName(req.getParameter("firstName"));
            user.setLastName(req.getParameter("lastName"));
            user.setSkillLevel(Integer.parseInt(req.getParameter("skillLevel")));
            if (req.getParameter("primaryPhoneNumber") == null) {
                user.setPrimaryPhoneNumber(null);
            } else{
                user.setPrimaryPhoneNumber(Integer.parseInt(req.getParameter("primaryPhoneNumber")));
            }
            user.setFirstName(req.getParameter("userName"));

            genericDao.saveOrUpdate(user);

            statusOfUpdate = "success";
        }

        req.setAttribute("status", statusOfUpdate);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/dataBaseStatus.jsp");
        dispatcher.forward(req, resp);

    }

}


