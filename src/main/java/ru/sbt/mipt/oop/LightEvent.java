package ru.sbt.mipt.oop;

public class LightEvent extends SensorEvent{
    private final LightEventType lightEventType;

    public LightEvent(String objectId, LightEventType lightEventType) {
        super(objectId);
        this.lightEventType = lightEventType;
    }

    public LightEventType getType() {
        return lightEventType;
    }

    @Override
    public String toString() {
        return "LightEvent{" +
                "lightEventType=" + lightEventType +
                ", objectId=" + super.getObjectId() +
                '}';
    }

    @Override
    public boolean isDoor() {
        return false;
    }

    @Override
    public boolean isLight() {
        return true;
    }
}
