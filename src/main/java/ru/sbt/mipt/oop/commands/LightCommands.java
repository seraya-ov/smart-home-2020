package ru.sbt.mipt.oop.commands;

import ru.sbt.mipt.oop.senders.SensorCommandSender;
import ru.sbt.mipt.oop.objects.home_objects.Light;
import ru.sbt.mipt.oop.types.CommandType;

public class LightCommands {
    public static void turnTheLightOffCommand(Light light) {
        light.setOn(false);
        SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
        new SensorCommandSender(command).Send();
    }
}
