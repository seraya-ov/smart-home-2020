package ru.sbt.mipt.oop.generators;

public class ObjectIdGenerator {
    public String Generate() {
        return "" + (int) (10 * Math.random());
    }
}
