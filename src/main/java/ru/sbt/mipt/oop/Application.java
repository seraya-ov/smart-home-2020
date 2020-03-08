package ru.sbt.mipt.oop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static ru.sbt.mipt.oop.DoorEventHandler.*;
import static ru.sbt.mipt.oop.EventGenerator.*;
import static ru.sbt.mipt.oop.LightEventHandler.*;
import static ru.sbt.mipt.oop.SmartHomeReader.*;

public class Application {

    public static void main(String... args) throws IOException {
        SmartHome smartHome = getSmartHome();
        SensorEvent event = getNextSensorEvent();
        ArrayList<EventHandler> eventHandlers = new ArrayList<>(Arrays.asList(new DoorEventHandler(), new LightEventHandler()));
        while (event != null) {
            System.out.println("Got event: " + event);
            HandleLightEvent(smartHome, event);
            HandleEvent(smartHome, event);
            event = getNextSensorEvent();
        }
    }
}
