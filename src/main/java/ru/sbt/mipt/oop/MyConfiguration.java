package ru.sbt.mipt.oop;
import com.coolcompany.smarthome.events.SensorEventsManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rc.RemoteControlRegistry;
import ru.sbt.mipt.oop.adapters.CCDoorEventCreator;
import ru.sbt.mipt.oop.adapters.CCEventCreator;
import ru.sbt.mipt.oop.adapters.CCLightEventCreator;
import ru.sbt.mipt.oop.adapters.CCSensorEventAdapter;
import ru.sbt.mipt.oop.handlers.*;
import ru.sbt.mipt.oop.handlers.decorators.AlarmSensorEventHandler;
import ru.sbt.mipt.oop.objects.alarm.SmartAlarm;
import ru.sbt.mipt.oop.objects.home_objects.actionable.SmartHome;
import ru.sbt.mipt.oop.objects.remote_control.*;
import ru.sbt.mipt.oop.readers.SmartHomeReader;
import ru.sbt.mipt.oop.types.DoorEventType;
import ru.sbt.mipt.oop.types.LightEventType;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Configuration
public class MyConfiguration {
    @Bean
    SensorEventsManager sensorEventsManager() {
        SensorEventsManager manager = new SensorEventsManager();

        manager.registerEventHandler(ccSensorEventAdapter(smartHome(), smartAlarm()));

        return manager;
    }

    @Bean
    SmartHome smartHome() {
        return new SmartHomeReader().getSmartHomeFromJson("output.js");
    }

    @Bean
    SmartAlarm smartAlarm() {
        return new SmartAlarm();
    }

    @Bean
    CCSensorEventAdapter ccSensorEventAdapter(SmartHome smartHome, SmartAlarm smartAlarm) {
        Map<String, CCEventCreator> map = Map.of(
               "LightIsOn", new CCLightEventCreator(LightEventType.LIGHT_ON),
                "LightIsOff", new CCLightEventCreator(LightEventType.LIGHT_OFF),
                "DoorIsOpen", new CCDoorEventCreator(DoorEventType.DOOR_OPEN),
                "DoorIsClosed", new CCDoorEventCreator(DoorEventType.DOOR_CLOSED)
        );
        return new CCSensorEventAdapter(map, handlers(smartHome, smartAlarm));
    }

    @Bean
    List<SensorEventHandler> handlers(SmartHome smartHome, SmartAlarm alarm) {
        List<SensorEventHandler> sensorEventHandlers = Arrays.asList(new DoorEventHandler(smartHome), new LightEventHandler(smartHome), new HallDoorEventHandler(smartHome));

        return Arrays.asList(new AlarmSensorEventHandler(alarm, sensorEventHandlers), new AlarmEventHandler(alarm));
    }

    @Bean
    RemoteControlRegistry remoteControlRegistry() {
        SmartRemoteControl smartRemoteControl = smartRemoteControl(state(smartHome(), smartAlarm()));
        RemoteControlRegistry remoteControlRegistry = new RemoteControlRegistry();

        remoteControlRegistry.registerRemoteControl(smartRemoteControl, "1");

        return remoteControlRegistry;
    }

    @Bean
    SmartRemoteControl smartRemoteControl(Map<String, UniqueRemoteControl> state) {
        return new SmartRemoteControl(state);
    }

    @Bean
    Map<String, UniqueRemoteControl> state(SmartHome smartHome, SmartAlarm alarm) {
        return Map.of(
                "1", remoteControl(smartHome, alarm)
        );
    }

    @Bean
    UniqueRemoteControl remoteControl(SmartHome smartHome, SmartAlarm alarm) {
        return new UniqueRemoteControl(Map.of(
                "A", new ActivateTheAlarmCommand(alarm),
                "B", new AlertAlarmCommand(alarm),
                "C", new CloseTheHallDoorCommand(smartHome),
                "D", new TurnOffAllTheLightsCommand(smartHome),
                "F", new TurnOnAllTheLightsCommand(smartHome)
        ));
    }
}
