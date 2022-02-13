package com.KomSoft.lection16;

import java.io.*;

/*
    Created by Volodymyr P. Komarov aka KomSoft
*/
/*
    9. Из текста Java-программы удалить все виды комментариев.
    Примечание 1. Сделал, чтобы работало, даже если признак комментария начинается не с начала строки
    Примечание 2. Упростил логику записать или нет в файл
    Примечание 3. Не учитывается, что признак комментария (в середине строки) может быть в кавычках (как строка).
                Но кавычки считать и учитывать лень.
*/
public class RemoveComments2 {
    public static void main(String[] args) {
        String fileName = "RemoveCommentsTestFile.txt";
        String destDir = Homework16Common.DATA_DIR + File.separator + Homework16Common.MY_DIR;
        String inFile = Homework16Common.DATA_DIR + File.separator + fileName;
        String outFile = destDir + File.separator + "woComm_" + fileName;

        new MakeDestDir(destDir);
        try (BufferedReader br = new BufferedReader(new FileReader(inFile));
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(outFile)))) {
            String str;
            StringBuilder strBuff;
            boolean isMultiLineComment = false;
            boolean isWriteLine;
            int index;

            while ((str = br.readLine()) != null) {
//                System.out.println("input  : " + str);
//              если многострочный комментарий, то ищем его конец, и строку в вых файл не пишем (даже если нашли конец)
                strBuff = new StringBuilder(str);
                if (isMultiLineComment) {
                    isWriteLine = false;
                    index = str.indexOf("*/");
                    isMultiLineComment = index < 0;     // не нашли - продолжается многострочный комментарий
                    if (index >= 0) {
//                        удаляем от начала строки до комментария вместе с признаком
                        strBuff.delete(0, index + 2);
                        // если строка получилась не пустая, то установим флаг записи (тоже не совсем правильно, если в ней есть пробелы)
                        isWriteLine = !strBuff.isEmpty();
                    }
                } else {
//              если не многострочный комментарий, то ищем начало многострочного или однострочный,
                    index = str.indexOf("/*");
                    isMultiLineComment = index >= 0;     // нашли - начался многострочный комментарий
                    if (index < 0) {
                        index = str.indexOf("//");
                    }
                    if (index >= 0) {
//                        удаляем от начала комментария до конца строки
                        strBuff.delete(index, strBuff.length());
                    }
                    // если строка получилась не пустая, то установим флаг записи (тоже не совсем правильно, если в ней есть пробелы)
                    isWriteLine = !strBuff.isEmpty();
                }

//                записываем строку в выходной файл, если стоит флаг
                if (isWriteLine) {
//                System.out.println("output : " + strBuff);
                pw.write(strBuff + "\n");
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
