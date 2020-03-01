package ru.sbt.mipt.oop;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static ru.sbt.mipt.oop.DoorEventHandler.*;
import static ru.sbt.mipt.oop.LightEventHandler.*;
import static ru.sbt.mipt.oop.SensorEventType.*;

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

    private static SmartHome getSmartHome() throws IOException {
        Gson gson = new Gson();
        String json = new String(Files.readAllBytes(Paths.get("smart-home-1.js")));
        return gson.fromJson(json, SmartHome.class);
    }

    private static SensorEvent getNextSensorEvent() {
        // pretend like we're getting the events from physical world, but here we're going to just generate some random events
        if (Math.random() < 0.05) return null; // null means end of event stream
        SensorEventType sensorEventType = SensorEventType.values()[(int) (2 * Math.random())];
        String objectId = "" + ((int) (10 * Math.random()));
        if (sensorEventType == LIGHT) {
            LightEventType lightEventType = LightEventType.values()[(int) (2 * Math.random())];
            return new LightEvent(objectId, lightEventType);
        }
        if (sensorEventType == DOOR) {
            DoorEventType doorEventType = DoorEventType.values()[(int) (2 * Math.random())];
            return new DoorEvent(objectId, doorEventType);
        }
        return null;
    }
}
