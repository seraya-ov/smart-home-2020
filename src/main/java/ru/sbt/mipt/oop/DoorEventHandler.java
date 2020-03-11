package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.DoorEventType.*;
import static ru.sbt.mipt.oop.ObjectType.DOOR;

public class DoorEventHandler implements EventHandler {
    private final SmartHome smartHome;

    public DoorEventHandler(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void handleEvent(SensorEvent event) {
        if (event.getType() == DOOR) {
            Action action = new Action((HomeObject homeObject) -> {
                if (homeObject.getObjectType() == DOOR && homeObject.getId().equals(event.getObjectId())) {
                    if (((DoorEvent) event).getDoorEventType() == DOOR_OPEN) {
                        OpenTheDoor((Door) homeObject);
                    } else {
                        CloseTheDoor((Door) homeObject);
                    }
                }
            });
            smartHome.execute(action);
        }
    }

    private void CloseTheDoor(Door door) {
        door.setOpen(false);
        System.out.println("Door " + door.getId()  + " was closed.");
    }

    private void OpenTheDoor(Door door) {
        door.setOpen(true);
        System.out.println("Door " + door.getId()  + " was opened.");
    }
}
