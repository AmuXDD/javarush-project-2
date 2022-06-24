package ru.javarush.Island.ObjectIsland.objectLocation.Animal.Herbivores;

import ru.javarush.Island.Anotation.Emoji;
import ru.javarush.Island.ObjectIsland.objectLocation.eatObject.EatObject;

import java.util.HashMap;

@Emoji(emoji = "\uD83D\uDC17")
public class WildBoar extends Herbivores{

    {
        chanceSuccessfulHunt = new HashMap<>();
        chanceSuccessfulHunt.put(EatObject.Grass.name(), 100);
        chanceSuccessfulHunt.put(EatObject.Caterpillar.name(), 90);
        chanceSuccessfulHunt.put(EatObject.Mouse.name() , 50);
    }
    public WildBoar(int coordinatesX, int coordinatesY) {
        super(coordinatesX, coordinatesY);
        this.nameObject = "WildBoar";
        this.moveSpeed = 2;
        this.weight = 400;
        this.maxObjectCell = 50;
        this.maximumFood = 50;
        this.reproductionCount = 4;
    }
}
