package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.DoorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.LightCommands.TurnTheLightOffCommand;

public class HallDoorEventHandler implements EventHandler {
    private final SmartHome smartHome;

    public HallDoorEventHandler(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void HandleEvent(SensorEvent event) {
        if (event.isDoor() && ((DoorEvent) event).getType() == DOOR_CLOSED) {
            Room room = findTheRoom(event);
            if (room != null && room.getName().equals("hall")) {
                TurnOffAllTheLights();
            }
        }
    }

    private void TurnOffAllTheLights() {
        for (Room homeRoom : smartHome.getRooms()) {
            for (Light light : homeRoom.getLights()) {
                TurnTheLightOffCommand(light);
            }
        }
    }

    private Room findTheRoom(SensorEvent event) {
        for (Room room : this.smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(event.getObjectId())) {
                    return room;
                }
            }
        }
        return null;
    }
}
