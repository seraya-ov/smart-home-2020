package ru.sbt.mipt.oop.objects.remote_control;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;

import java.util.Map;

public class SmartRemoteControlTest {
    @Mock
    ActivateTheAlarmCommand activateTheAlarmCommand = Mockito.mock(ActivateTheAlarmCommand.class);
    @Mock
    AlertAlarmCommand alertAlarmCommand = Mockito.mock(AlertAlarmCommand.class);
    @Mock
    CloseTheHallDoorCommand closeTheHallDoorCommand = Mockito.mock(CloseTheHallDoorCommand.class);
    @Mock
    TurnOffAllTheLightsCommand turnOffAllTheLightsCommand = Mockito.mock(TurnOffAllTheLightsCommand.class);
    @Mock
    TurnOnAllTheLightsCommand turnOnAllTheLightsCommand = Mockito.mock(TurnOnAllTheLightsCommand.class);

    @InjectMocks
    SmartRemoteControl smartRemoteControl;


    @Test
    public void canBeInitializedSuccessfully() {
        Map<String, Command> commandMap = Map.of(
                "A", activateTheAlarmCommand,
                "B", alertAlarmCommand,
                "C", closeTheHallDoorCommand,
                "D", turnOffAllTheLightsCommand,
                "F", turnOnAllTheLightsCommand
        );
        Map<String, Map<String, Command>> idMap = Map.of(
                "12", commandMap
        );
        smartRemoteControl = new SmartRemoteControl(idMap);
        assertNotNull(smartRemoteControl);
    }

    @Test
    public void correctOnButtonPressedCall() {
        Map<String, Command> commandMap = Map.of(
                "A", activateTheAlarmCommand,
                "B", alertAlarmCommand,
                "C", closeTheHallDoorCommand,
                "D", turnOffAllTheLightsCommand,
                "F", turnOnAllTheLightsCommand
        );
        Map<String, Map<String, Command>> idMap = Map.of(
                "12", commandMap
        );
        smartRemoteControl = new SmartRemoteControl(idMap);
        Mockito.doAnswer((Answer<Void>) invocation -> null).when(activateTheAlarmCommand).execute();
        smartRemoteControl.onButtonPressed("A", "12");

        Mockito.verify(activateTheAlarmCommand, Mockito.times(1)).execute();
    }
}