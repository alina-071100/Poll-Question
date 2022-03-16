package com.epam.service;

import com.epam.model.Answer;

import java.util.List;

public interface AnswerService extends PollService<Answer> {

    List<Answer> findByQuestionId(long questionId);
}
