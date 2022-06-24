package ru.javarush.Island.ObjectIsland.objectLocation.Animal.Herbivores;

import ru.javarush.Island.Anotation.Emoji;
import ru.javarush.Island.ObjectIsland.objectLocation.eatObject.EatObject;

import java.util.HashMap;

@Emoji(emoji = "\uD83D\uDC01")
public class Mouse extends Herbivores{

    {
        chanceSuccessfulHunt = new HashMap<>();
        chanceSuccessfulHunt.put(EatObject.Grass.name(), 100);
        chanceSuccessfulHunt.put(EatObject.Caterpillar.name(), 90);
    }
    public Mouse(int coordinatesX, int coordinatesY) {
        super(coordinatesX, coordinatesY);
        this.nameObject = "Mouse";
        this.moveSpeed = 1;
        this.weight = 0.05;
        this.maxObjectCell = 500;
        this.maximumFood = 0.01;
        this.reproductionCount = 10;
    }
}
