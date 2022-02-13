package com.KomSoft.lection16;

import java.io.*;

/*
    Created by Volodymyr P. Komarov aka KomSoft
*/
/*
    8. Прочитать текст Java-программы и удалить из него все «лишние» пробелы и табуляции,
    оставив только необходимые для разделения операторов.
*/
public class DeleteExtraSpaces {
    public static void main(String[] args) {
        String fileName = "FindData.java";
        File inFile = new File(Homework16Common.PROJECT_DIR + File.separator + fileName);
        File outFile = new File(Homework16Common.DATA_DIR + File.separator + Homework16Common.MY_DIR +
                File.separator + "woSpaces_" + fileName);

        new MakeDestDir(Homework16Common.DATA_DIR + File.separator + Homework16Common.MY_DIR);
        try (BufferedReader br = new BufferedReader(new FileReader(inFile));
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(outFile, false)))) {
            String strIn, strOut;
            while ((strIn = br.readLine()) != null) {
//                System.out.println(strIn);
                strOut = strIn.trim().replaceAll("[\s\t]+", " ").replaceAll("\s*[>]\s*", ">").replaceAll("\s*[<]\s*", "<").replaceAll("\s*[=]\s*", "=").replaceAll("\s*[:]\s*", ":").replaceAll("\s*[+]\s*", "+").replaceAll("\s*[-]\s*", "-").replaceAll("\s*[/]\s*", "/");
//                не смог добиться для замены regexp'ом выражений типа " (", "{ " и подобных, чтобы удалять пробелы перед и после скобок
//                strOut = strIn.replaceAll("\s*\u0040]\s*", "(").replaceAll("\s*[\u0041]\s*", ")").replaceAll("\s*[\u0123]\s*", "}").replaceAll("\s*[\u0125]\s*", "{");
//                System.out.println(strOut);
                pw.println(strOut);
            }
            System.out.println("File '" + outFile + "' has created successfully.");
        } catch (IOException e) {
            System.out.println("Error opening stream or I/O Error " + e);
//            e.printStackTrace();
        }
    }
}
