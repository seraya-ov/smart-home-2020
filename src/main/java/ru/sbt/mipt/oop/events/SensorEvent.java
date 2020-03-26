package ru.sbt.mipt.oop.events;

public abstract class SensorEvent {
    private final String objectId;

    public SensorEvent(String objectId) {
        this.objectId = objectId;
    }

    public String getObjectId() {
        return objectId;
    }
}
