package com.KomSoft.lection16;

import java.io.*;

/*
    Created by Volodymyr P. Komarov aka KomSoft
*/
/*
    9. Из текста Java-программы удалить все виды комментариев.
    Примечание 1. Для простоты считаем, что в правильном тексте все комментарии начинаются с начала строки
    Примечание 2. Упростил логику записать или нет в файл
*/
public class RemoveComments1 {
    public static void main(String[] args) {
        String fileName = "SwapFirstLast.java";
        String destDir = Homework16Common.DATA_DIR + File.separator + Homework16Common.MY_DIR;
        String inFile = Homework16Common.PROJECT_DIR + File.separator + fileName;
        String outFile = destDir + File.separator + "woComm_" + fileName;

        new MakeDestDir(destDir);
        try (BufferedReader br = new BufferedReader(new FileReader(inFile));
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(outFile)))) {
            String str;
            boolean isMultiLineComment = false;
            boolean isWriteLine;
            while ((str = br.readLine()) != null) {
//                System.out.println("input  : " + str);
//              если многострочный комментарий, то ищем его конец, и строку в вых файл не пишем (даже если нашли конец)
                if (isMultiLineComment) {
                    isWriteLine = false;
                    isMultiLineComment = !str.startsWith("*/");
                } else {
//              если не многострочный комментарий, то ищем начало многострочного или однострочный,
//                  если нашли комментарий - строку не пишем. !!! Вычисляем оба выражения !!!
                    isWriteLine = !((isMultiLineComment = str.startsWith("/*")) | str.startsWith("//"));
                }
//                записываем строку в выходной файл, если стоит флаг
                if (isWriteLine) {
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
