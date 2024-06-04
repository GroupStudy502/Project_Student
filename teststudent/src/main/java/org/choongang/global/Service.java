package org.choongang.global;

import org.choongang.student.controllers.SearchScore;
import org.choongang.student.entities.Score;

import java.util.List;

public interface Service<T> {
    default void process(T form) {};
    default T process() {
        return null;
    }

}