package ru.javarush.Island.ObjectIsland.objectLocation.Animal.Predators;

import ru.javarush.Island.Anotation.Emoji;
import ru.javarush.Island.ObjectIsland.objectLocation.eatObject.EatObject;

import java.util.HashMap;

@Emoji(emoji = "\uD83E\uDD85")
public class Eagle extends Predators{
    {
        chanceSuccessfulHunt = new HashMap<>();
        chanceSuccessfulHunt.put(EatObject.Fox.name(), 10);
        chanceSuccessfulHunt.put(EatObject.Rabbit.name(), 90);
        chanceSuccessfulHunt.put(EatObject.Mouse.name(), 90);
        chanceSuccessfulHunt.put(EatObject.Duck.name(), 80);
    }
    public Eagle(int coordinatesX, int coordinatesY) {
        super(coordinatesX, coordinatesY);
        this.nameObject = "Eagle";
        this.moveSpeed = 3;
        this.weight = 6;
        this.maxObjectCell = 20;
        this.maximumFood = 1;
        this.reproductionCount = 4;
    }
}
