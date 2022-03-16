package com.epam.servlets;

import com.epam.model.Result;
import com.epam.service.ResultServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/results")

public class ResultsServlet extends HttpServlet {
    long sum = 0;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] questionIds = request.getParameterValues("questionId");
        for (String questionId : questionIds) {
            String parameter = request.getParameter("marked" + questionId);
            if (parameter == null) {
                request.setAttribute("error", "You have not filled in all the fields, try again");
                request.getRequestDispatcher("/WEB-INF/errorpage.jsp").forward(request, response);
            }
            long marked = Long.parseLong(parameter);
            sum += marked;
        }
        ResultServiceImpl resultService = new ResultServiceImpl();
        Result byScore = resultService.findByScore(1, sum/20);
        request.setAttribute("weight", byScore);
        request.getRequestDispatcher("/WEB-INF/results.jsp").forward(request, response);
    }
}