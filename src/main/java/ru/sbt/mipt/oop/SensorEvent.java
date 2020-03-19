package ru.sbt.mipt.oop;

public abstract class SensorEvent {
    private final String objectId;
    private final ObjectType type;

    public SensorEvent(String objectId, ObjectType type) {
        this.objectId = objectId;
        this.type = type;
    }

    public String getObjectId() {
        return objectId;
    }

    public ObjectType getType() {
        return type;
    }
}
