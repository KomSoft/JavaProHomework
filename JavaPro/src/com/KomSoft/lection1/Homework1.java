package com.KomSoft.lection1;

import java.util.Scanner;

/*
	Created by Volodymyr P. Komarov aka KomSoft
*/
public class Homework1 {

/*
    1 - Написать в (public static void main) методе код, проверяющий и сообщающий в консоль, является ли целое число записанное в переменную a, чётным либо нечётным.

    пример вывода:
    имея int a=5

    результат должен быть таким:
    Число 5 - нечетное

    либо имея int а=4,

    результат должен быть таким:
    Число 4 - четное        
*/
    public static void main(String[] args) {
	// write your code here
        Scanner console = new Scanner(System.in);
        System.out.print("Введите целое число:");
        int  intNum = console.nextInt();
        // вариант 1
        if ( (intNum % 2) == 0 ) {
            System.out.println("Число " + intNum + " - четное.");
        } else {
            System.out.println("Число " + intNum + " - нечетное.");
        }
        // вариант 2
        System.out.println( (intNum % 2) == 0  ? "Число " + intNum + " - четное." : "Число " + intNum + " - нечетное.");
        // вариант 3
        String mod = "";
        if ( intNum % 2 != 0 ) {
            mod = "не";
        }
        System.out.println(String.format("Число %d - %sчетное.", intNum, mod));

/*
    2 - Написать в (public static void main) методе код,
    который переставит числа в переменных таким образом,
    чтобы при выводе в консоль их последовательность оказалась возрастающей.

    пример вывода:
    имея int a=5,b=4,c=2;
    либо int a=4,b=5,c=2;
    либо int a=5,b=2,c=4;
    результат должен быть таким:
    последовательность - 2 4 5      
*/
        int tmp;
        System.out.print("Введите 3 целых числа a, b и с (по одному). a = ");
        int a = console.nextInt();
        System.out.print("b = ");
        int b = console.nextInt();
        System.out.print("c = ");
        int c = console.nextInt();
         if ( a > b ) {
             tmp = b; b = a; a = tmp;
         }
        if ( b > c ) {
            tmp = c; c = b; b = tmp;
        }
        if ( a > b ) {
            tmp = b; b = a; a = tmp;
        }
        System.out.println(String.format("последовательность - %d %d %d", a, b, c));
    }
}
