package ru.sbt.mipt.oop.objects.remote_control;

import rc.RemoteControl;

import java.util.Map;

public class SmartRemoteControl implements RemoteControl {
    private final Map<String, Map<String, Command>> state;

    public SmartRemoteControl(Map<String, Map<String, Command>> state) {
        this.state = state;
    }

    @Override
    public void onButtonPressed(String buttonCode, String rcId) {
        state.get(rcId).get(buttonCode).execute();
    }
}
