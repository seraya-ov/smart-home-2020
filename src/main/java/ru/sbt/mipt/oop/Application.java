package ru.sbt.mipt.oop;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String... args) throws IOException {
        SmartHome smartHome = new SmartHomeReader().getSmartHomeFromJson("smart-home-1.js");
        NextSensorEventGenerator nextSensorEventGenerator = new NextSensorEventGenerator();
        SensorEvent event = nextSensorEventGenerator.getNextSensorEvent();
        List<EventHandler> eventHandlers = Arrays.asList(new DoorEventHandler(smartHome), new LightEventHandler(smartHome), new HallDoorEventHandler(smartHome));
        while (event != null) {
            System.out.println("Got event: " + event);
            for (EventHandler handler: eventHandlers) {
                handler.HandleEvent(event);
            }
            event = nextSensorEventGenerator.getNextSensorEvent();
        }
    }
}
