package ru.javarush.Island.ObjectIsland.objectLocation;

public interface Action {
    void move();
    boolean hunting(ObjectLocation objectLocation);

    boolean reproduction(ObjectLocation objectLocation);


}
