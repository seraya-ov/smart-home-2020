package ru.sbt.mipt.oop;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static ru.sbt.mipt.oop.EventGenerator.*;
import static ru.sbt.mipt.oop.SmartHomeReader.*;

public class Application {

    public static void main(String... args) throws IOException {
        SmartHome smartHome = getSmartHome();
        SensorEvent event = getNextSensorEvent();
        List<EventHandler> eventHandlers = Arrays.asList(new DoorEventHandler(smartHome), new LightEventHandler(smartHome));
        while (event != null) {
            System.out.println("Got event: " + event);
            for (EventHandler handler: eventHandlers) {
                handler.HandleEvent(event);
            }
            event = getNextSensorEvent();
        }
    }
}
