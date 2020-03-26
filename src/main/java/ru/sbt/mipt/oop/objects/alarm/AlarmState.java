package ru.sbt.mipt.oop.objects.alarm;

public interface AlarmState {
    AlarmState activate(String code);

    AlarmState deactivate(String code);

    AlarmState alert();
}
