package com.KomSoft.lection10;

/*
    Created by Volodymyr P. Komarov aka KomSoft
*/
/*
    Создать статический метод который принимает на вход три параметра: login, password и confirmPassword.
    Login должен содержать только латинские буквы, цифры и знак подчеркивания.
    Длина login должна быть меньше 20 символов.
    Если login не соответствует этим требованиям, необходимо выбросить WrongLoginException.

    Password должен содержать только латинские буквы, цифры и знак подчеркивания.
    Длина password должна быть меньше 20 символов. Также password и confirmPassword должны быть равны.
    Если password не соответствует этим требованиям, необходимо выбросить WrongPasswordException.

    WrongPasswordException и WrongLoginException - пользовательские классы исключения с двумя конструкторами –
    один по умолчанию, второй принимает сообщение исключения и передает его в конструктор класса Exception.
    Обработка исключений проводится внутри метода. Используем multi-catch block.
    Метод возвращает true, если значения верны или false в другом случае.
*/
public class LoginRunner {

    public static boolean login(String login, String password, String confirmPassword) {
        String regex = "[a-zA-Z0-9_]+";
        try {
            if(login.length() >= 20 ) {
                throw new WrongLoginException("Login length must to be less than 20 characters");
            }
            if(!login.matches(regex)) {
                throw new WrongLoginException("Login must include only a-z A-Z 0-9 and/or _ symbols");
            }
            if(password.length() >= 20 || confirmPassword.length() >= 20 ) {
                throw new WrongPasswordException("Password length must to be less than 20 characters");
            }
            if(!password.matches(regex) || !confirmPassword.matches(regex)) {
                throw new WrongLoginException("Password must include only a-z A-Z 0-9 and/or _ symbols");
            }
            if(!password.equals(confirmPassword)) {
                throw new WrongPasswordException("Passwords aren't equals!");
            }
            return true;
        }
        catch (WrongLoginException | WrongPasswordException e ) {
            return false;
        }
    }


    public static void main(String[] args) {
        System.out.println(login("userrrrrrrrrrrrrrrrrrrrrrrrrrr", "password_45", "paSsword-36"));
        System.out.println(login("user ^", "pa$$word", "pa$$word"));
        System.out.println(login("user", "pa$$word", "pa$$word"));
        System.out.println(login("userrrrrrrrrrr", "password_45", "paSsword_3666666666666666666666666"));
        System.out.println(login("user", "password_45", "paSsword_36"));
        System.out.println(login("superuser", "password_45", "password_45"));
    }

}
