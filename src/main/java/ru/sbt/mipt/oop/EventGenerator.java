package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.DoorEventGenerator.*;
import static ru.sbt.mipt.oop.LightEventGenerator.*;
import static ru.sbt.mipt.oop.ObjectIdGenerator.*;
import static ru.sbt.mipt.oop.SensorEventType.DOOR;
import static ru.sbt.mipt.oop.SensorEventType.LIGHT;

public class EventGenerator {
    // pretend like we're getting the events from physical world, but here we're going to just generate some random events

    public static SensorEvent getNextSensorEvent() {
        if (Math.random() < 0.05) return null; // null means end of event stream
        SensorEventType sensorEventType = GenerateSensorEventType();
        String objectId = GenerateObjectId();
        if (sensorEventType == LIGHT) {
            return GenerateLightEvent(objectId);
        }
        if (sensorEventType == DOOR) {
            return GenerateDoorEvent(objectId);
        }
        return null;
    }

    private static SensorEventType GenerateSensorEventType() {
        return SensorEventType.values()[(int) (2 * Math.random())];
    }
}
