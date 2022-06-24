package ru.javarush.Island.ObjectIsland.objectLocation.Animal.Predators;

import ru.javarush.Island.Anotation.Emoji;
import ru.javarush.Island.ObjectIsland.objectLocation.eatObject.EatObject;

import java.util.HashMap;

@Emoji(emoji = "\uD83D\uDC3A")
public class Wolf extends Predators{

    {
        this.chanceSuccessfulHunt = new HashMap<>();
        this.chanceSuccessfulHunt.put(EatObject.Horse.name() , 10);
        this.chanceSuccessfulHunt.put(EatObject.Deer.name() , 15);
        this.chanceSuccessfulHunt.put(EatObject.Rabbit.name() , 60);
        this.chanceSuccessfulHunt.put(EatObject.Mouse.name() , 80);
        this.chanceSuccessfulHunt.put(EatObject.Goat.name() , 60);
        this.chanceSuccessfulHunt.put(EatObject.Sheep.name() , 70);
        this.chanceSuccessfulHunt.put(EatObject.WildBoar.name() , 15);
        this.chanceSuccessfulHunt.put(EatObject.Buffalo.name() , 10);
        this.chanceSuccessfulHunt.put(EatObject.Duck.name() , 40);
    }
    public Wolf(int coordinatesX, int coordinatesY) {
        super(coordinatesX, coordinatesY);
        this.nameObject = "Wolf";
        this.moveSpeed = 2;
        this.weight = 50;
        this.maxObjectCell = 30;
        this.maximumFood = 8;
        this.reproductionCount = 3;
    }
}
