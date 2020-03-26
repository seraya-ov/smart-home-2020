package ru.sbt.mipt.oop.readers;

import com.google.gson.Gson;
import ru.sbt.mipt.oop.objects.home_objects.actionable.SmartHome;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SmartHomeReader {
    public SmartHome getSmartHomeFromJson(String path) {
        try {
            Gson gson = new Gson();
            String json = new String(Files.readAllBytes(Paths.get(path)));
            return gson.fromJson(json, SmartHome.class);
        }
        catch (IOException exc) {
            System.out.println("Unable to read Smart Home from json. " + exc.getMessage());
            return null;
        }
    }
}
