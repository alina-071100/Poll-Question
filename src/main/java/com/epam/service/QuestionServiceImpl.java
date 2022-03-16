package com.epam.service;

import com.epam.config.DBConnectionProvider;

import com.epam.model.Question;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.epam.config.DBConnectionProvider.connection;

public class QuestionServiceImpl implements QuestionService {

    @Override
    public List<Question> findAll() {
        List<Question> listQuestionAdd = new ArrayList<>();
        try {
            String query = "SELECT * From question";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Question question = new Question();
                question.setId(resultSet.getInt("quest_id"));
                question.setText(resultSet.getString("text"));
                listQuestionAdd.add(question);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listQuestionAdd;
    }


    @Override
    public Question findById(long id) {
        Question question= new Question();

        try {
            String query = "SELECT * FROM question WHERE id = ? ";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                question.setId(resultSet.getLong("quest_id"));
                question.setText(resultSet.getString("text"));
                question.setPoll_id(resultSet.getLong("poll_id"));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return question ;
    }


    @Override
    public List<Question> findByPollId(long pollId) {
        List<Question> listQuestionAdd = new ArrayList<>();
        try {
            String query = "SELECT * FROM poll INNER JOIN question ON poll.id=question.poll_id WHERE poll_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, pollId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Question question = new Question();
                question.setId(resultSet.getLong("quest_id"));
                question.setText(resultSet.getString("text"));
                question.setPoll_id(resultSet.getLong("poll_id"));
                listQuestionAdd.add(question);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return listQuestionAdd;

    }


}
