package ru.javarush.Island.ObjectIsland.objectLocation.Animal.Herbivores;

import ru.javarush.Island.Anotation.Emoji;

@Emoji(emoji = "\uD83D\uDC07")
public class Rabbit extends Herbivores{
    public Rabbit(int coordinatesX, int coordinatesY) {
        super(coordinatesX, coordinatesY);
        this.nameObject = "Rabbit";
        this.moveSpeed = 2;
        this.weight = 2;
        this.maxObjectCell = 150;
        this.maximumFood =  0.45;
        this.reproductionCount = 12;
    }
}
