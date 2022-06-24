package ru.javarush.Island.ObjectIsland.objectLocation;

public class ObjectLocation {
    public String nameObject;
    public double weight;
    public int coordinatesX;
    public int coordinatesY;
    public int maxObjectCell;
    public boolean isLive = true;

    public ObjectLocation(int coordinatesX, int coordinatesY) {
        this.coordinatesX = coordinatesX;
        this.coordinatesY = coordinatesY;
    }


    @Override
    public String toString() {
        return "ObjectLocation{" +
                "nameObject='" + nameObject + '\'' +
                '}';
    }
}
