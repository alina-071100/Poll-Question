package com.epam.servlets;

import com.epam.model.Poll;
import com.epam.service.PollServiceImpl;
import com.mysql.cj.result.LocalDateTimeValueFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@WebServlet("/poll")
public class PollServlet extends HttpServlet {
//    Poll poll = new Poll();
    PollServiceImpl pollService = new PollServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        long x = System.currentTimeMillis();
//        System.out.println(((((x / 1000) / 60) / 60) / 24));
//        LocalDate.now().minus(7, ChronoUnit.DAYS);

        List<Poll> all = pollService.findAll();
        request.setAttribute("poll", all);
        request.getRequestDispatcher("/WEB-INF/loginpoll.jsp").forward(request, response);
    }

}