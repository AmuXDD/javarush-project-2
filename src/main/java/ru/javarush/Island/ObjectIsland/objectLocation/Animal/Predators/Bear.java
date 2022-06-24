package ru.javarush.Island.ObjectIsland.objectLocation.Animal.Predators;

import ru.javarush.Island.Anotation.Emoji;
import ru.javarush.Island.ObjectIsland.objectLocation.eatObject.EatObject;

import java.util.HashMap;

@Emoji(emoji = "\uD83D\uDC3B")
public class Bear extends Predators{
    {
        chanceSuccessfulHunt = new HashMap<>();
        chanceSuccessfulHunt.put(EatObject.Anaconda.name(), 80);
        chanceSuccessfulHunt.put(EatObject.Horse.name(), 40);
        chanceSuccessfulHunt.put(EatObject.Deer.name(), 80);
        chanceSuccessfulHunt.put(EatObject.Rabbit.name(), 80);
        chanceSuccessfulHunt.put(EatObject.Mouse.name(), 90);
        chanceSuccessfulHunt.put(EatObject.Goat.name(), 70);
        chanceSuccessfulHunt.put(EatObject.Sheep.name(), 70);
        chanceSuccessfulHunt.put(EatObject.WildBoar.name(), 50);
        chanceSuccessfulHunt.put(EatObject.Buffalo.name(), 20);
        chanceSuccessfulHunt.put(EatObject.Duck.name(), 10);
    }
    public Bear(int coordinatesX, int coordinatesY) {
        super(coordinatesX, coordinatesY);
        this.nameObject = "Bear";
        this.moveSpeed = 2;
        this.weight = 500;
        this.maxObjectCell = 5;
        this.maximumFood = 80;
        this.reproductionCount = 2;
    }
}
