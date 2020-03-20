package ru.sbt.mipt.oop.handlers.sensor_event_handlers;

import ru.sbt.mipt.oop.actions.Action;
import ru.sbt.mipt.oop.events.DoorEvent;
import ru.sbt.mipt.oop.events.SensorEvent;
import ru.sbt.mipt.oop.objects.home_objects.*;
import ru.sbt.mipt.oop.objects.home_objects.actionable.Room;
import ru.sbt.mipt.oop.objects.home_objects.actionable.SmartHome;

import static ru.sbt.mipt.oop.types.DoorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.commands.LightCommands.turnTheLightOffCommand;

public class HallDoorEventHandler implements SensorEventHandler {
    private final SmartHome smartHome;

    public HallDoorEventHandler(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void handleEvent(SensorEvent event) {
        if (event instanceof DoorEvent && ((DoorEvent) event).getDoorEventType() == DOOR_CLOSED) {
            Action checkTheHallDoor = (HomeObject homeObject) -> {
               if (homeObject instanceof Room && homeObject.getId().equals("hall")) {
                   Action action = (HomeObject currentRoomObject) -> {
                       if (currentRoomObject instanceof Door && currentRoomObject.getId().equals(event.getObjectId())) {
                           turnOffAllTheLights();
                       }
                   };
                   ((Room) homeObject).execute(action);
               }
            };
            smartHome.execute(checkTheHallDoor);
        }
    }

    private void turnOffAllTheLights() {
        Action action = (HomeObject homeObject) -> {
            if (homeObject instanceof Light) {
                turnTheLightOffCommand((Light) homeObject);
            }
        };
        smartHome.execute(action);
    }
}
