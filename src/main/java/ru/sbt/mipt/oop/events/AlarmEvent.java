package ru.sbt.mipt.oop.events;

import ru.sbt.mipt.oop.types.AlarmEventType;

public class AlarmEvent {
    private final AlarmEventType alarmEventType;
    private final String code;

    public AlarmEvent(AlarmEventType alarmEventType, String code) {
        this.alarmEventType = alarmEventType;
        this.code = code;
    }

    public AlarmEventType getAlarmEventType() {
        return alarmEventType;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "AlarmEvent{" +
                "alarmEventType=" + alarmEventType +
                ", code='" + code + '\'' +
                '}';
    }
}
