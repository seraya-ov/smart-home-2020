package ru.sbt.mipt.oop.application;

import ru.sbt.mipt.oop.events.SensorEvent;
import ru.sbt.mipt.oop.generators.NextSensorEventGenerator;
import ru.sbt.mipt.oop.handlers.sensor_event_handlers.SensorEventHandler;

import java.util.List;

public class EventSequence {
    private final NextSensorEventGenerator nextSensorEventGenerator;
    private final List<SensorEventHandler> sensorEventHandlers;

    public EventSequence(NextSensorEventGenerator nextSensorEventGenerator, List<SensorEventHandler> sensorEventHandlers) {
        this.nextSensorEventGenerator = nextSensorEventGenerator;
        this.sensorEventHandlers = sensorEventHandlers;
    }

    public void run() {
        SensorEvent event = nextSensorEventGenerator.getNextSensorEvent();
        while (event != null) {
            System.out.println("Got event: " + event);
            for (SensorEventHandler handler: sensorEventHandlers) {
                handler.handleEvent(event);
            }
            event = nextSensorEventGenerator.getNextSensorEvent();
        }
    }
}
