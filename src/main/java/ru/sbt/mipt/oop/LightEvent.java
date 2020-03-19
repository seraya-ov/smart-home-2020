package ru.sbt.mipt.oop;

public class LightEvent extends SensorEvent{
    private final LightEventType lightEventType;

    public LightEvent(String objectId, LightEventType lightEventType) {
        super(objectId);
        this.lightEventType = lightEventType;
    }

    public LightEventType getLightEventType() {
        return lightEventType;
    }

    @Override
    public String toString() {
        return "LightEvent{" +
                "lightEventType=" + lightEventType +
                ", objectId=" + super.getObjectId() +
                '}';
    }
}
