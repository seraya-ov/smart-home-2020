package ru.sbt.mipt.oop;
import com.coolcompany.smarthome.events.SensorEventsManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.sbt.mipt.oop.adapters.CCSensorEventAdapter;
import ru.sbt.mipt.oop.objects.alarm.SmartAlarm;
import ru.sbt.mipt.oop.objects.home_objects.actionable.SmartHome;
import ru.sbt.mipt.oop.readers.SmartHomeReader;

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
        SmartHome smartHome = new SmartHomeReader().getSmartHomeFromJson("output.js");
        return smartHome;
    }

    @Bean
    SmartAlarm smartAlarm() {
        SmartAlarm alarm = new SmartAlarm();
        return alarm;
    }

    @Bean
    CCSensorEventAdapter ccSensorEventAdapter(SmartHome smartHome, SmartAlarm smartAlarm) {
        CCSensorEventAdapter ccSensorEventAdapter = new CCSensorEventAdapter(smartHome, smartAlarm);
        return ccSensorEventAdapter;
    }
}
