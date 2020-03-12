package ru.sbt.mipt.oop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(MockitoJUnitRunner.class)
public class DoorEventHandlerTest {
    @Mock
    SmartHome smartHome;
    @Mock
    DoorEvent doorEvent;


    @InjectMocks
    DoorEventHandler handler;
    @InjectMocks
    Door door = new Door(true, "0");

    @Test
    public void closeTheDoor() {
        handler = new DoorEventHandler(smartHome);
        handler.handleEvent(doorEvent);
        Mockito.when(doorEvent.getObjectId()).thenReturn(door.getId());
        Mockito.when(doorEvent.getDoorEventType()).thenReturn(DoorEventType.DOOR_CLOSED);
        Mockito.doAnswer((Answer<Void>) invocation -> {
            Object[] args = invocation.getArguments();
            ((Action) args[0]).getAction().accept(door);
            return null;
        }).when(smartHome).execute(Mockito.any(Action.class));
        handler.handleEvent(doorEvent);
        assertFalse(door.isOpen());
    }

    @Test
    public void openTheDoor() {
        handler = new DoorEventHandler(smartHome);
        handler.handleEvent(doorEvent);
        Mockito.when(doorEvent.getObjectId()).thenReturn(door.getId());
        Mockito.when(doorEvent.getDoorEventType()).thenReturn(DoorEventType.DOOR_OPEN);
        Mockito.doAnswer((Answer<Void>) invocation -> {
            Object[] args = invocation.getArguments();
            ((Action) args[0]).getAction().accept(door);
            return null;
        }).when(smartHome).execute(Mockito.any(Action.class));
        handler.handleEvent(doorEvent);
        assertTrue(door.isOpen());
    }
}