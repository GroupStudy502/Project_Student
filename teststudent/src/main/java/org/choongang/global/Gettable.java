package org.choongang.global;

public interface Gettable<T, R> {
    R get(T data);
}
