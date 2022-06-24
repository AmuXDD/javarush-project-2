package ru.javarush.Island.ObjectIsland.objectLocation.Animal.Predators;

import ru.javarush.Island.Anotation.Emoji;
import ru.javarush.Island.ObjectIsland.objectLocation.eatObject.EatObject;

import java.util.HashMap;

@Emoji(emoji = "\uD83D\uDC0D")
public class Anaconda extends Predators{

    {
        chanceSuccessfulHunt = new HashMap<>();
        chanceSuccessfulHunt.put(EatObject.Fox.name(), 15);
        chanceSuccessfulHunt.put(EatObject.Rabbit.name(), 20);
        chanceSuccessfulHunt.put(EatObject.Mouse.name(), 40);
        chanceSuccessfulHunt.put(EatObject.Duck.name(), 10);
    }
    public Anaconda(int coordinatesX, int coordinatesY) {
        super(coordinatesX, coordinatesY);
        this.nameObject = "Anaconda";
        this.moveSpeed = 1;
        this.weight = 15;
        this.maxObjectCell = 30;
        this.maximumFood = 3;
        this.reproductionCount = 3;
    }
}
