package com.epam.servlets;


import com.epam.manager.EmployeeManagerServiceImpl;
import com.epam.model.UserRegister;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet ("/register")

public class UserServlet extends HttpServlet {
    private EmployeeManagerServiceImpl employeeManager = new EmployeeManagerServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String email = request.getParameter("email");



        UserRegister userRegister = new UserRegister();
        userRegister.setFirst_name(first_name);
        userRegister.setLast_name(last_name);
        userRegister.setUsername(username);
        userRegister.setPassword(password);
        userRegister.setAddress(address);
        userRegister.setEmail(email);
        employeeManager.createUser(userRegister);

        request.getRequestDispatcher("/WEB-INF/registersuccessfully.jsp").forward(request,response);
    }
}