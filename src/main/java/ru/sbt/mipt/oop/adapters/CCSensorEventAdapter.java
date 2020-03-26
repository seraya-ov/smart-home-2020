package ru.sbt.mipt.oop.adapters;

import com.coolcompany.smarthome.events.CCSensorEvent;
import com.coolcompany.smarthome.events.EventHandler;
import ru.sbt.mipt.oop.events.DoorEvent;
import ru.sbt.mipt.oop.events.LightEvent;
import ru.sbt.mipt.oop.events.SensorEvent;
import ru.sbt.mipt.oop.handlers.*;
import ru.sbt.mipt.oop.handlers.decorators.AlarmSensorEventHandler;
import ru.sbt.mipt.oop.objects.alarm.SmartAlarm;
import ru.sbt.mipt.oop.objects.home_objects.actionable.SmartHome;
import ru.sbt.mipt.oop.types.DoorEventType;
import ru.sbt.mipt.oop.types.LightEventType;

import java.util.Arrays;
import java.util.List;

public class CCSensorEventAdapter implements EventHandler {
    private final SmartHome smartHome;
    private final SmartAlarm alarm;

    public CCSensorEventAdapter(SmartHome smartHome, SmartAlarm alarm) {
        this.smartHome = smartHome;
        this.alarm = alarm;
    }

    //"LightIsOn", "LightIsOff", "DoorIsOpen", "DoorIsClosed", "DoorIsLocked", "DoorIsUnlocked"
    @Override
    public void handleEvent(CCSensorEvent event) {
        String type = event.getEventType();
        SensorEvent sensorEvent = null;

        List<SensorEventHandler> sensorEventHandlers = Arrays.asList(new DoorEventHandler(smartHome), new LightEventHandler(smartHome), new HallDoorEventHandler(smartHome));
        List<SensorEventHandler> handlers = Arrays.asList(new AlarmSensorEventHandler(alarm, sensorEventHandlers), new AlarmEventHandler(alarm));

        switch (type) {
            case "LightIsOn":
                sensorEvent = new LightEvent(event.getObjectId(), LightEventType.LIGHT_ON);
                break;
            case "LightIsOff":
                sensorEvent = new LightEvent(event.getObjectId(), LightEventType.LIGHT_OFF);
                break;
            case "DoorIsOpen":
                sensorEvent = new DoorEvent(event.getObjectId(), DoorEventType.DOOR_OPEN);
                break;
            case "DoorIsClosed":
                sensorEvent = new DoorEvent(event.getObjectId(), DoorEventType.DOOR_CLOSED);
                break;
        }

        for (SensorEventHandler handler: handlers) {
            handler.handleEvent(sensorEvent);
        }
    }
}
