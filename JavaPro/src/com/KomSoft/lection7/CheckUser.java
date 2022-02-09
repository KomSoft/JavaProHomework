package com.KomSoft.lection7;

import java.util.Scanner;

/*
    Created by Volodymyr P. Komarov aka KomSoft
*/
public class CheckUser {

    public static void main(String[] args) {
        String name;
        String password;
        User user1 = new User("John", "1234");
        User user2 = new User("John", "1234");
        User user3 = new User("John", "12345");
        User user4 = new User("Mary", "1234");
        System.out.println(user1.equals(user2));
        System.out.println(user1.equals(user3));
        System.out.println(user1.equals(user4));
//        System.out.println(user1.user);
//        System.out.println(user1.password);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter user name: ");
        name = scanner.nextLine();
        System.out.print("Enter user password: ");
        password = scanner.nextLine();
        if(user1.login(name, password)) {
            System.out.println("Access granted.");
        } else {
            System.out.println("Access denied.");
        }
        System.out.println("    Next Chance! Do your know the default user?");
        User userDef = new User("", "");
        System.out.print("Enter user name: ");
        name = scanner.nextLine();
        System.out.print("Enter user password: ");
        password = scanner.nextLine();
        if(userDef.login(name, password)) {
            System.out.println("You won!");
        } else {
            System.out.println("You lost...");
        }

    }
}
