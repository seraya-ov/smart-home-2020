package ru.sbt.mipt.oop.application;

import ru.sbt.mipt.oop.generators.NextSensorEventGenerator;
import ru.sbt.mipt.oop.handlers.sensor_event_handlers.DoorEventHandler;
import ru.sbt.mipt.oop.handlers.sensor_event_handlers.HallDoorEventHandler;
import ru.sbt.mipt.oop.handlers.sensor_event_handlers.LightEventHandler;
import ru.sbt.mipt.oop.handlers.sensor_event_handlers.SensorEventHandler;
import ru.sbt.mipt.oop.handlers.sensor_event_handlers.decorators.AlarmSensorEventHandler;
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
        List<SensorEventHandler> sensorEventHandlers = Arrays.asList(new AlarmSensorEventHandler(alarm, new DoorEventHandler(smartHome)), new AlarmSensorEventHandler(alarm, new LightEventHandler(smartHome)), new AlarmSensorEventHandler(alarm, new HallDoorEventHandler(smartHome)));
        new EventSequence(nextSensorEventGenerator, sensorEventHandlers).run();
    }
}
