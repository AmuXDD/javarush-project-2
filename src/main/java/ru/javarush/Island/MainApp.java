package ru.javarush.Island;

import ru.javarush.Island.Logic.InitMap;
import ru.javarush.Island.Logic.LogicApp;
import ru.javarush.Island.Logic.Statistics;
import ru.javarush.Island.ObjectIsland.IslandLocation.MyLocation;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.TimeUnit;

public class MainApp {
    public static void main(String[] args) throws InterruptedException, NoSuchFieldException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
        MyLocation location = new MyLocation(100 , 20);
        InitMap initMap = new InitMap(location);
        initMap.initLocation();
        LogicApp logicApp = new LogicApp(location);
        Statistics statistics = Statistics.getInstance();








        boolean isExit = false;

        while (!isExit) {

            TimeUnit.SECONDS.sleep(1);
            location.print();
            logicApp.dayIsland(location);
            statistics.printStatistics();


            if (statistics.getCountObject() <= 0){
                isExit = true;
                System.out.println("Exit");
            }
        }
    }
}
