package com.KomSoft.lection16;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

/*
    Created by Volodymyr P. Komarov aka KomSoft
*/
/*
    1. Создать и заполнить файл случайными целыми числами.
    Отсортировать содержимое файла по возрастанию.
*/
public class FillRandom {
    public static void main(String[] args) {
        int count = 50;
        int max_number = 100;
        String fileName = "out1.txt";
        int[] data = new int[count];
        Random rand = new Random();
        for(int i = 0; i < count; i++) {
            data[i] = rand.nextInt(max_number);
        }
        int temp;
        for(int i = data.length-1; i >= 1; i--) {
            for(int j = 0; j < i; j++) {
                if(data[j] > data[j+1]) {
                    temp = data[j];
                    data[j] = data[j+1];
                    data[j+1]= temp;
                }
            }
        }
        PrintWriter pw = null;
        try {
            String destDir = Homework16Common.DATA_DIR + File.separator + Homework16Common.MY_DIR;
            File fileDir = new File(destDir);
            if(!fileDir.exists()) {
                fileDir.mkdir();
            }
            String destFile = destDir + File.separator + fileName;
            pw = new PrintWriter(new BufferedWriter(new FileWriter(destFile, false)));
            for(int i : data) {
                pw.println(i);
            }
            System.out.println("File '" + destFile + "' has created successfully.");
        } catch (IOException e) {
            System.out.println("Error opening stream " + e);
//            e.printStackTrace();
        } finally {
            if(pw != null) {
                pw.close();
            }
        }
    }

}
