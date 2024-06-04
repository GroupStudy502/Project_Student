package org.choongang.global;

import java.util.List;

public interface Service<T> {
    default void process(T form) {};
    default T process() {
        return null;
    }
}