package ru.sbt.mipt.oop;

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
