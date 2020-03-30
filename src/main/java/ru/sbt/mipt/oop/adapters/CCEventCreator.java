package ru.sbt.mipt.oop.adapters;

import ru.sbt.mipt.oop.events.SensorEvent;

public interface CCEventCreator {
    SensorEvent create(String id);
}
