package com.KomSoft.lection16;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
    Created by Volodymyr P. Komarov aka KomSoft
*/
/*
    7. Из файла удалить все слова, содержащие от трех до пяти символов,
    но при этом из каждой строки должно быть удалено только
    максимальное четное количество таких слов.
*/
public class Delete3_5 {
    public static void main(String[] args) {
        String destDir = Homework16Common.DATA_DIR;
        String inFileName = destDir + File.separator + "data7.txt";
        String outFileName = destDir + File.separator + Homework16Common.MY_DIR + File.separator + "data7_out.txt";

        new MakeDestDir(Homework16Common.DATA_DIR + File.separator + Homework16Common.MY_DIR);
        System.out.println("7. Из файла удалить все слова, содержащие от трех до пяти символов,\n" +
                "    но при этом из каждой строки должно быть удалено только\n" +
                "    максимальное четное количество таких слов.");
        System.out.println("Try to read and parse datafile '" + inFileName + "'...");
        String str;
        String[] sParam;
        StringBuilder strBuff;
        ArrayList<String> wordList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(inFileName));
            PrintWriter pw = new PrintWriter((new BufferedWriter( new FileWriter(outFileName))))) {
            while ((str = br.readLine()) != null) {
                strBuff = new StringBuilder(str);
                sParam = str.split(" ");
                wordList.clear();
//                добавляем в список слова с длиной от 3 до 5
                for (String s : sParam) {
                    if ((s.length() >= 3) && (s.length() <= 5)) {
                        wordList.add(s);
                    }
                }
//                удаляем последнее нечетное слово, если есть
                if ((wordList.size() % 2) == 1) {
                    wordList.remove(wordList.size() - 1);
                }
//                удаляем выбранные слова из строки
                int index = 0;
                int i;
                for (String s : wordList) {
                    index = strBuff.indexOf(s, index);
                    strBuff.delete(index, index + s.length());
                }
                System.out.println("String before: '" + str + "'");
                System.out.println("String after:  '" + strBuff + "'");
                pw.write(strBuff.toString() + '\n');
            }
            System.out.println();
        } catch (FileNotFoundException e) {
            System.out.println("Error opening stream -> " + e);
//            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("General I/O error -> " + e);
//            e.printStackTrace();
        }
    }
}
