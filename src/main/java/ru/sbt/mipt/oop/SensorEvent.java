package ru.sbt.mipt.oop;

public abstract class SensorEvent implements EventHandler {
    private final String objectId;

    public SensorEvent(String objectId) {
        this.objectId = objectId;
    }

    public String getObjectId() {
        return objectId;
    }

}
