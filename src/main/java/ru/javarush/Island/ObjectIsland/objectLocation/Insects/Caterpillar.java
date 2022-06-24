package ru.javarush.Island.ObjectIsland.objectLocation.Insects;

import ru.javarush.Island.Anotation.Emoji;
import ru.javarush.Island.ObjectIsland.objectLocation.eatObject.EatObject;

import java.util.HashMap;

@Emoji(emoji = "\uD83D\uDC1B")
public class Caterpillar extends Insects{

    {
        chanceSuccessfulHunt = new HashMap<>();
        chanceSuccessfulHunt.put(EatObject.Grass.name(), 100);
    }
    public Caterpillar(int coordinatesX, int coordinatesY) {
        super(coordinatesX, coordinatesY);
        this.nameObject = "Caterpillar";
        this.weight = 0.01;
        this.maxObjectCell = 1000;
        this.reproductionCount = 1;
    }

    @Override
    public void move() {
        //не двигаенться
    }
}
