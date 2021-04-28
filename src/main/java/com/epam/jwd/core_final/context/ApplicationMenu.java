package com.epam.jwd.core_final.context;
@FunctionalInterface
public interface ApplicationMenu {

    ApplicationContext getApplicationContext();

    default Object printAvailableOptions() {
        return null;
    }

    default Object handleUserInput(Object o) {
        return null;
    }
}
