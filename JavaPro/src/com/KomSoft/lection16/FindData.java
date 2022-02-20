package com.KomSoft.lection16;

import java.io.*;
import java.util.Scanner;

/*
    Created by Volodymyr P. Komarov aka KomSoft
*/
/*
    6. Файл содержит символы, слова, целые числа и числа с плавающей запятой.
    Определить все данные, тип которых вводится из командной строки.
*/
public class FindData {
    public static void main(String[] args) {
        String destDir = Homework16Common.DATA_DIR;
        String fileName = destDir + File.separator + "data6.txt";
        boolean bInt = false, bDouble = false, bChar = false, bWord = false;

        System.out.print("Enter data types for find (int, double, char, word) divided by space: ");
        Scanner scanner = new Scanner(System.in);
//        StringBuffer strBuff = new StringBuffer(scanner.nextLine());
        String str;
        str = scanner.nextLine();
        String[] sParam;
        sParam = str.split(" ");
        for (String s : sParam) {
            if (s.equalsIgnoreCase("int")) {
                bInt = true;
            }
            if (s.equalsIgnoreCase("double")) {
                bDouble = true;
            }
            if (s.equalsIgnoreCase("char")) {
                bChar = true;
            }
            if (s.equalsIgnoreCase("word")) {
                bWord = true;
            }
        }
        System.out.print("Try to read and parse datafile '" + fileName + "'...");
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            boolean bUnknown, intFound;
            while ((str = br.readLine()) != null) {
                sParam = str.split(" ");
                System.out.print("\nString '" + str + "' contains: \t");
//                разбираем на типы данных
                for (String s : sParam) {
                    bUnknown = true;
                    intFound = false;
                    if (!s.isEmpty()) {
/*
                    if (bInt) {
                        try {
                            Integer.parseInt(s);
                            System.out.print("int \t");
                            bUnknown = false;
                            intFound = true;
                        } catch (NumberFormatException e) {
//                            do nothing
//                            e.printStackTrace();
                        }
                    }
*/
                        if (bInt && s.matches("(\\+?)(\\-?)\\d?")) {
                            Integer.parseInt(s);
                            System.out.print("int \t");
                            bUnknown = false;
                            intFound = true;
                        }
                        if (bDouble && !intFound && s.matches("(\\+?)(\\-?)\\d*\\.?\\d*[eE]?\\+?\\-?\\d{1,3}+")) {
                            try {
                                Double.parseDouble(s);
                                System.out.print("double \t");
                                bUnknown = false;
                            } catch (NumberFormatException e) {
//                            do nothing
//                            e.printStackTrace();
                            }
                        }
                        if (bChar && (s.length() == 1) && (s.matches("[a-zA-Zа-яА-Я\s]"))) {
                            System.out.print("char \t");
                            bUnknown = false;
                        }
                        if (bWord && (s.length() > 1) && (s.matches("[a-zA-Zа-яА-Я]+"))) {
                            System.out.print("word \t");
                            bUnknown = false;
                        }
                    }
                    if (bUnknown) {
                        System.out.print("unknown type (String?) \t");
                    }
                }
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
