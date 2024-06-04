package org.choongang.global;

public interface ServiceLocator {
    default Service find(Menu menu) { return null; };
    default Service findUpdate(Menu menu) { return null; };
    default Service findInsert(Menu menu) { return null; };
    default Service findDelete(Menu menu) { return null; };
}