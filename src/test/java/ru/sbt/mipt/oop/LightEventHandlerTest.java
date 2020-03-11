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
public class LightEventHandlerTest {
    @Mock
    SmartHome smartHome;
    @Mock
    LightEvent lightEvent;


    @InjectMocks
    LightEventHandler handler;
    @InjectMocks
    Light light = new Light("0", true);

    @Test
    public void TestTurnTheLightOffEvent() {
        handler = new LightEventHandler(smartHome);
        handler.handleEvent(lightEvent);
        Mockito.when(lightEvent.getType()).thenReturn(ObjectType.LIGHT);
        Mockito.when(lightEvent.getObjectId()).thenReturn(light.getId());
        Mockito.when(lightEvent.getLightEventType()).thenReturn(LightEventType.LIGHT_OFF);
        Mockito.doAnswer((Answer<Void>) invocation -> {
            Object[] args = invocation.getArguments();
            ((Action)args[0]).getAction().accept(light);
            return null;
        }).when(smartHome).Execute(Mockito.any(Action.class));
        handler.handleEvent(lightEvent);
        assertFalse(light.isOn());
    }

    @Test
    public void TestTurnTheLightOnEvent() {
        handler = new LightEventHandler(smartHome);
        handler.handleEvent(lightEvent);
        Mockito.when(lightEvent.getType()).thenReturn(ObjectType.LIGHT);
        Mockito.when(lightEvent.getObjectId()).thenReturn(light.getId());
        Mockito.when(lightEvent.getLightEventType()).thenReturn(LightEventType.LIGHT_ON);
        Mockito.doAnswer((Answer<Void>) invocation -> {
            Object[] args = invocation.getArguments();
            ((Action)args[0]).getAction().accept(light);
            return null;
        }).when(smartHome).Execute(Mockito.any(Action.class));
        handler.handleEvent(lightEvent);
        assertTrue(light.isOn());
    }
}