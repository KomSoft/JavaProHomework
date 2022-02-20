package com.KomSoft.lection6.TempConverter;

public class MainConverter {
    BaseConverter baseConverter;
    CelsiumConverter celsConv;


    public MainConverter() {
        celsConv = new CelsiumConverter();
        baseConverter = new BaseConverter(celsConv);
    }

    public static void main(String[] args) {
        new MainConverter();
    }
}
