package ru.sbt.mipt.oop;

public class ObjectIdGenerator {
    public static String GenerateObjectId() {
        return "" + (int) (10 * Math.random());
    }
}
