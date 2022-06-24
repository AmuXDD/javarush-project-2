package ru.javarush.Island.ObjectIsland.objectLocation.Animal.Herbivores;

import ru.javarush.Island.ObjectIsland.objectLocation.Animal.Animal;
import ru.javarush.Island.ObjectIsland.objectLocation.eatObject.EatObject;

import java.util.HashMap;

public abstract class Herbivores extends Animal {

    {
        chanceSuccessfulHunt = new HashMap<>();
        chanceSuccessfulHunt.put(EatObject.Grass.name(), 100);
    }

    public Herbivores(int coordinatesX, int coordinatesY) {
        super(coordinatesX, coordinatesY);
    }
}
