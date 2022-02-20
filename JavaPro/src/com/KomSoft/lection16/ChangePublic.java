package com.KomSoft.lection16;

import java.io.*;
import java.util.Random;

/*
    Created by Volodymyr P. Komarov aka KomSoft
*/
/*
    2. Прочитать текст Java-программы и все слова public
    в объявлении атрибутов и методов класса заменить на слово private.
*/
public class ChangePublic {
    public static void main(String[] args) {
        String fileName = "PackJar.java";
        final String CHANGED =      "  changed   : ";
        final String NOT_CHANGED =  "not changed : ";
        final String REP_STRING = "public ";
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(Homework16Common.PROJECT_DIR + File.separator + fileName));
            StringBuilder stringBuilder;
            String str;
            int index;
//            while ((stringBuilder = new StringBuilder(br.readLine())) != null) {
            // хотел, как лучше, но  StringBuilder(br.readLine()) выдает exception, если строки закончились
            while ((str = br.readLine()) != null) {
                stringBuilder = new StringBuilder(str);
//                ищем и меням по шаблону "public " на "private "
                index = stringBuilder.indexOf(REP_STRING, 0);
                if(index >= 0) {
                    stringBuilder.replace(index, index + REP_STRING.length(), "private ");
                }
                System.out.println((index < 0 ? NOT_CHANGED : CHANGED) + stringBuilder);
            }
        } catch (IOException e) {
            System.out.println("Error opening stream or I/O Error " + e);
//            e.printStackTrace();
        } finally {
            if(br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println("Error closing stream " + e);
//                    e.printStackTrace();
                }
            }
        }
    }

}
