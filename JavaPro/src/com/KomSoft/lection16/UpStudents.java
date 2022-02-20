package com.KomSoft.lection16;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/*
    Created by Volodymyr P. Komarov aka KomSoft
*/
/*
    5. В файле, содержащем фамилии студентов и их оценки, записать прописными буквами
    фамилии тех студентов, которые имеют средний балл более 7.
*/
public class UpStudents {
    public static void main(String[] args) {
        String fileName = "StudentsGrade.txt";
        String destDir = Homework16Common.DATA_DIR + File.separator + Homework16Common.MY_DIR;

        new MakeDestDir(destDir);
        File outFile = new File(destDir + File.separator + fileName);

        ArrayList<String> students = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(outFile))) {
            String str;
            while ((str = br.readLine()) != null) {
                students.add(str);
            }
        } catch (IOException e) {
            System.out.println("I/O Error -> " + e);
//            e.printStackTrace();
        }

        StringBuilder strBuff;
        int index;
        double d;
        // как по условию - "в файле ... записать" - перезаписываем тот же файл
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(outFile, false)))) {
            for (String s : students) {
                strBuff = new StringBuilder(s);
                index = strBuff.indexOf(" ");
                //  считаем, что записана только фамилия (как в условии, без инициалов), с первой позиции
                //  и отделена пробелом(ами), а не табуляцией
                if (index > 0) {
                    try {
                        d = Double.parseDouble(strBuff.substring(index, strBuff.length()).trim());
                        if (d > 7) {
                            strBuff.replace(0, index, strBuff.substring(0, index).toUpperCase(Locale.ROOT));
                        }
//                        System.out.println(strBuff + "   grade: " + d);
                    } catch (NumberFormatException e) {
                        System.out.println("Incorrect grade (decamal separator?) -> " + e);
                    }
                }
                pw.write(strBuff.toString() + '\n');
            }
            System.out.println("File '" + outFile + "' has created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
