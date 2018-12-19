package com.doorCreekCafe.controller;


import com.doorCreekCafe.entity.Role;
import com.doorCreekCafe.entity.User;
import com.doorCreekCafe.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
 * urlPatterns = {"/admin/userUpdate/select/status"}
 */



@WebServlet(
       urlPatterns = {"/vol/update/status"}

)

public class VolDBUpdate extends HttpServlet {


    private final Logger logger = LogManager.getLogger(this.getClass());


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String statusOfUpdate = "fail";
        GenericDao genericDao = new GenericDao(User.class);

        logger.debug("in vol db update");

        int userId = Integer.parseInt(req.getParameter("userId"));

        User user = (User) genericDao.getById(userId);

        user.setEmailAddress(req.getParameter("emailAddress"));
        user.setFirstName(req.getParameter("firstName"));
        user.setLastName(req.getParameter("lastName"));
        user.setSkillLevel(Integer.parseInt(req.getParameter("skillLevel")));
        if (req.getParameter("primaryPhoneNumber") == null) {
            user.setPrimaryPhoneNumber(null);
        } else {
            user.setPrimaryPhoneNumber(Integer.parseInt(req.getParameter("primaryPhoneNumber")));
        }
        user.setUserName(req.getParameter("userName"));

        genericDao.saveOrUpdate(user);

        statusOfUpdate = "Update Successful";


        req.setAttribute("status" , statusOfUpdate);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/vol/dataBaseStatus.jsp");
        dispatcher.forward(req, resp);

    }

}


