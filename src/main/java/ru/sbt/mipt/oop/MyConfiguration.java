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

        SmartHome smartHome = new SmartHomeReader().getSmartHomeFromJson("output.js");
        SmartAlarm alarm = new SmartAlarm();

        manager.registerEventHandler(new CCSensorEventAdapter(smartHome, alarm));

        return manager;
    }
}
