package ru.javarush.Island.ObjectIsland.objectLocation.Animal.Herbivores;

import ru.javarush.Island.Anotation.Emoji;

@Emoji(emoji = "\uD83D\uDC10")
public class Goat extends Herbivores{

    public Goat(int coordinatesX, int coordinatesY) {
        super(coordinatesX, coordinatesY);
        this.nameObject = "Goat";
        this.moveSpeed = 3;
        this.weight = 60;
        this.maxObjectCell = 140;
        this.maximumFood = 10;
        this.reproductionCount = 3;
    }
}
