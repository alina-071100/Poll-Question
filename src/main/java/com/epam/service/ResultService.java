package com.epam.service;

import com.epam.model.Result;

import java.util.List;

public interface ResultService extends PollService<Result> {

    List<Result> findByPollId(long pollId);

    Result findByScore(long pollId,  long score);
}
