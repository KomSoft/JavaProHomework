package com.KomSoft.lection12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/*
    Created by Volodymyr P. Komarov aka KomSoft
*/
/*
    Runner for task 9. Создать класс Student, содержащий следующие характеристики – имя, группа, курс, оценки по предметам.
    Создать коллекцию, содержащую объекты класса Student.
    Написать метод, который удаляет студентов со средним баллом <3.
    Если средний балл>=3, студент переводится на следующий курс.
    Напишите метод printStudents(List<Student> students, int course), который получает список студентов и номер курса.
    А также печатает на консоль имена тех студентов из списка, которые обучаются на данном курсе.
*/
public class StudentRunner {
    // т.к. будем чаще искать и читать, чем удалять и добавлять из середины. Поэтому Array а не Linked
    public ArrayList<Student> studList = new ArrayList<>();
    private final int BOUND_GRADE = 3;

    public void printStudents(ArrayList<Student> students, int course) {
        // if course < 0 print all students
        for(Student student : students) {
            if(course < 0) {
                System.out.println(student);
            } else {
                if(student.getCourse() == course) {
                    System.out.println(student);
                }
            }
        }
    }

    public void promoteStudentsIf() {
        Iterator<Student> it = studList.iterator();
        Student student;
        while(it.hasNext()) {   // просто, чтобы потренировать итератор
            student = it.next();
            if(student.getAverageGrade() >= BOUND_GRADE) {
                student.promote();
            }
        }
    }
    
    public void removeFool(){
        int i = 0;
        while(i < studList.size()) {
            if(studList.get(i).getAverageGrade() < BOUND_GRADE) {
                studList.remove(i);
            } else {
                i++;
            }
        }
    }
    
    public static void main(String[] args) {
        StudentRunner studs = new StudentRunner();
        studs.studList.add(new Student("John", "Comp. Sc."));
        studs.studList.add(new Student("Sarah", "Comp. Sc."));
        studs.studList.add(new Student("Mike", "Comp. Sc."));
        studs.studList.add(new Student("Nick", "Comp. Sc."));
        studs.studList.add(new Student("Vasyl", "Comp. Sc."));
        studs.studList.add(new Student("Julie", "Comp. Sc."));
        studs.studList.add(new Student("Rob", "Biology"));
        studs.studList.add(new Student("Bob", "Biology"));
        studs.studList.add(new Student("Cate", "Biology"));
        studs.studList.add(new Student("Elijah", "Biology"));
        studs.studList.add(new Student("Abraham", "Biology"));
        studs.studList.add(new Student("Sebastian", "Biology"));
        studs.studList.add(new Student("Arnold", "Biology"));
        studs.studList.add(new Student("Jane", "Philosophy"));
        studs.studList.add(new Student("Alice", "Philosophy"));
        studs.studList.add(new Student("Mike", "Philosophy"));
        studs.studList.add(new Student("Nikolas", "Philosophy"));
        studs.studList.add(new Student("Jason", "Philosophy"));
        studs.studList.add(new Student("Natalie", "Philosophy"));
        Random rand = new Random();
        for(Student st : studs.studList) {
            int course = rand.nextInt(3) + 1;
            for(int i = 1; i < course; i++) {
                st.promote();           // переводим на рандомный курс
            }
            int maxGrade = rand.nextInt(12) + 1;    // from 2 to 12
            for(int i = 0; i < st.getCourse(); i++) {   // на каждом курсе получает по 5 оценок, не выше maxGrade
                st.addGrades((rand.nextInt(maxGrade)+1), (rand.nextInt(maxGrade)+1), (rand.nextInt(maxGrade)+1), (rand.nextInt(maxGrade)+1), (rand.nextInt(maxGrade)+1));
            }
        }
        studs.printStudents(studs.studList,-1);
        System.out.println();
        studs.printStudents(studs.studList,1);
        System.out.println();
        studs.printStudents(studs.studList,2);
        System.out.println();
        studs.printStudents(studs.studList,3);
        System.out.println();
        studs.printStudents(studs.studList,4);
        System.out.println();
        System.out.println("Переводим на след курс успешных студентов.");
        studs.promoteStudentsIf();
        studs.printStudents(studs.studList,1);
        System.out.println();
        studs.printStudents(studs.studList,2);
        System.out.println();
        studs.printStudents(studs.studList,3);
        System.out.println();
        studs.printStudents(studs.studList,4);
        System.out.println();
        studs.printStudents(studs.studList,5);
        System.out.println();
        System.out.println("Выгоняем двоечников.");
        studs.removeFool();
        studs.printStudents(studs.studList,1);
        System.out.println();
        studs.printStudents(studs.studList,2);
        System.out.println();
        studs.printStudents(studs.studList,3);
        System.out.println();
        studs.printStudents(studs.studList,4);
        System.out.println();
        studs.printStudents(studs.studList,5);
        System.out.println();
    }
}
