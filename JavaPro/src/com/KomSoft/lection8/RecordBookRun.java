package com.KomSoft.lection8;

import java.time.LocalDate;

public class RecordBookRun {

    public static void main(String[] args) {
//        int sessionCount = 3;
        RecordBook rBook = new RecordBook("John", "Doe", "ITEA Academy", "JavaPro", 615);
        rBook.addSession(LocalDate.of(2022, 02, 01), LocalDate.of(2022, 02, 14));
        rBook.addSession(LocalDate.of(2022, 06, 15), LocalDate.of(2022, 07, 05));
        rBook.addSession(LocalDate.of(2022, 12, 25), LocalDate.of(2023, 01, 13));
        System.out.println("\nИнформация про зачетку: " + rBook.getBookInfo());
        System.out.println("\nКраткая информация про сессии: \n" + rBook.getShortInfo());

        System.out.println("Заполняем первую сессию....");
        rBook.session[0].addTest(LocalDate.of(2022, 02, 01), "Основы программирования");
        rBook.session[0].addTest(LocalDate.of(2022, 02, 03), "Что такое JDK?");
        rBook.session[0].addExam(LocalDate.of(2022, 02, 05), "Встроенные типы данных, операции над ними");
        rBook.session[0].addExam(LocalDate.of(2022, 02, 07), "Объектно-ориентированное программирование в Java");
//        System.out.println("Краткая информация по сессии #1: \n\t" + rBook.session[0].getShortSessionInfo());
//        System.out.println("Полная информация по сессии #1: \n\t" + rBook.session[0].getSessionInfo());

        System.out.println("Заполняем вторую сессию....");
        rBook.session[1].addTest(LocalDate.of(2022, 06, 16), "Основы HTML");
        rBook.session[1].addExam(LocalDate.of(2022, 06, 18), "Пакеты, интерфейсы и перечисления");
        rBook.session[1].addTest(LocalDate.of(2022, 06, 21), "Основы CSS");
        rBook.session[1].addExam(LocalDate.of(2022, 06, 28), "Классы-оболочки и generics");
        rBook.session[1].addExam(LocalDate.of(2022, 06, 30), "Работа со строками");

        System.out.println("Заполняем третью сессию....");
        rBook.session[2].addTest(LocalDate.of(2022, 12, 27), "Установка Windows 11");
        rBook.session[2].addExam(LocalDate.of(2023, 01, 03), "Классы-коллекции");
        rBook.session[2].addExam(LocalDate.of(2023, 01, 06), "Классы-утилиты");
        rBook.session[2].addExam(LocalDate.of(2023, 01, 07), "Принципы построения графического интерфейса");
        rBook.session[2].addExam(LocalDate.of(2023, 01, 10), "Графические примитивы");
        rBook.session[2].addExam(LocalDate.of(2023, 01, 11), "Основные компоненты AWT");

        for(int i = 0; i < rBook.getRecordsCount(); i++) {
            System.out.println("Краткая информация по сессии #" + (i + 1) + ": \n\t" + rBook.session[i].getShortSessionInfo());
            System.out.println("Полная информация по сессии #" + (i + 1) + ": \n\t" + rBook.session[i].getSessionInfo());
        }

        System.out.println("\n  >>>>>  Прошло полгода..... и полторы сесии....  <<<<<");
        // сдаем экзамены и пересдачи...
        rBook.session[0].setGradeBySubject("Основы программирования", 1);   // зачет сдан
        rBook.session[0].setGradeBySubject("Что такое JDK?", 11);           // зачет сдан
        rBook.session[0].setGradeBySubject("Встроенные типы данных, операции над ними", 11);    // экзамен сдан
        rBook.session[0].setGradeBySubject("Объектно-ориентированное программирование в Java", 12); // экзамен сдан

        rBook.session[1].setGradeBySubject("Основы HTML", 1);       // зачет сдан
        rBook.session[1].setGradeBySubject("Пакеты, интерфейсы и перечисления", 1);     // экзамен не сдан
        rBook.session[1].setGradeBySubject("Основы CSS", 0);        // зачет не сдан
        rBook.session[1].setGradeBySubject("Классы-оболочки и generics", 10);   // экзамен сдан
        rBook.session[1].setGradeBySubject("Работа со строками", 8);       // экзамен сдан
        // майские прошли не зря, имеем 2 пересдачи
        rBook.session[1].addExam(LocalDate.of(2022, 06, 25), "Пакеты, интерфейсы и перечисления");
        rBook.session[1].addTest(LocalDate.of(2022, 07, 02), "Основы CSS");
        rBook.session[1].setGradeBySubject("Пакеты, интерфейсы и перечисления", 11);     // экзамен сдан со второй попытки

        //  до 3-й сессии еще не дожили....

        System.out.println("Полная информация по зачетке: \n" + rBook.getFullInfo());

    }

}
