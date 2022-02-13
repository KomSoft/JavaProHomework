package com.KomSoft.lection16;

import java.io.*;
import java.util.ArrayList;

/*
    Created by Volodymyr P. Komarov aka KomSoft
*/
/*
    10. Прочитать строки из файла и поменять местами первое и последнее слова в каждой строке.
*/
public class SwapFirstLast {
    public static void main(String[] args) {
        String fileName = "DeleteExtraSpaces.java";
        File inFile = new File(Homework16Common.PROJECT_DIR + File.separator + fileName);
        File outFile = new File(Homework16Common.DATA_DIR + File.separator + Homework16Common.MY_DIR +
                File.separator + "swap_" + fileName);

        System.out.println("Try to swap the first word and the last one for each line in file '" + outFile + "'...");
        try (BufferedReader br = new BufferedReader(new FileReader(inFile));
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(outFile, false)))) {
            String strIn;
            StringBuffer strOut;
            String[] words;
            ArrayList<String> arrWords = new ArrayList<>();
            while ((strIn = br.readLine()) != null) {
//                System.out.println(strIn);
/*
//                вот так не работает, потому что лидирующие пробелы берет как слова, и меняет
                words = strIn.split(" ");
                if (words.length > 1) {
                    strOut = new StringBuffer(strIn.replaceFirst(words[0], words[words.length-1]));
                } else {
                    strOut = new StringBuffer(strIn);
                }
*/
/*
//                вот так не работает, выкидывает ошибку на середине текста из-за использования trim().
//                Почему - так и не понял. Воспринимает if(index как неправильный regexp
                words = strIn.trim().split(" ");
*/
//                пришлось пойти по сложному пути, где в методах index и replace не используются regexp
                words = strIn.split(" ");
                arrWords.clear();
//                разделить на слова и убрать пустые слова
                for (String s : words) {
                    if (!s.isEmpty()) {
                        arrWords.add(s);
                    }
                }
                strOut = new StringBuffer(strIn);
                if (arrWords.size() > 1) {
                    int index = strOut.indexOf(arrWords.get(0));
                    String lastWord = arrWords.get(arrWords.size()-1);
                    strOut.replace(index, index + arrWords.get(0).length(), lastWord);
//                    находим второе вхождение последнего слова
                    index = strOut.indexOf(lastWord, index + lastWord.length());
                    strOut.replace(index, index + lastWord.length(), arrWords.get(0));
                }
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
