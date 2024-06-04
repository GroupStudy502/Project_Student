package org.choongang.student.services;

import org.choongang.global.Service;
import org.choongang.student.controllers.SearchScore;
import org.choongang.student.entities.Score;
import org.choongang.student.entities.Student;
import org.choongang.student.mapper.ScoreMapper;

import java.util.List;

public class ScoreSaveService implements Service<Score> {

    private ScoreMapper mapper;

    public ScoreSaveService(ScoreMapper mapper) {
        this.mapper = mapper;
    }
    @Override
    public void process(Score form) {
        long sNo = form.getSNo();

        if (mapper.exist(sNo) > 0) { // 수정
            mapper.modify(form);
        } else {
            mapper.register(form);
        }
    }


}
