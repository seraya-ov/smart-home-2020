package ru.sbt.mipt.oop.adapters;

import ru.sbt.mipt.oop.events.LightEvent;
import ru.sbt.mipt.oop.events.SensorEvent;
import ru.sbt.mipt.oop.types.LightEventType;

public class CCLightEventCreator implements CCEventCreator {
    private final LightEventType type;


    public CCLightEventCreator(LightEventType type) {
        this.type = type;
    }


    @Override
    public SensorEvent create(String id) {
        return new LightEvent(id, type);
    }
}
