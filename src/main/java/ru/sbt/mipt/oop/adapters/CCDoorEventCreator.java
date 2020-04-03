package ru.sbt.mipt.oop.adapters;

import ru.sbt.mipt.oop.events.DoorEvent;
import ru.sbt.mipt.oop.events.SensorEvent;
import ru.sbt.mipt.oop.types.DoorEventType;

public class CCDoorEventCreator implements CCEventCreator {
    private final DoorEventType type;


    public CCDoorEventCreator(DoorEventType type) {
        this.type = type;
    }

    @Override
    public SensorEvent create(String id) {
        return new DoorEvent(id, type);
    }
}
