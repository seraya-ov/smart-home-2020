package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.DoorEventType.*;
import static ru.sbt.mipt.oop.LightCommands.TurnTheLightOffCommand;

public class DoorEventHandler implements EventHandler{
    private final SmartHome smartHome;

    public DoorEventHandler(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void HandleEvent(SensorEvent event) {
        if (event.isDoor()) {
            Door door = findTheDoor(event);
            Room room = findTheRoom(event);
            if (door == null || room == null) {
                return;
            }
            if (((DoorEvent) event).getType() == DOOR_OPEN) {
                OpenTheDoor(room, door);
            } else {
                CloseTheDoor(room, door);
                HallDoorEventHandler hallDoorEventHandler = new HallDoorEventHandler(this.smartHome);
                hallDoorEventHandler.HandleEvent(event);
            }
        }
    }

    private Door findTheDoor(SensorEvent event) {
        for (Room room : this.smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(event.getObjectId())) {
                    return door;
                }
            }
        }
        return null;
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

    private void CloseTheDoor(Room room, Door door) {
        door.setOpen(false);
        System.out.println("Door " + door.getId() + " in room " + room.getName() + " was closed.");
    }

    private void OpenTheDoor(Room room, Door door) {
        door.setOpen(true);
        System.out.println("Door " + door.getId() + " in room " + room.getName() + " was opened.");
    }

    private void CheckIfTheHallDoorWasClosed(SmartHome smartHome, Room room) {
        if (room.getName().equals("hall")) {
            for (Room homeRoom : smartHome.getRooms()) {
                for (Light light : homeRoom.getLights()) {
                    TurnTheLightOffCommand(light);
                }
            }
        }
    }
}
