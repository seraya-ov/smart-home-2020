package ru.sbt.mipt.oop;

public class LightCommands {
    public static void TurnTheLightOffCommand(Light light) {
        light.setOn(false);
        SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
        new SensorCommandSender(command).Send();
    }
}
