package ru.sbt.mipt.oop;

public interface EventHandler {
    boolean isDoorEvent = false;
    boolean isLightEvent = false;
    void HandleEvent(SmartHome smartHome, SensorEvent event);
    boolean isDoor();
    boolean isLight();
}
