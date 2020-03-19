package ru.sbt.mipt.oop;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String... args) {
        SmartHome smartHome = new SmartHomeReader().getSmartHomeFromJson("output.js");
        NextSensorEventGenerator nextSensorEventGenerator = new NextSensorEventGenerator();
        List<EventHandler> eventHandlers = Arrays.asList(new DoorEventHandler(smartHome), new LightEventHandler(smartHome), new HallDoorEventHandler(smartHome));
        new EventSequence(nextSensorEventGenerator, eventHandlers).run();
    }
}
