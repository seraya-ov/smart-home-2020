package ru.sbt.mipt.oop;

public class DoorEvent extends SensorEvent{
    private final DoorEventType doorEventType;

    public DoorEvent(String objectId, DoorEventType doorEventType) {
        super(objectId);
        this.doorEventType = doorEventType;
    }

    public DoorEventType getType() {
        return doorEventType;
    }

    @Override
    public String toString() {
        return "DoorEvent{" +
                "doorEventType=" + doorEventType +
                ", objectId=" + super.getObjectId() +
                '}';
    }

    @Override
    public boolean isDoor() {
        return true;
    }

    @Override
    public boolean isLight() {
        return false;
    }
}
