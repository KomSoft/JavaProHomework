package com.KomSoft.lection17.FactoryAndTrain;

/*
    Created by Volodymyr P. Komarov aka KomSoft
*/
/*
    17. Разработать многопоточное консольное приложение.    "Завод и поезда"
    Поток "Погрузка поезда"
*/
import java.util.Random;

public class TrainLoad extends Thread {
    private Train train;
    private Factory factory;

    public TrainLoad(Factory factory, Train train) {
        this.train = train;
        this.factory = factory;
    }

    @Override
    public void run() {
//        super.run();
        Random rand = new Random();
        boolean isTrainNotFull = true;
//        System.out.println("Loading train....");
        while (isTrainNotFull) {
//            пробуем взять с завода
            if (factory.unloadProduct()) {
//            грузим в поезд и проверяем полный или нет
                isTrainNotFull = train.load();
            }
            try {
//              рандомизируем время выполнения
                Thread.sleep(5 + rand.nextInt(8));
            } catch (InterruptedException e) {
                System.out.println("Error sleeping 'train load' thread" + e);
//                e.printStackTrace();
            }
        }
    }
}
