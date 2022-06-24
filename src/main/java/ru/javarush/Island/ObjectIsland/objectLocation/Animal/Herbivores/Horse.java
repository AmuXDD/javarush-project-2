package ru.javarush.Island.ObjectIsland.objectLocation.Animal.Herbivores;

import ru.javarush.Island.Anotation.Emoji;

@Emoji(emoji = "\uD83D\uDC0E")
public class Horse extends Herbivores{

    public Horse(int coordinatesX, int coordinatesY) {
        super(coordinatesX, coordinatesY);
        this.nameObject = "Horse";
        this.moveSpeed = 4;
        this.weight = 400;
        this.maximumFood = 60;
        this.maxObjectCell = 20;
        this.reproductionCount = 2;
    }
}
