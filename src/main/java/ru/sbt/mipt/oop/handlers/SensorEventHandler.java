package ru.sbt.mipt.oop.handlers;

import ru.sbt.mipt.oop.events.SensorEvent;

public interface SensorEventHandler {
    void handleEvent(SensorEvent event);
}
