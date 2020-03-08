package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.LightEventType.LIGHT_ON;

public class LightEventHandler implements EventHandler{
    private final SmartHome smartHome;

    public LightEventHandler(SmartHome smartHome) {
        this.smartHome = smartHome; //
    }

    @Override
    public void HandleEvent(SensorEvent event) {
        if (event.isLight()) {
            Room room = findTheRoom(event);
            Light light = findTheLight(event);
            if (light == null || room == null) {
                return;
            }
            if (((LightEvent) event).getType() == LIGHT_ON) {
                TurnTheLightOn(room, light);
            } else {
                TurnTheLightOff(room, light);
            }
        }
    }

    private Light findTheLight(SensorEvent event) {
        for (Room room : this.smartHome.getRooms()) {
            for (Light light : room.getLights()) {
                if (light.getId().equals(event.getObjectId())) {
                    return light;
                }
            }
        }
        return null;
    }

    private Room findTheRoom(SensorEvent event) {
        for (Room room : this.smartHome.getRooms()) {
            for (Light light : room.getLights()) {
                if (light.getId().equals(event.getObjectId())) {
                    return room;
                }
            }
        }
        return null;
    }

    private void TurnTheLightOff(Room room, Light light) {
        light.setOn(false);
        System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned off.");
    }

    private void TurnTheLightOn(Room room, Light light) {
        light.setOn(true);
        System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned on.");
    }
}
