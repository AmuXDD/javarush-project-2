package ru.javarush.Island.ObjectIsland.objectLocation.Animal.Herbivores;

import ru.javarush.Island.Anotation.Emoji;

@Emoji(emoji = "\uD83E\uDD8C")
public class Deer extends Herbivores{

    public Deer(int coordinatesX, int coordinatesY) {
        super(coordinatesX, coordinatesY);
        this.nameObject = "Deer";
        this.moveSpeed = 4;
        this.weight = 300;
        this.maxObjectCell = 20;
        this.maximumFood = 50;
        this.reproductionCount = 3;
    }
}
