package com.KomSoft.lection4.Students;

/*
	Created by Volodymyr P. Komarov aka KomSoft
*/
public class Student extends Homo {
    private int id;
    private String faculty;
    private float grade;
    private int yearOfEnter;

    public Student(Homo homo, int id, String faculty, float grade, int yearOfEnter) {
        super(homo.getSex(), homo.getYearOfBirth(), homo.getFirstName(), homo.getLastName());
        this.id = id;
        this.faculty = faculty;
        this.grade = grade;
        this.yearOfEnter = yearOfEnter;
    }

    public Student(String sex, int yearOfBirth, String firstName, String lastName, int id, String faculty, float grade, int yearOfEnter) {
        super(sex, yearOfBirth, firstName, lastName);
        this.id = id;
        this.faculty = faculty;
        this.grade = grade;
        this.yearOfEnter = yearOfEnter;
    }

    public Student(Student student) {
        super(student.getSex(), student.getYearOfBirth(), student.getFirstName(), student.getLastName());
        this.id = student.getId();
        this.faculty = student.getFaculty();
        this.grade = student.getGrade();
        this.yearOfEnter = student.getYearOfEnter();
    }

    public int getId() {
        return id;
    }

//TODO в сеттеры добавить проверки
    public void setId(int id) {
        this.id = id;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public int getYearOfEnter() {
        return yearOfEnter;
    }

    public void setYearOfEnter(int yearOfEnter) {
        this.yearOfEnter = yearOfEnter;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + " Student's id: " + id + ", faculty - " + faculty + ", year of enter: " + yearOfEnter + String.format(", grade %.2f", grade) + ".";
    }

    public String getShortInfo() {
        return super.getInfo();
    }

    @Override
    public String toString() {
        return "Student " + getLastName() + " " + getFirstName() + String.format(", grade - %.1f", grade);
    }

    public static void main(String[] args) {
        Homo man = new Homo("male", 2001, "John", "Doe");
        System.out.println(man.getInfo());
        Student stud1 = new Student(man, 1234, "JavaPro", (float) 11.3, 2018);
        System.out.println(stud1.getShortInfo());
        System.out.println(stud1.getInfo());
        System.out.println(stud1);
    }
}
