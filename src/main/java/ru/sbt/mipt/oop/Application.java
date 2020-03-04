package ru.sbt.mipt.oop;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static ru.sbt.mipt.oop.DoorEventHandler.*;
import static ru.sbt.mipt.oop.EventGenerator.*;
import static ru.sbt.mipt.oop.LightEventHandler.*;
import static ru.sbt.mipt.oop.SensorEventType.*;
import static ru.sbt.mipt.oop.SmartHomeReader.*;

public class Application {

    public static void main(String... args) throws IOException {
        SmartHome smartHome = getSmartHome();
        SensorEvent event = getNextSensorEvent();
        while (event != null) {
            System.out.println("Got event: " + event);
            HandleLightEvent(smartHome, event);
            HandleDoorEvent(smartHome, event);
            event = getNextSensorEvent();
        }
    }
}
