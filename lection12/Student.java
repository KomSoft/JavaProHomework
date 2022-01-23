package com.KomSoft.lection12;

import java.util.ArrayList;

/*
    Created by Volodymyr P. Komarov aka KomSoft
*/
/*
    9. Создать класс Student, содержащий следующие характеристики – имя, группа, курс, оценки по предметам.
    Создать коллекцию, содержащую объекты класса Student.
    Написать метод, который удаляет студентов со средним баллом <3.
    Если средний балл>=3, студент переводится на следующий курс.
    Напишите метод printStudents(List<Student> students, int course), который получает список студентов и номер курса.
    А также печатает на консоль имена тех студентов из списка, которые обучаются на данном курсе.
*/
public class Student {
    private final String name;
    private String group;
    private int course;
    private ArrayList<Integer> grades;    // можно и мапу, если есть будут названия предметов

    public Student(String studentName, String group) {
        name = studentName;
        this.group = group;
        course = 1;
//        grades = new List<Integer>[];
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public int getCourse() {
        return course;
    }

    public void promote() {
        if(course < 5 ) {
            course++;
        }
    }

    public float getAverageGrade() {
        if(grades == null || grades.isEmpty()) {
            return 0;
        }
        float average = 0f;
        for(int grade : grades) {
            average += grade;
        }
        return average / grades.size();
    }

    public void addGrades(int... newGrades) {
        if(grades == null) {
            this.grades = new ArrayList<>(newGrades.length);
        }
        for(int i = 0; i < newGrades.length; i++) {
            this.grades.add(newGrades[i]);
        }
    }


    @Override
    public String toString() {
        return "Student{ " + name + " (group=" + group + "), course=" + course + ", aver.grade=" + getAverageGrade() + '}';
    }
}
