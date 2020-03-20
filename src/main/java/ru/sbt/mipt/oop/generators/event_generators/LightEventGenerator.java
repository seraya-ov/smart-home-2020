package ru.sbt.mipt.oop.generators.event_generators;

import ru.sbt.mipt.oop.events.LightEvent;
import ru.sbt.mipt.oop.events.SensorEvent;
import ru.sbt.mipt.oop.types.LightEventType;

public class LightEventGenerator implements EventGenerator {
    @Override
    public SensorEvent Generate(String objectId) {
        LightEventType lightEventType = LightEventType.values()[(int) (2 * Math.random())];
        return new LightEvent(objectId, lightEventType);
    }
}
