package ru.sbt.mipt.oop;

public class LightEventGenerator {
    public static SensorEvent GenerateLightEvent(String objectId) {
        LightEventType lightEventType = LightEventType.values()[(int) (2 * Math.random())];
        return new LightEvent(objectId, lightEventType);
    }
}
