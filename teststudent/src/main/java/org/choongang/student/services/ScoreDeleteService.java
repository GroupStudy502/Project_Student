package org.choongang.student.services;

import org.choongang.global.Service;
import org.choongang.student.controllers.SearchScore;
import org.choongang.student.entities.Score;
import org.choongang.student.mapper.ScoreMapper;

import java.util.List;

public class ScoreDeleteService implements Service<Long> {
    private ScoreMapper mapper;
    public ScoreDeleteService(ScoreMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void process(Long sNo) {
        mapper.delete(sNo);
    }

}
