package ru.sbt.mipt.oop;
import com.coolcompany.smarthome.events.SensorEventsManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.sbt.mipt.oop.adapters.CCDoorEventCreator;
import ru.sbt.mipt.oop.adapters.CCEventCreator;
import ru.sbt.mipt.oop.adapters.CCLightEventCreator;
import ru.sbt.mipt.oop.adapters.CCSensorEventAdapter;
import ru.sbt.mipt.oop.objects.alarm.SmartAlarm;
import ru.sbt.mipt.oop.objects.home_objects.actionable.SmartHome;
import ru.sbt.mipt.oop.readers.SmartHomeReader;
import ru.sbt.mipt.oop.types.DoorEventType;
import ru.sbt.mipt.oop.types.LightEventType;

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
        return new CCSensorEventAdapter(smartHome, smartAlarm, map);
    }
}
