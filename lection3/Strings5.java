package com.KomSoft.lection3;

import java.util.ArrayList;
import java.util.List;

/*
	Created by Volodymyr P. Komarov aka KomSoft
*/
public class Strings5 {

/*
    5. Напишите программу Java для печати элементов списка содержат все символы данного слова.

    The given strings are: rabbit   bribe   dog
    The given word is: bib

    The strings containing all the letters of the given word are:
    rabbit
    bribe
*/
    private static boolean checkExistance(String str1, String strToSearch) {
        char chhr;
        int[] a = new int[Character.MAX_VALUE+1];
        for (int i = 0; i < str1.length(); i++) {
            chhr = str1.charAt(i);
            ++a[chhr];
        }
/*
        //  Этот алгоритм тоже не совсем верный, потому что там, где if (a[chhr] >= 1 ) { chk = 1; }
        //  этот флаг нигде не сбрасывается. Т.е. достаточно одной совпавшей буквы.
        //  Или если написать rabit - тоже сработает.
        int chk = 0;
        for (int i = 0; i < strToSearch.length(); i++) {
            chhr = strToSearch.charAt(i);
            if ( a[chhr] >= 1 ) {
                chk = 1;
            }
        }
        return ( chk == 1 ) ;
*/
/*
        // так работает наверняка
        for (int i = 0; i < strToSearch.length(); i++) {
            a[strToSearch.charAt(i)]--;
        }
        boolean chk = true;
        for (int i = 0; chk && i < a.length; i++) {
            chk = !(a[i] < 0);
            // как только встретили букву, которой нет (или их меньше, чем в testWord) - сбросить флаг и закончить
        }
*/
        // так работает наверняка - еще опимизировано ментором :)
        boolean chk = true;
        for (int i = 0; chk && i < strToSearch.length(); i++) {
            chk = --a[strToSearch.charAt(i)] >= 0;
            // как только встретили букву, которой нет (или их меньше, чем в testWord) - сбросить флаг и закончить
        }

        return chk;
    }


    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("rabbit");
        list.add("bribe");
        list.add("dog");
        String testWord = "dib";
        System.out.print("The given string are: ");
        for(int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println("\nThe given word is '" + testWord + "'");
        System.out.println("The strings contain all the letter of the given word are: ");
        for(int i = 0; i < list.size(); i++) {
            if (checkExistance(list.get(i), testWord) ) {
                System.out.println(list.get(i));
            }
        }


    }
}
