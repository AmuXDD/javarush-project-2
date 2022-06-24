package ru.javarush.Island.ObjectIsland.objectLocation;

import java.util.Map;
import java.util.Random;

public abstract class ObjectLocationAnimal extends ObjectLocation implements Action {
    public double satiety = 100;
    public boolean actionMove = true;

    public double maximumFood;

    public int reproductionCount;

    public boolean isReproductionDay = true;


    public Map<String, Integer> chanceSuccessfulHunt;


    public boolean isLive() {
        if (this.satiety <= 0) {
            return false;
        } else return true;
    }

    public ObjectLocationAnimal(int coordinatesX, int coordinatesY) {
        super(coordinatesX, coordinatesY);

    }

    @Override
    public boolean hunting(ObjectLocation objectLocation) {
        int chance = this.chanceSuccessfulHunt.get(objectLocation.nameObject);
        int random = random();
        boolean bool = false;
        if (this.satiety < 100) {
            if (chance >= random | chance == 100) {
                bool = true;
                if (this.maximumFood >= objectLocation.weight) {
                    this.satiety += objectLocation.weight;
                } else {
                    this.satiety += this.maximumFood;
                }
            }
        }

        return bool;
    }


    @Override
    public boolean reproduction(ObjectLocation objectLocation) {
        boolean isOk = false;
        ObjectLocationAnimal objectLocationAnimal = (ObjectLocationAnimal) objectLocation;
        if (this.reproductionCount != 0 && objectLocationAnimal.reproductionCount != 0) {
            if (this.satiety > 60 && objectLocationAnimal.satiety > 60) {
                this.reproductionCount--;
                objectLocationAnimal.reproductionCount--;
                this.isReproductionDay = false;
                ((ObjectLocationAnimal) objectLocation).isReproductionDay = false;
                isOk = true;
            }
        }

        return isOk;
    }

    private int random() {
        int max = 100;
        int min = 0;
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}
