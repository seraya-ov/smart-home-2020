package ru.sbt.mipt.oop.adapters;

import com.coolcompany.smarthome.events.CCSensorEvent;
import com.coolcompany.smarthome.events.EventHandler;
import ru.sbt.mipt.oop.events.SensorEvent;
import ru.sbt.mipt.oop.handlers.*;
import ru.sbt.mipt.oop.handlers.decorators.AlarmSensorEventHandler;
import ru.sbt.mipt.oop.objects.alarm.SmartAlarm;
import ru.sbt.mipt.oop.objects.home_objects.actionable.SmartHome;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CCSensorEventAdapter implements EventHandler {
    private final SmartHome smartHome;
    private final SmartAlarm alarm;
    private final Map<String, CCEventCreator> map;

    public CCSensorEventAdapter(SmartHome smartHome, SmartAlarm alarm, Map<String, CCEventCreator> map) {
        this.smartHome = smartHome;
        this.alarm = alarm;
        this.map = map;
    }

    //"LightIsOn", "LightIsOff", "DoorIsOpen", "DoorIsClosed", "DoorIsLocked", "DoorIsUnlocked"
    @Override
    public void handleEvent(CCSensorEvent event) {
        String type = event.getEventType();
        if (!map.containsKey(type)) return;
        SensorEvent sensorEvent = map.get(type).create(event.getObjectId());

        List<SensorEventHandler> sensorEventHandlers = Arrays.asList(new DoorEventHandler(smartHome), new LightEventHandler(smartHome), new HallDoorEventHandler(smartHome));
        List<SensorEventHandler> handlers = Arrays.asList(new AlarmSensorEventHandler(alarm, sensorEventHandlers), new AlarmEventHandler(alarm));

        for (SensorEventHandler handler : handlers) {
            handler.handleEvent(sensorEvent);
        }
    }
}
