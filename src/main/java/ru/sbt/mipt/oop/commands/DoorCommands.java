package ru.sbt.mipt.oop.commands;

import ru.sbt.mipt.oop.objects.home_objects.Door;
import ru.sbt.mipt.oop.senders.SensorCommandSender;
import ru.sbt.mipt.oop.types.CommandType;

public class DoorCommands {
    public static void closeTheDoorCommand(Door door) {
        door.setOpen(false);
        SensorCommand command = new SensorCommand(CommandType.DOOR_CLOSED, door.getId());
        new SensorCommandSender(command).Send();
    }
}
