package ru.sbt.mipt.oop;

public class LightEventGenerator implements EventGenerator {
    @Override
    public SensorEvent Generate(String objectId) {
        LightEventType lightEventType = LightEventType.values()[(int) (2 * Math.random())];
        return new LightEvent(objectId, lightEventType);
    }
}
