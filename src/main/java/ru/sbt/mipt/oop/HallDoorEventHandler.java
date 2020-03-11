package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.DoorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.LightCommands.TurnTheLightOffCommand;
import static ru.sbt.mipt.oop.ObjectType.DOOR;
import static ru.sbt.mipt.oop.ObjectType.LIGHT;

public class HallDoorEventHandler implements EventHandler {
    private final SmartHome smartHome;

    public HallDoorEventHandler(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void HandleEvent(SensorEvent event) {
        if (event.getType() == DOOR && ((DoorEvent) event).getDoorEventType() == DOOR_CLOSED) {
            Action action = new Action((HomeObject homeObject) -> {
                if (homeObject.getObjectType() == DOOR && homeObject.getId().equals(event.getObjectId())) {
                    TurnOffAllTheLights();
                }
            });
            for (Room room : this.smartHome.getRooms()) {
                if (room.getName().equals("hall")) {
                    room.execute(action);
                }
            }
        }
    }

    private void TurnOffAllTheLights() {
        Action action = new Action((HomeObject homeObject) -> {
            if (homeObject.getObjectType() == LIGHT) {
                TurnTheLightOffCommand((Light) homeObject);
            }
        });
        smartHome.execute(action);
    }
}
