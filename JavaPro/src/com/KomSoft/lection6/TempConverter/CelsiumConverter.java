package com.KomSoft.lection6.TempConverter;

public class CelsiumConverter implements TConverter{

    @Override
    public double convert(double temp, TempScale ts) {
        switch (ts) {
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
}
