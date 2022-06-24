package ru.javarush.Island.ObjectIsland.objectLocation.Animal.Herbivores;

import ru.javarush.Island.Anotation.Emoji;
import ru.javarush.Island.ObjectIsland.objectLocation.eatObject.EatObject;

import java.util.HashMap;

@Emoji(emoji = "\uD83E\uDD86")
public class Duck extends Herbivores{
    {
        chanceSuccessfulHunt = new HashMap<>();
        chanceSuccessfulHunt.put(EatObject.Grass.name(), 100);
        chanceSuccessfulHunt.put(EatObject.Caterpillar.name(), 90);
    }
    public Duck(int coordinatesX, int coordinatesY) {
        super(coordinatesX, coordinatesY);
        this.nameObject = "Duck";
        this.moveSpeed = 4;
        this.weight = 1;
        this.maxObjectCell = 200;
        this.maximumFood = 0.15;
        this.reproductionCount = 7;
    }
}
