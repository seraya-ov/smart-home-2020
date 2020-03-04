package ru.sbt.mipt.oop;

public class DoorEventGenerator {
    public static SensorEvent GenerateDoorEvent(String objectId) {
        DoorEventType doorEventType = DoorEventType.values()[(int) (2 * Math.random())];
        return new DoorEvent(objectId, doorEventType);
    }
}
