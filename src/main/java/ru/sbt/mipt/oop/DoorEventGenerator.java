package ru.sbt.mipt.oop;

public class DoorEventGenerator implements EventGenerator {
    @Override
    public SensorEvent Generate(String objectId) {
        DoorEventType doorEventType = DoorEventType.values()[(int) (2 * Math.random())];
        return new DoorEvent(objectId, doorEventType);
    }
}
