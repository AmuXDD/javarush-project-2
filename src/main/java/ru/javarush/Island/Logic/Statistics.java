package ru.javarush.Island.Logic;

import ru.javarush.Island.ObjectIsland.objectLocation.ObjectLocation;

public class Statistics {
    private int day;
    private static Statistics statistics = null;
    private int countObject;



    private Statistics() {
    }

    public static Statistics getInstance() {
        if (statistics == null) {
            synchronized (Statistics.class) {
                statistics = new Statistics();
            }
        }
        return statistics;
    }

    public int getCountObject() {
        return countObject;
    }

    public void setCountObject(int countObject) {
        this.countObject = countObject;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }


    public void printStatistics() {
        System.out.println("Дней на острове - " + day);
        System.out.println("Животных на острове - " + countObject);
    }
}
