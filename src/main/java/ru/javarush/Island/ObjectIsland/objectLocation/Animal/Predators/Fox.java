package ru.javarush.Island.ObjectIsland.objectLocation.Animal.Predators;

import ru.javarush.Island.Anotation.Emoji;
import ru.javarush.Island.ObjectIsland.objectLocation.eatObject.EatObject;

import java.util.HashMap;

@Emoji(emoji = "\uD83E\uDD8A")
public class Fox extends Predators{
    {
        chanceSuccessfulHunt = new HashMap<>();
        chanceSuccessfulHunt.put(EatObject.Rabbit.name(), 70);
        chanceSuccessfulHunt.put(EatObject.Mouse.name(), 90);
        chanceSuccessfulHunt.put(EatObject.Duck.name(), 60);
        chanceSuccessfulHunt.put(EatObject.Caterpillar.name(), 40);
    }
    public Fox(int coordinatesX, int coordinatesY) {
        super(coordinatesX, coordinatesY);
        this.nameObject = "Fox";
        this.moveSpeed = 2;
        this.weight = 8;
        this.maxObjectCell = 30;
        this.maximumFood = 2;
        this.reproductionCount = 6;
    }
}
