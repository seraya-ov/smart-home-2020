package ru.sbt.mipt.oop;

public class ObjectIdGenerator {
    public String Generate() {
        return "" + (int) (10 * Math.random());
    }
}
