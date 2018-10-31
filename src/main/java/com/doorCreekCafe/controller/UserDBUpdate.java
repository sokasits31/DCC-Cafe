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
 * urlPatterns = {"/admin/userUpdate/select/status"}
 */



@WebServlet(
     urlPatterns = {"/admin/user/dataBaseStatus"}

)

public class UserDBUpdate extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String statusOfUpdate = "fail";
        GenericDao genericDao = new GenericDao(User.class);




        if (req.getParameter("submit").equals("Delete")) {

            int userId = Integer.parseInt(req.getParameter("userId"));

            genericDao.delete(genericDao.getById(userId));
            if (genericDao.getById(userId) == null) {
                statusOfUpdate = "Delete Successful";
            }

        } else {
            if (req.getParameter("submit").equals("Update")) {

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

            } else {

                Integer phoneNumber;
                if (req.getParameter("primaryPhoneNumber") == null) {
                    phoneNumber = null;
                } else {
                    phoneNumber = Integer.parseInt(req.getParameter("primaryPhoneNumber"));
                }



                User newUser = new User();
                newUser.setEmailAddress(req.getParameter("emailAddress"));
                newUser.setFirstName(req.getParameter("firstName"));
                newUser.setLastName(req.getParameter("lastName"));
                newUser.setSkillLevel(Integer.parseInt(req.getParameter("skillLevel")));
                newUser.setUserName(req.getParameter("userName"));
                newUser.setUserPassword("college1");

                //Create Role
                Role newRole = new Role(newUser, req.getParameter("role"), req.getParameter("userName"));

                // add children to parent
                newUser.addRole(newRole);

                // Insert record and get Id
                int id = (int) genericDao.insert(newUser);

                User insertedUser = (User) genericDao.getById(id);

                if (insertedUser.getId() == id) {
                    statusOfUpdate = "Insert Successful";
                }
            }
        }

        req.setAttribute("status", statusOfUpdate);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/dataBaseStatus.jsp");
        dispatcher.forward(req, resp);

    }

}


