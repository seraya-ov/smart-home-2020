package ru.sbt.mipt.oop.objects.home_objects;

public abstract class HomeObject {
    private final String id;

    public HomeObject(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
