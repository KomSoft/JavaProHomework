package com.KomSoft.lection8;

import java.time.LocalDate;

public class DepartmentRunner {

    public static void main(String[] args) {
        Department dept = new Department("IT department", 25);
        dept.addPosition(1, "Head of Department");
        dept.addPosition(2, "Специалист");
        dept.addPosition(3, "Специалист");
        dept.addPosition(4, "Специалист");
        dept.addPosition(5, "Главный специалист");
        dept.addPosition(10, "Консультант");
        dept.addPosition(11, "Консультант");
        System.out.println(dept.getActivePositionList());
        dept.deactivatePosition(4);
        System.out.println("Тасуем специалистов..... ");
        // не должно пройти, т.к. неактивна
        dept.hireAtPosition(4, "John", "Inactive", 100, LocalDate.of(2000, 05, 15));
        dept.hireAtPosition(3, "John", "Doe", 101, LocalDate.of(2000, 01, 15));
        // не должно пройти, т.к. не уволен предыдущий
        dept.hireAtPosition(3, "John", "Doe-2", 102, LocalDate.of(2000, 05, 15));
        System.out.println(dept.getEmployeeAtPosition(3));
        dept.fireFromPosition(3, 101, LocalDate.of(2000, 06, 20));
        System.out.println(dept.getEmployeeAtPosition(3));
        dept.hireAtPosition(3, "Sarah", "Connor", 103, LocalDate.of(2000, 06, 21));
        dept.fireFromPosition(3,  103, LocalDate.of(2001, 03, 8));
        dept.hireAtPosition(3, "Jason", "Statham", 104, LocalDate.of(2001, 04, 1));

        System.out.println(dept.getAllPositionList());
        System.out.println(dept.getEmployeeAtPosition(25));
        System.out.println(dept.getEmployeeAtPosition(2));
        System.out.println(dept.getEmployeeAtPosition(3));
        System.out.println(dept.getPositionHistory(3));

    }
}
