package ru.sbt.mipt.oop.generators.event_generators;

import ru.sbt.mipt.oop.events.SensorEvent;

public interface EventGenerator {
    SensorEvent Generate(String objectId);
}
