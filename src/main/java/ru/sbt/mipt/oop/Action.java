package ru.sbt.mipt.oop;

import java.util.function.Consumer;

public class Action {
    private final Consumer<HomeObject> action;

    public Action(Consumer<HomeObject> action) {
        this.action = action;
    }

    public Consumer<HomeObject> getAction() {
        return action;
    }
}
