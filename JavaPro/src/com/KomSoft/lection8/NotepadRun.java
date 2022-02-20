package com.KomSoft.lection8;

import java.time.LocalDate;

/*
    Created by Volodymyr P. Komarov aka KomSoft
*/
public class NotepadRun {

    public static void main(String[] args) {
        Notepad plan = new Notepad();
        plan.addTask(2021, 12, 31, "Get off all bad things");
        plan.addTask(2021,12, 31, "Do shopping");
        plan.addTask(2021,12, 31, "Celebrate New Year");
        plan.addTask(2021, 12, 31, "Drink!");
        plan.printPlan();
        plan.addTask(2022, 1, 1, "Call all my friends");
        plan.addTask(2022, 1, 1, "Call all my friends");
        plan.addTask(2022, 1, 1, "Go to my Mom");
        plan.printPlan();
//        plan.getTasksByDate(LocalDate.of(2021, 12, 31));
        plan.printFullPlan();
        String task1 = "Do shopping";
        if (plan.deleteTask(task1)) {
            System.out.println("Task '" + task1 + "' successfully deleted!");
        } else {
            System.out.println("Task '" + task1 + "' didn't delete!");
        }
        task1 = "Do work";
        if (plan.deleteTask(task1)) {
            System.out.println("Task '" + task1 + "' successfully deleted!");
        } else {
            System.out.println("Task '" + task1 + "' didn't delete!");
        }
        plan.printPlan();
        plan.getTasksByDate(LocalDate.of(2021, 12, 31));

    }
}
