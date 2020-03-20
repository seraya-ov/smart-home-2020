package ru.sbt.mipt.oop.generators.event_generators;

import ru.sbt.mipt.oop.events.DoorEvent;
import ru.sbt.mipt.oop.events.SensorEvent;
import ru.sbt.mipt.oop.types.DoorEventType;

public class DoorEventGenerator implements EventGenerator {
    @Override
    public SensorEvent Generate(String objectId) {
        DoorEventType doorEventType = DoorEventType.values()[(int) (2 * Math.random())];
        return new DoorEvent(objectId, doorEventType);
    }
}
