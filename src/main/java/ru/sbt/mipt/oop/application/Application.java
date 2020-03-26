package ru.sbt.mipt.oop.application;

import ru.sbt.mipt.oop.generators.NextSensorEventGenerator;
import ru.sbt.mipt.oop.handlers.AlarmEventHandler;
import ru.sbt.mipt.oop.handlers.DoorEventHandler;
import ru.sbt.mipt.oop.handlers.HallDoorEventHandler;
import ru.sbt.mipt.oop.handlers.LightEventHandler;
import ru.sbt.mipt.oop.handlers.SensorEventHandler;
import ru.sbt.mipt.oop.handlers.decorators.AlarmSensorEventHandler;
import ru.sbt.mipt.oop.objects.alarm.SmartAlarm;
import ru.sbt.mipt.oop.objects.home_objects.actionable.SmartHome;
import ru.sbt.mipt.oop.readers.SmartHomeReader;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String... args) {
        SmartHome smartHome = new SmartHomeReader().getSmartHomeFromJson("output.js");
        NextSensorEventGenerator nextSensorEventGenerator = new NextSensorEventGenerator();
        SmartAlarm alarm = new SmartAlarm();

        List<SensorEventHandler> sensorEventHandlers = Arrays.asList(new DoorEventHandler(smartHome), new LightEventHandler(smartHome), new HallDoorEventHandler(smartHome));
        AlarmSensorEventHandler handler = new AlarmSensorEventHandler(alarm, sensorEventHandlers);

        List<SensorEventHandler> handlers = Arrays.asList(handler, new AlarmEventHandler(alarm));
        new EventSequence(nextSensorEventGenerator, handlers).run();
    }
}
