package ru.sbt.mipt.oop;

public class Door extends HomeObject{
    private boolean isOpen;

    public Door(boolean isOpen, String id) {
        super(id);
        this.isOpen = isOpen;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }
}
