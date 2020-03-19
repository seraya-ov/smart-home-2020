package ru.sbt.mipt.oop;

public abstract class HomeObject {
    private final String id;
    private final ObjectType objectType;

    public HomeObject(String id, ObjectType objectType) {
        this.id = id;
        this.objectType = objectType;
    }

    public String getId() {
        return id;
    }

    public ObjectType getObjectType() {
        return objectType;
    }
}
