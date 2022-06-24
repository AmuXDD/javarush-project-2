package ru.javarush.Island.ObjectIsland.IslandLocation;

import ru.javarush.Island.Anotation.Emoji;
import ru.javarush.Island.Logic.Statistics;
import ru.javarush.Island.ObjectIsland.objectLocation.Animal.Herbivores.*;
import ru.javarush.Island.ObjectIsland.objectLocation.Animal.Predators.*;
import ru.javarush.Island.ObjectIsland.objectLocation.Insects.Caterpillar;
import ru.javarush.Island.ObjectIsland.objectLocation.ObjectLocation;
import ru.javarush.Island.ObjectIsland.objectLocation.Plants.Grass;

import java.util.*;

public class MyLocation {
    private Cell[][] map;

    public MyLocation(int height, int width) {
        map = new Cell[height][width];
    }

    public Cell[][] getMap() {
        return map;
    }


    public void print() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                MyLocation.Cell cell = map[i][j];
                if (cell.objectLocationsList.size() == 0) {
                    System.out.print(cell.getClass().getAnnotation(Emoji.class).emoji());
                } else {
                    System.out.print(cell.getMaxObject().getAnnotation(Emoji.class).emoji());
                }
            }
            System.out.println();
        }
        System.out.println("-----");
    }

    @Emoji(emoji = "\uD83C\uDF32")
    public class Cell {

        private String nameObject = "C";
        private int coordinatesX;
        private int coordinatesY;

        private Class<?> getMaxObject() {
            Map<Long, Class<?>> resultCount = new TreeMap<>((o1, o2) -> o2.intValue() - o1.intValue());


            long countBuffalo = objectLocationsList.stream().filter(objectLocation -> {
                if (objectLocation instanceof Buffalo) {
                    return true;
                } else return false;
            }).count();
            resultCount.put(countBuffalo, Buffalo.class);

            long countDeer = objectLocationsList.stream().filter(objectLocation -> {
                if (objectLocation instanceof Deer) {
                    return true;
                } else return false;
            }).count();
            resultCount.put(countDeer, Deer.class);

            long countDuck = objectLocationsList.stream().filter(objectLocation -> {
                if (objectLocation instanceof Duck) {
                    return true;
                } else return false;
            }).count();
            resultCount.put(countDuck, Duck.class);

            long countGoat = objectLocationsList.stream().filter(objectLocation -> {
                if (objectLocation instanceof Goat) {
                    return true;
                } else return false;
            }).count();
            resultCount.put(countGoat, Goat.class);

            long countHorse = objectLocationsList.stream().filter(objectLocation -> {
                if (objectLocation instanceof Horse) {
                    return true;
                } else return false;
            }).count();
            resultCount.put(countHorse, Horse.class);

            long countMouse = objectLocationsList.stream().filter(objectLocation -> {
                if (objectLocation instanceof Mouse) {
                    return true;
                } else return false;
            }).count();
            resultCount.put(countMouse, Mouse.class);

            long countRabbit = objectLocationsList.stream().filter(objectLocation -> {
                if (objectLocation instanceof Rabbit) {
                    return true;
                } else return false;
            }).count();
            resultCount.put(countRabbit, Rabbit.class);

            long countSheep = objectLocationsList.stream().filter(objectLocation -> {
                if (objectLocation instanceof Sheep) {
                    return true;
                } else return false;
            }).count();
            resultCount.put(countSheep, Sheep.class);

            long countWild_boar = objectLocationsList.stream().filter(objectLocation -> {
                if (objectLocation instanceof WildBoar) {
                    return true;
                } else return false;
            }).count();
            resultCount.put(countWild_boar, WildBoar.class);

            long countAnaconda = objectLocationsList.stream().filter(objectLocation -> {
                if (objectLocation instanceof Anaconda) {
                    return true;
                } else return false;
            }).count();
            resultCount.put(countAnaconda, Anaconda.class);

            long countBear = objectLocationsList.stream().filter(objectLocation -> {
                if (objectLocation instanceof Bear) {
                    return true;
                } else return false;
            }).count();
            resultCount.put(countBear, Bear.class);

            long countEagle = objectLocationsList.stream().filter(objectLocation -> {
                if (objectLocation instanceof Eagle) {
                    return true;
                } else return false;
            }).count();
            resultCount.put(countEagle, Eagle.class);

            long countFox = objectLocationsList.stream().filter(objectLocation -> {
                if (objectLocation instanceof Fox) {
                    return true;
                } else return false;
            }).count();
            resultCount.put(countFox, Fox.class);

            long countWolf = objectLocationsList.stream().filter(objectLocation -> {
                if (objectLocation instanceof Wolf) {
                    return true;
                } else return false;
            }).count();
            resultCount.put(countWolf, Wolf.class);

            long countCaterpillar = objectLocationsList.stream().filter(objectLocation -> {
                if (objectLocation instanceof Caterpillar) {
                    return true;
                } else return false;
            }).count();
            resultCount.put(countCaterpillar, Caterpillar.class);

            long countGrass = objectLocationsList.stream().filter(objectLocation -> {
                if (objectLocation instanceof Grass) {
                    return true;
                } else return false;
            }).count();
            resultCount.put(countGrass, Grass.class);

            return resultCount.entrySet().stream().findFirst().get().getValue();
        }

        private List<ObjectLocation> objectLocationsList = new ArrayList<>();

        public Cell(int coordinatesX, int coordinatesY) {
            this.coordinatesX = coordinatesX;
            this.coordinatesY = coordinatesY;
        }

        public int getCoordinatesX() {
            return coordinatesX;
        }

        public int getCoordinatesY() {
            return coordinatesY;
        }

        public List<ObjectLocation> getObjectLocationsList() {
            return objectLocationsList;
        }

        @Override
        public String toString() {
            return objectLocationsList.toString();
        }
    }
}
