package com.KomSoft.lection16;

import java.io.*;
import java.util.Locale;

/*
    Created by Volodymyr P. Komarov aka KomSoft
*/
/*
    9. Из текста Java-программы удалить все виды комментариев.
    Примечание 1. Для простоты считаем, что в правильном тексте все комментарии начинаются с начала строки
*/
public class RemoveComments {
    public static void main(String[] args) {
        String fileName = "SwapFirstLast.java";
        String destDir = Homework16Common.DATA_DIR + File.separator + Homework16Common.MY_DIR;
        String inFile = Homework16Common.PROJECT_DIR + File.separator + fileName;
        String outFile = destDir + File.separator + "woComm_" + fileName;

        new MakeDestDir(destDir);
        try (BufferedReader br = new BufferedReader(new FileReader(inFile));
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(outFile)))) {
            String str;
            boolean isOneLineComment = false, isMultiLineComment = false, isEndOfMultiLineComm;
            while ((str = br.readLine()) != null) {
//                System.out.println("input  : " + str);
//              если многострочный комментарий, то ищем его конец
                isEndOfMultiLineComm = false;
                if (isMultiLineComment) {
                    isEndOfMultiLineComm = str.startsWith("*/");
                    isMultiLineComment = !isEndOfMultiLineComm;
                } else {
//              если не многострочный комментарий (или вообще не комментарий -
//              то ищем однострочный комментарий или начало многострочного
                    isOneLineComment = str.startsWith("//");
                    isMultiLineComment = str.startsWith("/*");
                }
//                если не комментарий, записываем строку в выходной файл
                if (!(isOneLineComment || isMultiLineComment || isEndOfMultiLineComm)) {
//                System.out.println("output : " + str);
                pw.write(str + "\n");
                }
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
