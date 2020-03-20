package ru.sbt.mipt.oop.handlers.sensor_event_handlers;

import ru.sbt.mipt.oop.events.SensorEvent;

public interface SensorEventHandler {
    void handleEvent(SensorEvent event);
}
