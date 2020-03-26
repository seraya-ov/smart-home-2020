package ru.sbt.mipt.oop.generators.event_generators;

import ru.sbt.mipt.oop.events.AlarmEvent;
import ru.sbt.mipt.oop.events.SensorEvent;
import ru.sbt.mipt.oop.types.AlarmEventType;

public class AlarmEventGenerator implements EventGenerator {
    @Override
    public SensorEvent Generate(String code) {
        AlarmEventType alarmEventType = AlarmEventType.values()[(int) (2 * Math.random())];
        return new AlarmEvent(alarmEventType, code);
    }
}
