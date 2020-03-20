package ru.sbt.mipt.oop;

public interface Alarm {
    Alarm activate(String code);

    Alarm deactivate(String code);

    Alarm alert();
}
