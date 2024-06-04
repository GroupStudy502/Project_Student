package org.choongang.student.services;

import lombok.RequiredArgsConstructor;
import org.choongang.global.Gettable;
import org.choongang.global.Listable;
import org.choongang.global.Service;
import org.choongang.student.controllers.SearchScore;




import org.choongang.student.entities.Score;
import org.choongang.student.mapper.ScoreMapper;

import java.util.List;

@RequiredArgsConstructor
public class ScoreServiceList implements Service<List<Score>>, Listable<SearchScore, Score>, Gettable<Long, Score> {
    private final ScoreMapper mapper;

    @Override
    public List<Score> getScore(SearchScore search) {
        return mapper.getScore(search);
    }
    @Override
    public Score get(Long data) {
        return mapper.get(data);
    }
}
