package ru.sbt.mipt.oop;

public class ActivatedAlarm implements Alarm {
    private String code;

    public ActivatedAlarm(String code) {
        this.code = code;
    }

    @Override
    public Alarm activate(String code) {
        return this;
    }

    @Override
    public Alarm deactivate(String code) {
        if (code.equals(this.code)) {
            return new DeactivatedAlarm();
        }
        return this.alert();
    }

    @Override
    public Alarm alert() {
        return new AlertAlarm(code);
    }
}
