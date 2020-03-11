package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.ObjectType.DOOR;

public class Door extends HomeObject{
    private boolean isOpen;

    public Door(boolean isOpen, String id) {
        super(id, DOOR);
        this.isOpen = isOpen;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }
}
