package ru.javarush.Island.ObjectIsland.objectLocation.Plants;

import ru.javarush.Island.Anotation.Emoji;

@Emoji(emoji = "\uD83C\uDF3F")
public class Grass extends Plants{
    public Grass(int coordinatesX, int coordinatesY) {
        super(coordinatesX, coordinatesY);
        this.nameObject = "Grass";
        this.weight = 1;
        this.maxObjectCell = 200;
    }
}
