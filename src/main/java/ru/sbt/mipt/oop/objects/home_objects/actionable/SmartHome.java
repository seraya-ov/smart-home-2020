package ru.sbt.mipt.oop.objects.home_objects.actionable;

import ru.sbt.mipt.oop.actions.Action;
import ru.sbt.mipt.oop.objects.alarm.AlarmState;
import ru.sbt.mipt.oop.objects.home_objects.HomeObject;

import java.util.ArrayList;
import java.util.Collection;

public class SmartHome extends HomeObject implements Actionable {
    Collection<Room> rooms;
    AlarmState alarm;

    public SmartHome() {
        super("home");
        rooms = new ArrayList<>();
    }

    public SmartHome(Collection<Room> rooms) {
        super("home");
        this.rooms = rooms;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Collection<Room> getRooms() {
        return rooms;
    }

    @Override
    public void execute(Action action) {
        action.accept(this);
        for (Room room: rooms) {
            room.execute(action);
        }
    }

}
