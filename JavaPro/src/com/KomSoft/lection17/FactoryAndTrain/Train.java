package com.KomSoft.lection17.FactoryAndTrain;

/*
    Created by Volodymyr P. Komarov aka KomSoft
*/
/*
    17. Разработать многопоточное консольное приложение.    "Завод и поезда"
    Поток "Поезд"
*/

import java.util.concurrent.atomic.AtomicInteger;

public class Train extends Thread {
    private Factory factoryId;
    private final int LOAD_CAPACITY;
    private final int ID;
    private int gate;
    private AtomicInteger raw;
    private AtomicInteger items;
//    вопрос !!!! raw, items нужно делать Atomic? Вроде к ним только один процесс обращается (текущий).

    public Train(Factory factoryId, int id, int loadCapacity, int raw, int items) {
        this.factoryId = factoryId;
        this.LOAD_CAPACITY = loadCapacity;
        this.ID = id;
        this.raw = new AtomicInteger(raw);
        this.items = new AtomicInteger(items);
    }

    public boolean unLoad() {
//        выгрузили сырье
        if (raw.get() > 0) {
            raw.decrementAndGet();
            return true;
        }
        return false;
    }

//  с проверкой, чтобы вес сырья + готовых изделий не превышал грузоподъемность
//    Atomic нужны?
    public boolean load() {
//        контейнер с продукцией загрузили
//        if (items < loadCapacity) {
        if ((raw.get() + items.get()) < LOAD_CAPACITY) {
            items.addAndGet(1);
            return true;
        }
        return false;
    }

    @Override
    public void run() {
//        super.run();
        while ( (gate = factoryId.occupyGate(ID)) < 0) {
//            пытаемся прикрепиться к воротам
/*
    TODO иногда цепляет к одним воротам несколько поездов.
    Пока поезд прикрепляется к воротам, Factory.freeGateExists() успевает несколько раз выдать,
    что ворота свободны.     AtomicIntegerArray не помог.
    Если интервал между запуском поездов увеличить - этого не происходит.
    по-моему  AtomicIntegerArray - не то, нужно factory.occupyGate(ID) делать synchronized,
    чтобы туда не влазили несколько поездов.
*/
        }
        System.out.println("Train #" + ID + " is on Gate #" + (gate+1) + ". Load capacity: " + LOAD_CAPACITY +
                ", raw: " + raw + ", items: " + items);
        TrainLoad load = new TrainLoad(factoryId, this);
        TrainUnload unLoad = new TrainUnload(factoryId, this);
//        запускаем разгрузку / погрузку и ждем завершения
        unLoad.start();
        load.start();
        try {
            unLoad.join();
            load.join();
        } catch (InterruptedException e) {
            System.out.println("Loading interrupted on train #" + ID + "   " + e);
//            e.printStackTrace();
        }
        factoryId.leaveGate(ID);
        System.out.println("Train #" + ID + " is on the way!");
    }
}
