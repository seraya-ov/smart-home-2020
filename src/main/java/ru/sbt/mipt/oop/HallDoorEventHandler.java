package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.DoorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.LightCommands.turnTheLightOffCommand;

public class HallDoorEventHandler implements EventHandler {
    private final SmartHome smartHome;

    public HallDoorEventHandler(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void handleEvent(SensorEvent event) {
        if (event instanceof DoorEvent && ((DoorEvent) event).getDoorEventType() == DOOR_CLOSED) {
            Action checkTheHallDoor = new Action((HomeObject homeObject) -> {
               if (homeObject instanceof Room && homeObject.getId().equals("hall")) {
                   Action action = new Action((HomeObject currentRoomObject) -> {
                       if (currentRoomObject instanceof Door && currentRoomObject.getId().equals(event.getObjectId())) {
                           turnOffAllTheLights();
                       }
                   });
                   ((Room) homeObject).execute(action);
               }
            });
            smartHome.execute(checkTheHallDoor);
        }
    }

    private void turnOffAllTheLights() {
        Action action = new Action((HomeObject homeObject) -> {
            if (homeObject instanceof Light) {
                turnTheLightOffCommand((Light) homeObject);
            }
        });
        smartHome.execute(action);
    }
}
