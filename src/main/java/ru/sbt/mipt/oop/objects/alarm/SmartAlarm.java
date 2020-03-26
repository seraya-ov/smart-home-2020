package ru.sbt.mipt.oop.objects.alarm;

public class SmartAlarm {
    private AlarmState state;

    public SmartAlarm() {
        this.state = new DeactivatedAlarmState();
    }

    public void activate(String code) {
        state = state.activate(code);
    }

    public void deactivate(String code) {
        state = state.deactivate(code);
    }

    public void alert() {
        state = state.alert();
    }

    public boolean isActivated() {
        return (state instanceof ActivatedAlarmState);
    }

    public boolean isDeactivated() {
        return (state instanceof DeactivatedAlarmState);
    }

    public  boolean isAlert() {
        return (state instanceof AlertAlarmState);
    }
}
