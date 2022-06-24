package ru.javarush.Island.Logic;

import ru.javarush.Island.ObjectIsland.IslandLocation.MyLocation;
import ru.javarush.Island.ObjectIsland.objectLocation.Action;
import ru.javarush.Island.ObjectIsland.objectLocation.Insects.Insects;
import ru.javarush.Island.ObjectIsland.objectLocation.ObjectLocation;
import ru.javarush.Island.ObjectIsland.objectLocation.ObjectLocationAnimal;
import ru.javarush.Island.ObjectIsland.objectLocation.Plants.Grass;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class LogicApp {

    private MyLocation location;
    Statistics statistics = Statistics.getInstance();

    public LogicApp(MyLocation location) {
        this.location = location;
    }

    public void dayIsland(MyLocation location) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
        startDay();
        endDay(location);
    }




    private void startDay() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
        for (int i = 0; i < location.getMap().length; i++) {
            for (int j = 0; j < location.getMap()[i].length; j++) {
                objectMove(location.getMap()[i][j].getObjectLocationsList());
                objectHunt(location.getMap()[i][j].getObjectLocationsList());
                reproductionObject(location.getMap()[i][j].getObjectLocationsList());

            }
        }
        respGrass();
    }

    private void objectMove(List<ObjectLocation> list) {
        Iterator<ObjectLocation> objectLocationIterator = list.listIterator();
        while (objectLocationIterator.hasNext()) {
            ObjectLocation elementNext = objectLocationIterator.next();
            if (elementNext instanceof ObjectLocationAnimal elementObject && !(elementNext instanceof Insects) && ((ObjectLocationAnimal) elementNext).actionMove) {
                if (!((ObjectLocationAnimal) elementNext).isLive()) {
                    statistics.setCountObject(statistics.getCountObject() - 1);
                    objectLocationIterator.remove();
                } else {
                    int tempX = elementNext.coordinatesX;
                    int tempY = elementNext.coordinatesY;
                    elementObject.move();
                    if ((elementNext.coordinatesX >= 0 && elementNext.coordinatesX <= location.getMap().length - 1) && (elementNext.coordinatesY >= 0 && elementNext.coordinatesY <= location.getMap()[0].length - 1)) {
                        location.getMap()[elementNext.coordinatesX][elementNext.coordinatesY].getObjectLocationsList().add(elementNext);
                        ((ObjectLocationAnimal) elementNext).actionMove = false;
                        objectLocationIterator.remove();
                    } else {
                        elementNext.coordinatesX = tempX;
                        elementNext.coordinatesY = tempY;
                        ((ObjectLocationAnimal) elementNext).actionMove = false;
                    }
                }
            }
        }
    }

    private void respGrass() {
        Random random = new Random();
        for (int i = 0; i < location.getMap().length; i++) {
            for (int j = 0; j < location.getMap()[i].length; j++) {
                if (random.nextInt(2) > 0) {
                    Grass grass = new Grass(i , j);
                    int count = random.nextInt(grass.maxObjectCell);
                    while (count > 0){
                        location.getMap()[i][j].getObjectLocationsList().add(new Grass(i, j));
                        count--;
                    }
                }
            }
        }
    }

    private void reproductionObject(List<ObjectLocation> list) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        ListIterator<ObjectLocation> objectLocationIterator = list.listIterator();
        while (objectLocationIterator.hasNext()) {
            ObjectLocation objectLocation = objectLocationIterator.next();
            long count = list.stream().filter(element -> element.nameObject.equalsIgnoreCase(objectLocation.nameObject))
                    .count();
            if (objectLocation.maxObjectCell > count){
                if (objectLocation instanceof ObjectLocationAnimal objectLocationAnimal) {
                    if (reproduction(objectLocationAnimal, list)) {
                        Class clazz = objectLocationAnimal.getClass();
                        Constructor constructor = clazz.getDeclaredConstructor(int.class, int.class);
                        ObjectLocationAnimal newObject = (ObjectLocationAnimal) constructor.newInstance(objectLocationAnimal.coordinatesX, objectLocationAnimal.coordinatesY);
                        objectLocationIterator.add(newObject);
                        newObject.isReproductionDay = false;
                        statistics.setCountObject(statistics.getCountObject() + 1);
                    }
                }
            }
        }
    }

    private boolean reproduction(ObjectLocationAnimal objectLocationAnimal, List<ObjectLocation> list) {
        boolean isOk = false;
        Optional<ObjectLocationAnimal> first = list.stream()
                .filter(listToObject -> listToObject instanceof ObjectLocationAnimal)
                .map(objectLocation -> (ObjectLocationAnimal) objectLocation)
                .filter(listToObject ->  objectLocationAnimal.nameObject.equalsIgnoreCase(listToObject.nameObject) && listToObject.isReproductionDay && objectLocationAnimal.equals(listToObject))
                .findFirst();

        if (first.isPresent()) {
            ObjectLocation objectLocation = first.get();
            isOk = objectLocationAnimal.reproduction(objectLocation);
        }
        return isOk;
    }

    private void objectHunt(List<ObjectLocation> list) {
        Iterator<ObjectLocation> objectLocationIterator = list.listIterator();
        while (objectLocationIterator.hasNext()) {
            ObjectLocation elementNext = objectLocationIterator.next();
            if (!elementNext.isLive) {
                objectLocationIterator.remove();
            }
            if (elementNext instanceof ObjectLocationAnimal objectLocationAnimal) {
                hunt(objectLocationAnimal, list);
            }
        }
    }

    private void hunt(ObjectLocationAnimal objectLocationAnimal, List<ObjectLocation> list) {
        Iterator<ObjectLocation> objectLocationIterator = list.listIterator();
        while (objectLocationIterator.hasNext()) {
            ObjectLocation elementNext = objectLocationIterator.next();
            if (objectLocationAnimal.chanceSuccessfulHunt.containsKey(elementNext.nameObject)) {
                if (objectLocationAnimal.hunting(elementNext)) {
                    elementNext.isLive = false;
                }
            }
        }
    }



    private void endDay(MyLocation location) {
        for (int i = 0; i < location.getMap().length; i++) {
            for (int j = 0; j < location.getMap()[i].length; j++) {
                for (ObjectLocation objectLocation : location.getMap()[i][j].getObjectLocationsList()) {
                    if (objectLocation instanceof ObjectLocationAnimal objectLocationAnimal) {
                        objectLocationAnimal.actionMove = true;
                        objectLocationAnimal.isReproductionDay = true;
                    }
                }
            }
        }
        statistics.setDay(statistics.getDay() + 1);
    }
}
