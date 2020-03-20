package ru.sbt.mipt.oop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ru.sbt.mipt.oop.actions.Action;
import ru.sbt.mipt.oop.objects.home_objects.actionable.Room;
import ru.sbt.mipt.oop.objects.home_objects.actionable.SmartHome;

import java.util.ArrayList;
import java.util.Collections;

@RunWith(MockitoJUnitRunner.class)
public class SmartHomeTest {
    @Mock
    Action action;
    @Mock
    Room room;

    @InjectMocks
    SmartHome smartHome;


    @Test
    public void executeEmptyHome() {
        smartHome = new SmartHome();
        smartHome.execute(action);
    }

    @Test
    public void executeNotEmptyHome() {
        smartHome = new SmartHome(new ArrayList<>(Collections.singletonList(room)));
        smartHome.execute(action);
    }
}