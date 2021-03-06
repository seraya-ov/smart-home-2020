package ru.sbt.mipt.oop.application;

import com.coolcompany.smarthome.events.SensorEventsManager;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import rc.RemoteControlRegistry;
import ru.sbt.mipt.oop.MyConfiguration;

public class Application {
    public static void main(String... args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
        SensorEventsManager sensorEventsManager = context.getBean(SensorEventsManager.class);
        RemoteControlRegistry remoteControlRegistry = context.getBean(RemoteControlRegistry.class);
        sensorEventsManager.start();
    }
}
