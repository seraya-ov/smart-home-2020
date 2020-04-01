package ru.sbt.mipt.oop.objects.remote_control;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import ru.sbt.mipt.oop.actions.Action;
import ru.sbt.mipt.oop.objects.home_objects.Light;
import ru.sbt.mipt.oop.objects.home_objects.actionable.SmartHome;

import static org.junit.jupiter.api.Assertions.*;

class TurnOnAllTheLightsCommandTest {
    @Mock
    SmartHome smartHome = Mockito.mock(SmartHome.class);

    @InjectMocks
    TurnOnAllTheLightsCommand turnOnAllTheLightsCommand = new TurnOnAllTheLightsCommand(smartHome);

    @Test
    void executeWithoutDefiningSmartHome() {
        Mockito.doAnswer((Answer<Void>) invocation -> null).when(smartHome).execute(Mockito.any(Action.class));
        turnOnAllTheLightsCommand.execute();
        Mockito.verify(smartHome, Mockito.times(1)).execute(Mockito.any(Action.class));
    }

    @Test
    void executeWithDefiningSmartHomeWithOneLight() {
        Light light = new Light("0", false);

        Mockito.doAnswer((Answer<Void>) invocation -> {
            Object[] args = invocation.getArguments();
            ((Action)args[0]).accept(light);
            return null;
        }).when(smartHome).execute(Mockito.any(Action.class));

        turnOnAllTheLightsCommand.execute();
        assertTrue(light.isOn());
    }
}