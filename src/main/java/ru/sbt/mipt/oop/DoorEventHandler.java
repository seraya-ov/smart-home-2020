package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.DoorEventType.*;
import static ru.sbt.mipt.oop.LightCommands.TurnTheLightOffCommand;

public class DoorEventHandler {
    public static void HandleEvent(SmartHome smartHome, SensorEvent event) {
        if (event.isDoor()) {
            for (Room room : smartHome.getRooms()) {
                for (Door door : room.getDoors()) {
                    CheckTheDoor(smartHome, (DoorEvent) event, room, door);
                }
            }
        }
    }

    private static void CheckTheDoor(SmartHome smartHome, DoorEvent event, Room room, Door door) {
        if (door.getId().equals(event.getObjectId())) {
            if (event.getType() == DOOR_OPEN) {
                OpenTheDoor(room, door);
            } else {
                CloseTheDoor(room, door);
                CheckIfTheHallDoorWasClosed(smartHome, room);
            }
        }
    }

    private static void CloseTheDoor(Room room, Door door) {
        door.setOpen(false);
        System.out.println("Door " + door.getId() + " in room " + room.getName() + " was closed.");
    }

    private static void OpenTheDoor(Room room, Door door) {
        door.setOpen(true);
        System.out.println("Door " + door.getId() + " in room " + room.getName() + " was opened.");
    }

    private static void CheckIfTheHallDoorWasClosed(SmartHome smartHome, Room room) {
        if (room.getName().equals("hall")) {
            for (Room homeRoom : smartHome.getRooms()) {
                for (Light light : homeRoom.getLights()) {
                    TurnTheLightOffCommand(light);
                }
            }
        }
    }
}
