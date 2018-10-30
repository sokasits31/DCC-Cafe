package com.doorCreekCafe.controller;


import com.doorCreekCafe.entity.Role;
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
     urlPatterns = {"/admin/userInsertStatus"}
)

public class UserDBInsert extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao genericDao = new GenericDao(User.class);
        // set default status of update
        String statusOfUpdate = "fail";

        //Create User
        User newUser = new User( req.getParameter("emailAddress"),
                req.getParameter("firstName"),
                req.getParameter("lastName"),
                Integer.parseInt(req.getParameter("skillLevel")),
                Integer.parseInt(req.getParameter("primaryPhoneNumber")),
                req.getParameter("userName"),
                req.getParameter("userPassword"));

        //Create Role
        Role role = new Role(newUser,"role", "userName");

        // add children to parent
        newUser.addRole(role);

        // Insert record and get Id
        int id = (int) genericDao.insert(newUser);

        User insertedUser = (User) genericDao.getById(id);

        if (insertedUser.getId() == id) {
            statusOfUpdate = "Successful Insert";
        }

        req.setAttribute("status", statusOfUpdate);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/dataBaseStatus.jsp");
        dispatcher.forward(req, resp);
    }

}


