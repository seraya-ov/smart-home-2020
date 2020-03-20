package ru.sbt.mipt.oop;

public class DeactivatedAlarm implements Alarm {

    @Override
    public Alarm activate(String code) {
        return new ActivatedAlarm(code);
    }

    @Override
    public Alarm deactivate(String code) {
        return this;
    }

    @Override
    public Alarm alert() {
        return this;
    }
}
