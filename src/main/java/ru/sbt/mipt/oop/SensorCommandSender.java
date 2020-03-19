package ru.sbt.mipt.oop;

public class SensorCommandSender {
    private final SensorCommand command;

    public SensorCommandSender(SensorCommand command) {
        this.command = command;
    }

    public void Send() {
        System.out.println("Pretend we're sending command " + this.command);
    }
}
