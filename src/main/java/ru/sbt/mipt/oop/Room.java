package ru.sbt.mipt.oop;

import java.util.Collection;

import static ru.sbt.mipt.oop.ObjectType.ROOM;

public class Room extends HomeObject implements Actionable {
    private Collection<Light> lights;
    private Collection<Door> doors;
    private String name;

    public Room(Collection<Light> lights, Collection<Door> doors, String name) {
        super(name, ROOM);
        this.lights = lights;
        this.doors = doors;
        this.name = name;
    }

    public Collection<Light> getLights() {
        return lights;
    }

    public Collection<Door> getDoors() {
        return doors;
    }

    public String getName() {
        return name;
    }

    @Override
    public void execute(Action action) {
        action.getAction().accept(this);
        for (Door door : doors) {
            action.getAction().accept(door);
        }
        for (Light light : lights) {
            action.getAction().accept(light);
        }
    }

}
