package ru.sbt.mipt.oop.objects.alarm;

public interface Alarm {
    Alarm activate(String code);

    Alarm deactivate(String code);

    Alarm alert();
}
