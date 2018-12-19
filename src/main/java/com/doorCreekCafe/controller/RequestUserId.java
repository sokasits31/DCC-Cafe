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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


/**
 * A simple servlet to welcome the user.
 * @author pwaite
 */

@WebServlet(
     urlPatterns = {"/requestId"}
)

public class RequestUserId extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao genericDao = new GenericDao(Role.class);

        List<Role> roles = genericDao.getByPropertyEqual("roleName", "admin");

        // Just user first admin found on system
        String userId = String.valueOf(roles.get(0).getId());

        GenericDao genericDao2 = new GenericDao(User.class);
        List<User> users = genericDao2.getByPropertyEqual("id", userId );


        req.setAttribute("email", users.get(0).getEmailAddress());
        req.setAttribute("firstName", users.get(0).getFirstName());
        req.setAttribute("lastName", users.get(0).getLastName());
        req.setAttribute("phoneNumber", users.get(0).getPrimaryPhoneNumber());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/requestUserId.jsp");
        dispatcher.forward(req, resp);
    }


}


