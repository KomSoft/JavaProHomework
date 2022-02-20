package com.KomSoft.lection12;

import java.util.*;

/*
    Created by Volodymyr P. Komarov aka KomSoft
*/
/*
    4. Пользователь вводит набор чисел в виде одной строки "1, 2, 3, 4, 4, 5".
    Избавиться от повторяющихся элементов в строке и вывести результат на экран.
*/
public class Parse4String {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string, for example '1, 2, 3, 4, 4, 5':");
        String str = scanner.nextLine();
        // парсим по ',' и удаляем пробелы
        String[] stringArr = str.split("[ ,]+", 0);
        for(String s : stringArr) {
            System.out.println(s);
        }
        LinkedHashSet<Integer> setInt = new LinkedHashSet<>();
        if(stringArr.length > 0) {
            for(String s : stringArr) {
                try {
                    setInt.add(Integer.parseInt(s));
                } catch (NumberFormatException e) {
                    System.out.println("Parsing error with element '" + s + "', skipped");
                } catch (IllegalStateException e) {
                    System.out.println("Element '" + s + "\' can't be added");
                }
            }
        } else {
            System.out.println("Nothing to do...");
        }
        System.out.println("Unsorted result: " + setInt);


    }
}
