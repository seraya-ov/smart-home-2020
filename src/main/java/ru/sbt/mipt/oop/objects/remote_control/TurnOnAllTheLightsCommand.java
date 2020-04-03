package ru.sbt.mipt.oop.objects.remote_control;

import ru.sbt.mipt.oop.actions.Action;
import ru.sbt.mipt.oop.events.LightEvent;
import ru.sbt.mipt.oop.handlers.LightEventHandler;
import ru.sbt.mipt.oop.objects.home_objects.HomeObject;
import ru.sbt.mipt.oop.objects.home_objects.Light;
import ru.sbt.mipt.oop.objects.home_objects.actionable.SmartHome;
import ru.sbt.mipt.oop.types.LightEventType;

import static ru.sbt.mipt.oop.commands.LightCommands.turnTheLightOnCommand;

public class TurnOnAllTheLightsCommand implements Command {
    private final SmartHome smartHome;

    public TurnOnAllTheLightsCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        Action action = (HomeObject homeObject) -> {
            if (homeObject instanceof Light) {
                turnTheLightOnCommand((Light) homeObject);
                LightEvent event = new LightEvent(homeObject.getId(), LightEventType.LIGHT_ON);
                LightEventHandler handler = new LightEventHandler(smartHome);
                handler.handleEvent(event);
            }
        };
        smartHome.execute(action);
    }
}
