package ru.javarush.Island.Logic;

import ru.javarush.Island.ObjectIsland.IslandLocation.MyLocation;
import ru.javarush.Island.ObjectIsland.objectLocation.Animal.Herbivores.*;
import ru.javarush.Island.ObjectIsland.objectLocation.Animal.Predators.*;
import ru.javarush.Island.ObjectIsland.objectLocation.Insects.Caterpillar;
import ru.javarush.Island.ObjectIsland.objectLocation.ObjectLocation;
import ru.javarush.Island.ObjectIsland.objectLocation.Plants.Grass;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InitMap {
    private final MyLocation location;
    private Statistics statistics = Statistics.getInstance();

    private final List<Class> classList = new ArrayList<>();


    {
        classList.add(Buffalo.class);
        classList.add(Deer.class);
        classList.add(Duck.class);
        classList.add(Goat.class);
        classList.add(Horse.class);
        classList.add(Mouse.class);
        classList.add(Rabbit.class);
        classList.add(Sheep.class);
        classList.add(WildBoar.class);
        classList.add(Anaconda.class);
        classList.add(Bear.class);
        classList.add(Eagle.class);
        classList.add(Fox.class);
        classList.add(Wolf.class);
        classList.add(Caterpillar.class);
        classList.add(Grass.class);
    }

    public InitMap(MyLocation location) {
        this.location = location;
    }

    public void initLocation() throws NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        initMap();
        initObjectMap();
    }

    private void initMap() {
        //инициализируем карту ячейками для хранения обьектов
        for (int i = 0; i < location.getMap().length; i++) {
            for (int j = 0; j < location.getMap()[i].length; j++) {
                location.getMap()[i][j] = location.new Cell(i, j);
            }
        }
    }

    private void initObjectMap() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        //переменные для хранения длини и ширины игрового поля
        int sizeMaxMapX = location.getMap().length;
        int sizeMaxMapY = location.getMap()[0].length;

        Random random = new Random();

        for (int i = 0; i < location.getMap().length; i++) {
            for (int j = 0; j < location.getMap()[i].length; j++) {

                for (Class clazz : classList) {
                    //не все виды животных могут быть на одной ячейки локации
                    if (random.nextInt(2) > 0) {
                        //координаты будущего обьекты
                        int coordinatesX = random.nextInt(sizeMaxMapX);
                        int coordinatesY = random.nextInt(sizeMaxMapY);
                        Constructor<ObjectLocation> constructor = clazz.getConstructor(int.class, int.class);
                        //создаем случаеное количевство обьектов с помощью поля класса
                        int quantity = getQuantityObject(clazz, constructor, coordinatesX, coordinatesY);
                        for (int k = 0; k < random.nextInt(quantity); k++) {
                            //добавляем новый обьект на карту
                            location.getMap()[coordinatesX][coordinatesY].getObjectLocationsList().add(constructor.newInstance(coordinatesX, coordinatesY));
                            //увеличиваем счетчик кол-во животных
                            statistics.setCountObject(statistics.getCountObject() + 1);
                        }
                    }
                }

            }
        }
    }

    private int getQuantityObject(Class<ObjectLocation> clazz, Constructor<ObjectLocation> constructor, int coordinatesX, int coordinatesY) throws NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //получаем обьект обькт через рефлексию для получения поля "maxObjectCell"
        Field maxObjectCell = clazz.getField("maxObjectCell");
        ObjectLocation objectLocation = constructor.newInstance(coordinatesX, coordinatesY);
        return (int) maxObjectCell.get(objectLocation);

    }
}
