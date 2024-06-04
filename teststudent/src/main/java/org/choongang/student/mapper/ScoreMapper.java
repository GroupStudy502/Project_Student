package org.choongang.student.mapper;

import org.choongang.student.controllers.SearchScore;
import org.choongang.student.entities.Score;

import java.util.List;

public interface ScoreMapper {
    // 재확인
    List<Score> getScore(SearchScore search);
    Score get(long sNo);
    int exist(long sNo);
    int register(Score score);
    int modify(Score score);
    int delete(long sNo);
}
