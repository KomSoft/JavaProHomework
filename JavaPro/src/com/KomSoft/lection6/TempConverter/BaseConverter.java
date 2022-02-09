package com.KomSoft.lection6.TempConverter;

import java.util.Scanner;

public class BaseConverter {
    private TConverter tc;

    public BaseConverter(TConverter tConv) {
        double temp;
        tc = tConv;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Введите температуру в градусах Цельсия (-300 для выхода): ");
            temp = scanner.nextDouble();
            System.out.println("Переводим в градусы Фаренгейта: " + tc.convert(temp,TempScale.F));
            System.out.println("Переводим в градусы Кельвина: " + tc.convert(temp,TempScale.K));
            System.out.println("Переводим в градусы Реомюра: " + tc.convert(temp,TempScale.Re));
            System.out.println("Переводим в градусы Ремера: " + tc.convert(temp,TempScale.Ro));
            System.out.println("Переводим в градусы Ранкина: " + tc.convert(temp,TempScale.Ra));
            System.out.println("Переводим в градусы Делиля: " + tc.convert(temp,TempScale.D));
            System.out.println("Переводим в градусы Гука: " + tc.convert(temp,TempScale.H));
            System.out.println("Переводим в градусы Дальтона: " + tc.convert(temp,TempScale.Da));
            System.out.println("Переводим в градусы Ньютона: " + tc.convert(temp,TempScale.N));
            System.out.println("Переводим в Лейденский градус: " + tc.convert(temp,TempScale.L));
            System.out.println("Переводим в Планковскую температуру: " + tc.convert(temp,TempScale.Tp));
        } while (Math.abs(temp+300.0) > 0.01);
    }
}
