package com.epam.service;

import com.epam.model.Question;

import java.util.List;

public interface QuestionService extends PollService<Question> {

    List<Question> findByPollId(long pollId);
}
