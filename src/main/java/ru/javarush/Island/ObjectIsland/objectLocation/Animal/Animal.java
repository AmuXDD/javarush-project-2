package ru.javarush.Island.ObjectIsland.objectLocation.Animal;

import ru.javarush.Island.ObjectIsland.objectLocation.ObjectLocationAnimal;


import java.util.Random;

public abstract class Animal extends ObjectLocationAnimal {
    public int moveSpeed;
    public Animal(int coordinatesX, int coordinatesY) {
        super(coordinatesX, coordinatesY);
    }

    @Override
    public void move() {
        int tempCordX = getRandomNumberUsingNextInt();
        int tempCordY = getRandomNumberUsingNextInt();

        if (tempCordX < 0 && tempCordY < 0) {
            this.coordinatesX += moveSpeed;
        } else if (tempCordX == 0 && tempCordY == 0) {
            this.coordinatesX -= moveSpeed;
        } else if (tempCordX == 0 && tempCordY < 0) {
            this.coordinatesY += moveSpeed;
        } else if (tempCordX < 0 && tempCordY == 0) {
            this.coordinatesY -= moveSpeed;
        }
        this.satiety -= 5;
    }

    private int getRandomNumberUsingNextInt(){
        int max = 1;
        int min = -1;
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }



}
