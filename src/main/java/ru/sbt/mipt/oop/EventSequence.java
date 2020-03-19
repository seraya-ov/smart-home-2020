package ru.sbt.mipt.oop;

import java.util.List;

public class EventSequence {
    private final NextSensorEventGenerator nextSensorEventGenerator;
    private final List<EventHandler> eventHandlers;

    public EventSequence(NextSensorEventGenerator nextSensorEventGenerator, List<EventHandler> eventHandlers) {
        this.nextSensorEventGenerator = nextSensorEventGenerator;
        this.eventHandlers = eventHandlers;
    }

    public void Run() {
        SensorEvent event = nextSensorEventGenerator.getNextSensorEvent();
        while (event != null) {
            System.out.println("Got event: " + event);
            for (EventHandler handler: eventHandlers) {
                handler.handleEvent(event);
            }
            event = nextSensorEventGenerator.getNextSensorEvent();
        }
    }
}
