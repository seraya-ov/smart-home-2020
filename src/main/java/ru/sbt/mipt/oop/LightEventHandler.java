package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.LightEventType.LIGHT_ON;
import static ru.sbt.mipt.oop.ObjectType.LIGHT;

public class LightEventHandler implements EventHandler{
    private final SmartHome smartHome;

    public LightEventHandler(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void handleEvent(SensorEvent event) {
        if (event.getType() == LIGHT) {
            Action action = new Action((HomeObject homeObject) -> {
                if (homeObject.getObjectType() == LIGHT && homeObject.getId().equals(event.getObjectId())) {
                    if (((LightEvent) event).getLightEventType() == LIGHT_ON) {
                        turnTheLightOn((Light) homeObject);
                    } else {
                        turnTheLightOff((Light) homeObject);
                    }
                }
            });
            smartHome.Execute(action);
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
