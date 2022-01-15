package com.KomSoft.lection6.TempConverter;

public enum TempScale { F("F"), C("C"), K("K"), Ro("Ro"), Re("Re"), Ra("Ra"), D("D"), H("H"), Da("Da"), N("N"), L("L"), Tp("Tp");
//    Градус Цельсия (℃), Градус Фаренгейта (℉), Кельвин (K), Градус Реомюра (°Ré, °Re, °R)
//    Градус Рёмера (°Rø), Градус Ранкина (°Ra), Градус Делиля (°Д или °D), Градус Гука (°H)
//    Градус Дальтона (°Dа), Градус Ньютона (°N), Лейденский градус (°L или ÐL), Планковская температура (TP)
        private String scale;
        TempScale(String scale) {
            this.scale = scale;
        }
        public String getScale() {
            return scale;
        }

}
