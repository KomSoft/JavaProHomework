package com.KomSoft.lection4.Students;

/*
	Created by Volodymyr P. Komarov aka KomSoft
*/
public class Homo {
    private String sex;
    private int yearOfBirth;
    private String firstName, lastName;

    public Homo(String sex, int yearOfBirth, String firstName, String lastName) {
        setSex(sex);
        setYearOfBirth(yearOfBirth);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getSex() {
        return sex;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

//TODO неплохо бы установить проверки хотя бы на возраст
    public void setSex(String sex) {
/*        switch (sex.toUpperCase()) {
            case "MALE" : {
                this.sex = "male";
                break;
            }
            case "FEMALE" : {
                this.sex = "female";
                break;
            }
            default : {
                this.sex = "unknown";
            }
        }
 */
        this.sex = "unknown";
        if (sex.equalsIgnoreCase("MALE")) {
            this.sex = "male";
        }
        if (sex.equalsIgnoreCase("FEMALE")) {
            this.sex = "female";
        }
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getInfo(){
        return firstName + " " + lastName + " (" + sex + ") born in " + yearOfBirth + ".";
    }
}
