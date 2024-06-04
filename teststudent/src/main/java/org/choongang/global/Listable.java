package org.choongang.global;


import org.choongang.student.controllers.SearchScore;
import org.choongang.student.entities.Score;

import java.util.List;

public interface Listable<T, R> {
    default List<R> getList(T search) { return null; } ;
    default List<R> getList() { return null; };

    List<Score> getScore(SearchScore search);
}
