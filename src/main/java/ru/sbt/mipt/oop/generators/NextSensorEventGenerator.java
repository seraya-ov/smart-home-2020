package ru.sbt.mipt.oop.generators;

import ru.sbt.mipt.oop.events.SensorEvent;
import ru.sbt.mipt.oop.generators.event_generators.DoorEventGenerator;
import ru.sbt.mipt.oop.generators.event_generators.EventGenerator;
import ru.sbt.mipt.oop.generators.event_generators.LightEventGenerator;

import java.util.Arrays;
import java.util.List;


public class NextSensorEventGenerator {
    // pretend like we're getting the events from physical world, but here we're going to just generate some random events
    public SensorEvent getNextSensorEvent() {
        if (Math.random() < 0.05) return null; // null means end of event stream
        List<EventGenerator> eventGenerators = Arrays.asList(new DoorEventGenerator(), new LightEventGenerator());
        ObjectIdGenerator objectIdGenerator = new ObjectIdGenerator();
        return eventGenerators.get((int) (2 * Math.random())).Generate(objectIdGenerator.Generate());
    }
}
