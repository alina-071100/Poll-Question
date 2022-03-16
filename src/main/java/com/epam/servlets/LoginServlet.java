package com.epam.servlets;

import com.epam.manager.EmployeeManagerServiceImpl;
import com.epam.manager.LoginManager;
import com.epam.model.Poll;
import com.epam.model.UserRegister;
import com.epam.service.PollServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    EmployeeManagerServiceImpl employeeManager = new EmployeeManagerServiceImpl();
    UserRegister userRegister = new UserRegister();
    PollServiceImpl pollService = new PollServiceImpl();

@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
        response.setContentType("text/html");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        userRegister.setUsername(username);
        userRegister.setPassword(password);
//
//    if (employeeManager.getByUsernameAndPassword(userRegister)) {
//        HttpSession session = request.getSession();
//        session.setAttribute("username", username);
//        session.setAttribute("password", password);
//        response.sendRedirect("loginpoll.jsp");
//    } else {
//        response.sendRedirect("/");
//    }
    if (employeeManager.getByUsernameAndPassword(userRegister)) {
        HttpSession session = request.getSession();
        session.setAttribute("username", username);
        session.setAttribute("password", password);
        List<UserRegister> allUser = employeeManager.getAll();
//        request.getSession().setAttribute("user", allUser);

        for (UserRegister userRegister1 : allUser) {
            if (username.equals(userRegister1.getUsername())) {
                request.getSession().setAttribute("user", userRegister1);
                break;
            }

        }

//        List<Poll> all = pollService.findAll();
//        request.setAttribute("all", all);
//        request.getRequestDispatcher("/poll").forward(request, response);
    }
        response.sendRedirect("/poll");

    }
}

