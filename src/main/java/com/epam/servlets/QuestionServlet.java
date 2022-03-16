package com.epam.servlets;

import com.epam.model.Answer;
import com.epam.model.Question;
import com.epam.service.AnswerServiceImpl;
import com.epam.service.QuestionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialException;
import java.io.IOException;
import java.util.List;



@WebServlet("/question")
public class QuestionServlet extends HttpServlet {

@Override

//protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//        Question question = new Question();
//        QuestionServiceImpl questionService = new QuestionServiceImpl();
//
//        long id = Long.parseLong(request.getParameter("id"));
//        question.setPoll_id(id);
//        List<Question> all = questionService.findByPollId(question.getPoll_id());
//        request.setAttribute("question", all);
//        request.getRequestDispatcher("/answer").forward(request, response);
//    }
//
//
//}
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                Question question = new Question();
                QuestionServiceImpl questionService = new QuestionServiceImpl();
                long id = Long.parseLong(request.getParameter("id"));
                question.setPoll_id(id);
                List<Question> texts = questionService.findByPollId(question.getPoll_id());
                request.setAttribute("question", texts);
                request.getRequestDispatcher("/answer").forward(request, response);
        }
}
