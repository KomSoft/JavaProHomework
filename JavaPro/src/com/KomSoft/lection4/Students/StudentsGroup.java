package com.KomSoft.lection4.Students;

/*
	Created by Volodymyr P. Komarov aka KomSoft
*/
public class StudentsGroup {
    private final static int MAX_STUDENTS = 10;
    private Student[] students = new Student[MAX_STUDENTS];
    private int countOfStudents;

    public StudentsGroup() {
        this.clear();
    }

    // записывает не больше MAX_STUDENTS экземпляров
    public StudentsGroup(Student[] students) {
        this.clear();
        countOfStudents = students.length <= MAX_STUDENTS ? students.length : MAX_STUDENTS;
        for(int i = 0; i < countOfStudents; i++) {
            this.students[i] = new Student(students[i]);
        }
    }

    public void clear() {
        countOfStudents = 0;
        for (int i = 0; i < MAX_STUDENTS; i++) {
            students[i] = null;
        }
    }

    public int getCountOfStudents() {
        return countOfStudents;
    }

    public boolean isEmpty() {
        return countOfStudents == 0;
    }

    public boolean isFull() {
        return countOfStudents == MAX_STUDENTS;
    }

    public boolean addStudent(Student student) {
        if ( countOfStudents < MAX_STUDENTS) {
            students[countOfStudents++] = new Student(student);
            return true;
        } else {
            return false;
        }
    }

//  поиск студента по id
    public int findStudent(int id) {
        int result = -1;
        for(int i = 0;(result < 0) && (i < countOfStudents); i++) {
            if ( students[i].getId() == id ) {
                result = i;
                return result;
            }
        }
        return result;
    }

    //  поиск студента по фамилии, при обинаковых фимилиях найдет только первого - TODO
    public int findStudent(String lastName) {
        int result = -1;
        for(int i = 0; (result < 0) && (i < countOfStudents); i++) {
            if ( students[i].getLastName().equalsIgnoreCase(lastName) ) {
                result = i;
            }
        }
        return result;
    }

    public boolean delStudent(int id) {
        // если нашли студента
        int ind = this.findStudent(id);
        if ( ind >= 0 ) {
            for(int i = ind; i < countOfStudents-1; i++) {
                students[i] = students[i+1];
            }
            countOfStudents--;
            return true;
        } else {
            return false;
        }
    }

    public boolean delStudent(String lastName) {
        // если нашли студента
        int ind = this.findStudent(lastName);
        if ( ind >= 0) {
            for(int i = ind; i < countOfStudents-1; i++) {
                students[i] = students[i+1];
            }
            countOfStudents--;
            return true;
        } else {
            return false;
        }
    }

    public String getGroupList() {
        String s = "";
        for(int i = 0; i < countOfStudents; i++) {
            s += students[i].getInfo() + "\n";
        }
        return s;
    }

    public String getShortGroupList() {
        String s = "";
        for(int i = 0; i < countOfStudents; i++) {
            s += students[i] + "\n"; // используем toString
        }
        return s;
    }

    @Override
    public String toString() {
        // сортируем, не меняя основной массив, используем новый массив индексов (пузырьками)
        int[] indArr = new int[countOfStudents];
        int tmp;
        for(int i = 0; i < countOfStudents; i++) {
            indArr[i] = i;
        }

/*
        for (int out = elems - 1; out >= 1; out--){  //Внешний цикл
            for (int in = 0; in < out; in++){       //Внутренний цикл
                if(a[in] > a[in + 1])               //Если порядок элементов нарушен
                    toSwap(in, in + 1);             //вызвать метод, меняющий местами
*/

        for(int j = countOfStudents - 1; j >= 1; j--) {
            for(int k = 0; k < j; k++) {
                if ( students[indArr[k]].getLastName().compareToIgnoreCase(students[indArr[k+1]].getLastName()) > 0 ) {
//TODO по-идее если lastName равны, то еще добавить сравнение по firstName
                   tmp = indArr[k];
                   indArr[k] = indArr[k+1];
                   indArr[k+1] = tmp;
                }
            }
        }
        String s = "";
        for(int i = 0; i < countOfStudents; i++) {
            s += students[indArr[i]].getInfo() + "\n";
            // для проверки выводим индексы
//            s += indArr[i] + " ";
        }
        return s;
    }

    public static void main(String[] args) {
        StudentsGroup sg = new StudentsGroup();
        sg.addStudent(new Student("male", 2001, "John", "Doe", 1234, "JavaPro", (float) 11.3, 2018));
        sg.addStudent(new Student("female", 2003, "Mary", "Kay", 1235, "JavaPro", (float) 10.4, 2018));
        sg.addStudent(new Student("female", 1970, "Sarah", "Connor", 1236, "JavaPro", (float) 15, 2018));
        sg.addStudent(new Student("male", 1990, "John", "Connor", 1256, "JavaPro", (float) 5, 2018));
        sg.addStudent(new Student("male", 1998, "Nick", "Dale", 1258, "JavaPro", (float) 9, 2018));
        System.out.println("Count of students: " + sg.countOfStudents);
        System.out.println(sg.getGroupList());
        System.out.println("Student's index \"Connor\" is " + sg.findStudent("Connor"));
        System.out.println("Student's index \"Vasyl\" is " + sg.findStudent("Vasyl"));
        System.out.println("Student's index \"id:1234\" is " + sg.findStudent(1234));
        System.out.println("Student's index \"id:4569\" is " + sg.findStudent(4569));
        System.out.println("\n" + sg.getShortGroupList());
        sg.delStudent("Kay");
        System.out.println(sg.getShortGroupList());
        sg.addStudent(new Student("female", 2005, "Ann", "Bird", 1260, "JavaPro", (float) 8.5, 2018));
        sg.addStudent(new Student("male", 2004, "James", "Bond", 1261, "JavaPro", (float) 9.8, 1993));
        System.out.println(sg.getShortGroupList());
        System.out.println(sg);     // используем переопределенный toString

    }
}
