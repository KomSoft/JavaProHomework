package com.KomSoft.lection17.FactoryAndTrain;

/*
    Created by Volodymyr P. Komarov aka KomSoft
*/
/*
    17. Разработать многопоточное консольное приложение.    "Завод и поезда"
    Поток "Завод"
*/
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class Factory extends Thread {
    private final int MAX_SOURCE_CAPACITY = 500;
    private final int MAX_PRODUCT_CAPACITY = 500;
    private final int GATE_COUNT = 4;
    private AtomicInteger sourceWarehouse;
    private AtomicInteger productWarehouse;
    private AtomicIntegerArray gates = new AtomicIntegerArray(GATE_COUNT);
    {
        for (int i = 0; i < gates.length(); i++) {
            gates.set(i, -1);
        }
    }

    public Factory(AtomicInteger sourceWarehouse, AtomicInteger productWarehouse) {
        this.sourceWarehouse = sourceWarehouse;
        this.productWarehouse = productWarehouse;
    }

    public boolean loadSource() {
        if (sourceWarehouse.get() < MAX_SOURCE_CAPACITY) {
            sourceWarehouse.addAndGet(1);
            return true;
        } else {
//            System.out.println("Factory: Source Warehouse is full!");
            return false;
        }
    }

    public boolean unloadProduct() {
        if (productWarehouse.get() > 0) {
            productWarehouse.decrementAndGet();
            return true;
        } else {
//            System.out.println("Factory: Product Warehouse is empty!");
            return false;
        }
    }

//  прикрепить поезд к воротам
    public int occupyGate(int trainId) {
        for (int i = 0; i < gates.length(); i++) {
            if (gates.get(i) < 0 ) {
                gates.set(i, trainId);
                return i;
            }
        }
        return -1;
    }

//  выдать номер свободных ворот
    public int getFreeGate() {
        for (int i = 0; i < gates.length(); i++) {
            if (gates.get(i) < 0 ) {
                return i;
            }
        }
//        TODO написано не совсем правильно, потом переписать, чтобы гарантировано давало номер ворот, а не -1
        return -1;
    }

//    открепить поезд от ворот
    public void leaveGate(int trainId) {
        for (int i = 0; i < gates.length(); i++) {
            if (trainId == gates.get(i)) {
                gates.set(i, -1);
            }
        }
    }

    public boolean freeGateExists() {
        for (int i = 0; i < gates.length(); i++) {
            if (gates.get(i) < 0) {
                return true;
            }
        }
        return false;
    }

    public int getSourceWarehouse() {
        return sourceWarehouse.get();
    }

    public int getProductWarehouse() {
        return productWarehouse.get();
    }

    @Override
    public void run() {
//        super.run();
        System.out.println("Factory (source - " + sourceWarehouse.get() + ",  items - " + productWarehouse.get() + ").  Working...");
        while (true) {
            if (sourceWarehouse.get() > 0) {
                if (productWarehouse.get() < MAX_PRODUCT_CAPACITY) {
//                    цикл производства
                    sourceWarehouse.getAndDecrement();
                    productWarehouse.addAndGet(1);
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        System.out.println("Error sleeping 'factory' thread" + e);
//                        e.printStackTrace();
                    }
                } else {
//                    System.out.println("Factory: Product Warehouse is full!");
                }
            } else {
//                System.out.println("Factory: Source Warehouse is empty!");
            }
        }

    }
}
