package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.LightEventType.LIGHT_ON;

public class LightEventHandler {

    public static void HandleLightEvent(SmartHome smartHome, SensorEvent event) {
        if (event.isLight()) {
            for (Room room : smartHome.getRooms()) {
                for (Light light : room.getLights()) {
                    CheckTheLight((LightEvent)event, room, light);
                }
            }
        }
    }

    private static void CheckTheLight(LightEvent event, Room room, Light light) {
        if (light.getId().equals(event.getObjectId())) {
            if (event.getType() == LIGHT_ON) {
                TurnTheLightOn(room, light);
            } else {
                TurnTheLightOff(room, light);
            }
        }
    }

    private static void TurnTheLightOff(Room room, Light light) {
        light.setOn(false);
        System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned off.");
    }

    private static void TurnTheLightOn(Room room, Light light) {
        light.setOn(true);
        System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned on.");
    }
}
