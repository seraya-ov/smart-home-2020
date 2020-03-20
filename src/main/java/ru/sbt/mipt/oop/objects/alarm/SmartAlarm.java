package ru.sbt.mipt.oop.objects.alarm;

public class SmartAlarm implements Alarm {
    private Alarm alarm;

    public SmartAlarm() {
        this.alarm = new DeactivatedAlarm();
    }

    @Override
    public Alarm activate(String code) {
        alarm = alarm.activate(code);
        return this;
    }

    @Override
    public Alarm deactivate(String code) {
        alarm = alarm.deactivate(code);
        return this;
    }

    @Override
    public Alarm alert() {
        alarm = alarm.alert();
        return this;
    }

    public boolean isActivated() {
        return (alarm instanceof ActivatedAlarm);
    }

    public boolean isDeactivated() {
        return (alarm instanceof DeactivatedAlarm);
    }

    public  boolean isAlert() {
        return (alarm instanceof AlertAlarm);
    }
}
