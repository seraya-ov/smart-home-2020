package ru.sbt.mipt.oop.objects.remote_control;

import ru.sbt.mipt.oop.actions.Action;
import ru.sbt.mipt.oop.events.LightEvent;
import ru.sbt.mipt.oop.handlers.LightEventHandler;
import ru.sbt.mipt.oop.objects.home_objects.HomeObject;
import ru.sbt.mipt.oop.objects.home_objects.Light;
import ru.sbt.mipt.oop.objects.home_objects.actionable.Room;
import ru.sbt.mipt.oop.objects.home_objects.actionable.SmartHome;
import ru.sbt.mipt.oop.types.LightEventType;

import static ru.sbt.mipt.oop.commands.LightCommands.turnTheLightOnCommand;

public class TurnOnTheLightsInTheHallCommand implements Command {
    private final SmartHome smartHome;

    public TurnOnTheLightsInTheHallCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        Action checkTheHallLights = (HomeObject homeObject) -> {
            if (homeObject instanceof Room && homeObject.getId().equals("hall")) {
                Action action = (HomeObject currentRoomObject) -> {
                    if (currentRoomObject instanceof Light) {
                        turnTheLightOnCommand((Light) currentRoomObject);
                        LightEvent event = new LightEvent(currentRoomObject.getId(), LightEventType.LIGHT_ON);
                        LightEventHandler handler = new LightEventHandler(smartHome);
                        handler.handleEvent(event);
                    }
                };
                ((Room) homeObject).execute(action);
            }
        };
        smartHome.execute(checkTheHallLights);
    }
}
