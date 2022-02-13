package com.KomSoft.lection16;

import java.io.*;
import java.util.Locale;

/*
    Created by Volodymyr P. Komarov aka KomSoft
*/
/*
    4. Прочитать текст Java-программы и в каждом слове
    длиннее двух символов все строчные символы заменить прописными.
*/
public class UpMore2chars {
    public static void main(String[] args) {
        String fileName = "PackJar.java";
        String destDir = Homework16Common.DATA_DIR + File.separator + Homework16Common.MY_DIR;
        File inFile = new File(Homework16Common.PROJECT_DIR + File.separator + fileName);
        File outFile = new File( destDir + File.separator + "up2_" + fileName);

        new MakeDestDir(destDir);
        try (BufferedReader br = new BufferedReader(new FileReader(inFile));
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(outFile)))) {
            String str;
            String[] words;
            while ((str = br.readLine()) != null) {
//                System.out.println("input  : " + str);
                words = str.split(" ");
                StringBuilder strBuff = new StringBuilder(str);
                int index = 0;
                for(String s : words) {
                    if (s.length() > 2) {
                        index = strBuff.indexOf(s, index);
                        strBuff.replace(index, index + s.length(), s.toUpperCase(Locale.ROOT));
                        index += s.length();
                    }
                }
//                System.out.println("output : " + strBuff);
                pw.write(strBuff + "\n");
            }

            System.out.println("File '" + outFile + "' has created successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found -> " + e);
//            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error opening stream or I/O Error " + e);
//            e.printStackTrace();
        }
    }
}
