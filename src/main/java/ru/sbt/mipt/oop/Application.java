package ru.sbt.mipt.oop;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String... args) throws IOException {
        SmartHome smartHome = new SmartHomeReader().getSmartHomeFromJson("output.js");
        NextSensorEventGenerator nextSensorEventGenerator = new NextSensorEventGenerator();
        List<EventHandler> eventHandlers = Arrays.asList(new DoorEventHandler(smartHome), new LightEventHandler(smartHome), new HallDoorEventHandler(smartHome));
        new EventSequence(nextSensorEventGenerator, eventHandlers).Run();
    }
}
