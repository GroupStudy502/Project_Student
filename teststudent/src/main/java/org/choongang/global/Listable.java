package org.choongang.global;

import java.util.List;

public interface Listable<T, R> {
    default List<R> getList(T search) { return null; } ;
    default List<R> getList() { return null; };
}
