package ru.sbt.mipt.oop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class RoomTest {
    @Mock
    Light light;
    @Mock
    Door door;

    @InjectMocks
    Room room;


    @Test
    public void executeEmptyRoom() {
        room = new Room(new ArrayList<>(), new ArrayList<>(), "my_room");
        Action action = (HomeObject homeObject) -> {};
        room.execute(action);
    }

    @Test
    public void executeNotEmptyRoom() {
        room = new Room(new ArrayList<>(Collections.singletonList(light)), new ArrayList<>(Collections.singletonList(door)), "my_room");
        final int[] calls_cnt = {0};
        Action action = (HomeObject homeObject) -> calls_cnt[0] += 1;
        room.execute(action);
        assertEquals(3, calls_cnt[0]);
    }

}