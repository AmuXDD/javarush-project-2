package ru.javarush.Island.ObjectIsland.objectLocation.Animal.Herbivores;

import ru.javarush.Island.Anotation.Emoji;

@Emoji(emoji = "\uD83D\uDC02")
public class Buffalo extends Herbivores {


    public Buffalo(int coordinatesX, int coordinatesY) {
        super(coordinatesX, coordinatesY);
        this.nameObject = "Buffalo";
        this.moveSpeed = 3;
        this.weight = 700;
        this.maxObjectCell = 10;
        this.maximumFood = 100;
        this.reproductionCount = 2;
    }

}
