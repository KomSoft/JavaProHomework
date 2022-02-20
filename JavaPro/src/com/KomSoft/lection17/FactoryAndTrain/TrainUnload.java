package com.KomSoft.lection17.FactoryAndTrain;

/*
    Created by Volodymyr P. Komarov aka KomSoft
*/
/*
    17. Разработать многопоточное консольное приложение.    "Завод и поезда"
    Поток "Разгрузка поезда"
*/
import java.util.Random;

public class TrainUnload extends Thread {
    private Train train;
    private Factory factory;

    public TrainUnload(Factory factory, Train train) {
        this.train = train;
        this.factory = factory;
    }

    @Override
    public void run() {
//        super.run();
        Random rand = new Random();
        boolean isTrainNotEmpty = true;
//        System.out.println("Unloading train....");
        while (isTrainNotEmpty) {
            isTrainNotEmpty = train.unLoad();
//          выгрузили и проверили есть еще сырье
            while (!factory.loadSource()) {
//            ждем, пока положится на завод
            }
            try {
//              рандомизируем время выгрузки-загрузки
                Thread.sleep(5 + rand.nextInt(8));
            } catch (InterruptedException e) {
                System.out.println("Error sleeping 'train load' thread" + e);
//                e.printStackTrace();
            }
        }
    }
}
