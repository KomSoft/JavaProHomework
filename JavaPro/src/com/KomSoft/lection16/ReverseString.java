package com.KomSoft.lection16;

import java.io.*;

/*
    Created by Volodymyr P. Komarov aka KomSoft
*/
/*
    3. Прочитать текст Java-программы и записать в другой файл
    в обратном порядке символы каждой строки.
*/
public class ReverseString {
    public static void main(String[] args) {
        String fileName = "PackJar.java";
        File inFile = new File(Homework16Common.PROJECT_DIR + File.separator + fileName);
        File outFile = new File(Homework16Common.DATA_DIR + File.separator + Homework16Common.MY_DIR +
                File.separator + "reverse" + fileName);

        new MakeDestDir(Homework16Common.DATA_DIR + File.separator + Homework16Common.MY_DIR);
        try (BufferedReader br = new BufferedReader(new FileReader(inFile));
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(outFile, false)))) {
            StringBuilder stringBuilder;
            String str;
            char[] cArray;
            char c;
            while ((str = br.readLine()) != null) {
//                System.out.println(str);
                stringBuilder = new StringBuilder(str);
                stringBuilder.reverse();
//                System.out.println(stringBuilder);
                pw.println(stringBuilder);
/*
                cArray = str.toCharArray();
                for (int i = 0; i < str.length()/2; i++) {
                    c = cArray[i];
                    cArray[i] = cArray[str.length()-i-1];
                    cArray[str.length()-i-1] = c;
                }
                str = String.valueOf(cArray);
//                System.out.println(str);
                pw.println(str);
*/
            }
            System.out.println("File '" + outFile + "' has created successfully.");
        } catch (IOException e) {
            System.out.println("Error opening stream or I/O Error " + e);
//            e.printStackTrace();
        }

    }

}
