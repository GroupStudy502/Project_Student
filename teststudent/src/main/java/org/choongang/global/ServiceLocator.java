package org.choongang.global;

public interface ServiceLocator {
    Service find(Menu menu);
    Service findUpdate(Menu menu);
    Service findInsert(Menu menu);
    Service findDelete(Menu menu);
}