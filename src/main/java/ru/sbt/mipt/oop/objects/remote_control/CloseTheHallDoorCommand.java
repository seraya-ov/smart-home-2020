package ru.sbt.mipt.oop.objects.remote_control;

import ru.sbt.mipt.oop.actions.Action;
import ru.sbt.mipt.oop.events.DoorEvent;
import ru.sbt.mipt.oop.handlers.HallDoorEventHandler;
import ru.sbt.mipt.oop.objects.home_objects.Door;
import ru.sbt.mipt.oop.objects.home_objects.HomeObject;
import ru.sbt.mipt.oop.objects.home_objects.actionable.Room;
import ru.sbt.mipt.oop.objects.home_objects.actionable.SmartHome;
import ru.sbt.mipt.oop.types.DoorEventType;

import static ru.sbt.mipt.oop.commands.DoorCommands.closeTheDoorCommand;

public class CloseTheHallDoorCommand implements Command {
    private final SmartHome smartHome;

    public CloseTheHallDoorCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        Action checkTheHallDoor = (HomeObject homeObject) -> {
            if (homeObject instanceof Room && homeObject.getId().equals("hall")) {
                Action action = (HomeObject currentRoomObject) -> {
                    if (currentRoomObject instanceof Door) {
                        closeTheDoorCommand((Door) currentRoomObject);
                        DoorEvent event = new DoorEvent(currentRoomObject.getId(), DoorEventType.DOOR_CLOSED);
                        HallDoorEventHandler handler = new HallDoorEventHandler(smartHome);
                        handler.handleEvent(event);
                    }
                };
                ((Room) homeObject).execute(action);
            }
        };
        smartHome.execute(checkTheHallDoor);
    }
}
