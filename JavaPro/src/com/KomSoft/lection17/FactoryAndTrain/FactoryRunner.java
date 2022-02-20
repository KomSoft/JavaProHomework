package com.KomSoft.lection17.FactoryAndTrain;

/*
    Created by Volodymyr P. Komarov aka KomSoft
*/
/*
    17. Разработать многопоточное консольное приложение.    "Завод и поезда"
    Использовать возможности, предоставляемые пакетом java.util.concurrent.
    Не использовать слово synchronized.
    Все сущности, желающие получить доступ к ресурсу, должны быть потоками.
    Использовать возможности ООП.

*/
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class FactoryRunner {

    public static void main(String[] args) {
    final int MAX_TRAIN_CAPACITY = 100;
    Factory factory;
        final int MAX_TRAIN = 15;
//        на складах что-то есть
        factory = new Factory(new AtomicInteger(250), new AtomicInteger(200));
        factory.setDaemon(true);
        factory.start();
//        пускаем поезда
        int trainCount = 1;
        int trainCapacity;
        int rawInTrain, itemsInTrain;
        Random rand = new Random();
        while (trainCount <= MAX_TRAIN) {
            if (factory.freeGateExists()) {
//                формируем поезд со случайной грузоподъемностью от 50 до 100 %
//                и разным количеством сырья и готового товара
                trainCapacity = MAX_TRAIN_CAPACITY / 2 + rand.nextInt(MAX_TRAIN_CAPACITY / 2);
                rawInTrain = rand.nextInt(trainCapacity);
                if (rawInTrain < trainCapacity / 5) {
                    rawInTrain = 0;
                }
                itemsInTrain = rawInTrain > (trainCapacity * 0.9) ? 0 : trainCapacity - rawInTrain;
//                запускаем поезд
                new Train(factory, trainCount++, trainCapacity, rawInTrain, itemsInTrain).start();
            }
            try {
                Thread.sleep(10);
//                смотри примечание TODO в Train
            } catch (InterruptedException e) {
                System.out.println("Error sleeping 'main' thread" + e);
                //            e.printStackTrace();
            }
        }
        System.out.println("Last train is gone... Factory: source - " + factory.getSourceWarehouse() + ",  items - " + factory.getProductWarehouse() + ".");
//        Ну понятно, данные вывели, а поезда еще грузятся. Поэтому Factory: source - ***,  items - 500.
    }
}
