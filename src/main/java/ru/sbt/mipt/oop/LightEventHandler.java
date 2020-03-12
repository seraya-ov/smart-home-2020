package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.LightEventType.LIGHT_ON;

public class LightEventHandler implements EventHandler{
    private final SmartHome smartHome;

    public LightEventHandler(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void handleEvent(SensorEvent event) {
        if (event instanceof LightEvent) {
            Action action = new Action((HomeObject homeObject) -> {
                if (homeObject instanceof Light && homeObject.getId().equals(event.getObjectId())) {
                    if (((LightEvent) event).getLightEventType() == LIGHT_ON) {
                        turnTheLightOn((Light) homeObject);
                    } else {
                        turnTheLightOff((Light) homeObject);
                    }
                }
            });
            smartHome.execute(action);
        }
    }

    private void turnTheLightOff(Light light) {
        light.setOn(false);
        System.out.println("Light " + light.getId()  + " was turned off.");
    }

    private void turnTheLightOn(Light light) {
        light.setOn(true);
        System.out.println("Light " + light.getId() + " was turned on.");
    }
}
