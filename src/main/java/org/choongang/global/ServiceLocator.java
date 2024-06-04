package org.choongang.global;

public interface ServiceLocator {
    Service find(Menu menu);

    Service findUpdate(Menu menu);
}