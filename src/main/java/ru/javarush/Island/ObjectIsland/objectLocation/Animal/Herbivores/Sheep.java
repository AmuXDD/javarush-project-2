package ru.javarush.Island.ObjectIsland.objectLocation.Animal.Herbivores;

import ru.javarush.Island.Anotation.Emoji;

@Emoji(emoji = "\uD83D\uDC11")
public class Sheep extends Herbivores{
    public Sheep(int coordinatesX, int coordinatesY) {
        super(coordinatesX, coordinatesY);
        this.nameObject = "Sheep";
        this.moveSpeed = 3;
        this.weight = 70;
        this.maxObjectCell = 140;
        this.maximumFood = 15;
        this.reproductionCount = 4;
    }
}
