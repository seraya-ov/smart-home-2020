package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.ObjectType.LIGHT;

public class Light extends HomeObject {
    private boolean isOn;

    public Light(String id, boolean isOn) {
        super(id, LIGHT);
        this.isOn = isOn;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }
}
