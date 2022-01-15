package com.KomSoft.lection6;

import com.KomSoft.lection6.TempConverter.TempScale;

/*
    Created by Volodymyr P. Komarov aka KomSoft
*/
public class BaseConverter1 {
    private double temp;
    private TempScale tempS;
/*
    Градус Цельсия (℃), Градус Фаренгейта (℉), Кельвин (K), Градус Реомюра (°Ré, °Re, °R)
    Градус Рёмера (°Rø), Градус Ранкина (°Ra), Градус Делиля (°Д или °D), Градус Гука (°H)
    Градус Дальтона (°Dа), Градус Ньютона (°N), Лейденский градус (°L или ÐL), Планковская температура (TP)
*/

    public BaseConverter1(double temp, TempScale tempS) {
        this.temp = temp;
        this.tempS = tempS;
    }

    public BaseConverter1(double temp, String str) {
        this.temp = temp;
        for (TempScale ts : TempScale.values()) {
            if (str.equalsIgnoreCase(ts.getScale())) {
                this.tempS = ts;
                return;
            }
//      по умолчанию (если не соответствует - ставим Цельсий
        this.tempS = TempScale.C;
        }
    }

    public void setTemp(double temp){
        this.temp = temp;
    }

    public void setTemp(double temp, TempScale tempS){
        this.temp = temp;
        this.tempS = tempS;
    }

    public String getTemp() {
        return String.format("%.2f \u00B0" + tempS.getScale(), temp);
    }

//  можно дописать такой метод
    public double Convert(double temp, TempScale inScale, TempScale outScale) {
        this.temp = temp;
        this.tempS = inScale;
        return this.Convert(outScale);
    }

    private double Convert(TempScale tsc) {
        switch (tempS) {
            case C : {  // переводим из Цельсия
                switch (tsc) {
                    case C : {
                        return temp;                    //  в Цельсий, без конвертации
                    }
                    case F : {
                        return 1.8 * temp + 32;         //  в Фаренгейт
                    }
                    case K : {
                        return temp + 273.15;           //  в Кельвин
                    }
                    case Re : {
                        return temp * 0.8;              // в Реомюра
                    }
                    case Ro : {
                        return temp * 21 / 40 +7.5;     // в Ремера
                    }
                    case Ra : {
                        return (temp + 273.15) * 1.8;   // в Ранкина
                    }
                    case D : {
                        return (100 - temp) * 1.5;      // в Делиля
                    }
                    case H : {
                        return temp * 2.4;      // в Гука
                    }
                    case Da : {                 // в Дальтона
                        return 100 * (Math.log10(temp + 273.15) - Math.log10(273.15)) / (Math.log10(373.15) - Math.log10(273.15));
                    }
                    case N : {
                        return temp * 0.33;      // в Ньютона
                    }
                    case L : {
                        return temp + 253;      // в Лейденский градус
                    }
                    case Tp : {
                        return (temp + 273.15) * 1.416784e32;      // в Планковскую температуру
                    }
                    default: return Double.NaN;
                }
            }
            case F : {  // переводим из Фаренгейта
                switch (tsc) {
                    case C : {
                        return (temp - 32) * 5 / 9;     //  в Цельсий
                    }
                    case F : {
                        return temp;                    //  в Фаренгейт - без конвертации
                    }
                    case K : {
                        return (temp - 32) * 5 / 9 + 273.15;  //  в Кельвин
                    }
                    case Re : {
                        return (temp - 32) * 4 / 9;     // в Реомюра  (*5*0.8/9)
                    }
//                    case Ro, Ra, D, H, Da, N, L, Tp : {   // конвертер дописать
                    default: return Double.NaN;
                }
            }
            case K : {  // переводим из Кельвина
                switch (tsc) {
                    case C : {
                        return temp - 273.15;           //  в Цельсий
                    }
                    case F : {
                        return 1.8 * (temp - 273.15) + 32;         //  в Фаренгейт
                    }
                    case K : {
                        return temp;                    //  в Кельвин, без конвертации
                    }
                    case Re : {
                        return (temp - 273.15) * 0.8;   // в Реомюра
                    }
//                    case Ro, Ra, D, H, Da, N, L, Tp : {   // конвертер дописать
                    default: return Double.NaN;
                }

            }
            default: return Double.NaN; // конвертация по каким-то причинам не прошла
        }

    }

    public double getTempCelsium() {
        return Convert(TempScale.C);
    }

    public double getTempFahrenheit() {
        return Convert(TempScale.F);
    }

    public double getTempKelvin() {
        return Convert(TempScale.K);
    }

    public double getTempReomure() {
        return Convert(TempScale.Re);
    }

    public static void main(String[] args) {
        BaseConverter1 tc = new BaseConverter1(15, "C");
        System.out.println("Задана температура: " + tc.getTemp());
        System.out.println("Переводим в градусы Цельсия: " + tc.getTempCelsium());
        System.out.println("Переводим в градусы Фаренгейта: " + tc.getTempFahrenheit());
        System.out.println("Переводим в градусы Кельвина: " + tc.getTempKelvin());
        System.out.println("Переводим в градусы Реомюра: " + tc.getTempReomure());
        tc.setTemp(80.0);
        System.out.println("Задана температура: " + tc.getTemp());
        System.out.println("Переводим в градусы Цельсия: " + tc.getTempCelsium());
        System.out.println("Переводим в градусы Фаренгейта: " + tc.getTempFahrenheit());
        System.out.println("Переводим в градусы Кельвина: " + tc.getTempKelvin());
        System.out.println("Переводим в градусы Реомюра: " + tc.getTempReomure());
        tc.setTemp(32.0, TempScale.F);
        System.out.println("Задана температура: " + tc.getTemp());
        System.out.println("Переводим в градусы Цельсия: " + tc.getTempCelsium());
        System.out.println("Переводим в градусы Фаренгейта: " + tc.getTempFahrenheit());
        System.out.println("Переводим в градусы Кельвина: " + tc.getTempKelvin());
        System.out.println("Переводим в градусы Реомюра: " + tc.getTempReomure());
        System.out.println("Переводим 15 Кельвина в Фаренгейта: " + tc.Convert(15,TempScale.K,TempScale.F));
        System.out.println("Переводим 25 Фаренгейта в Реомюра: " + tc.Convert(25,TempScale.F,TempScale.Re));

    }

}