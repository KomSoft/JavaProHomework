package com.KomSoft.lection8;

import java.time.LocalDate;
import java.util.*;

/*
    Created by Volodymyr P. Komarov aka KomSoft
*/
/*
    6. Создать класс Catalog с внутренним классом, с помощью объектов которого
    можно хранить информацию об истории выдач книги читателям.
    выдач книги (!) - т.е. речь идет об одной книге.
*/
public class Catalog {
    // где-то может быть класс с полной инфой о книге (автор, издательство и т.д.,
    // из которого мы берем ID книги и название. Остальную инфу при необходимости обратываем вне класса Catalog.
    private String bookName;
    private int bookId;
    public ArrayList<BookRecord> history;


    // external class Reader (для простоты сделаем его внутренним)
    public static class Reader {
        public int readerId;
        public String readerFirstName;
        public String readerLastName;
        //  ...... other fields

        public Reader(int readerId, String readerFirstName, String readerLastName) {
            this.readerId = readerId;
            this.readerFirstName = readerFirstName;
            this.readerLastName = readerLastName;
        }
    }
    // end of class Reader

    // inner class BookRecord
    private class BookRecord {
        private int readerId;
        private String readerName;
        private LocalDate lendDate;
        private LocalDate returnDate;
        private boolean available;

        public BookRecord(int readerId, String readerName, LocalDate lendDate) {
            this.readerId = readerId;
            this.readerName = readerName;
            this.lendDate = lendDate;
            available = false;
        }

        public void returnBook(LocalDate returnDate) {
            this.returnDate = returnDate;
            available = true;
        }

/*
        public LocalDate getLendDate() {
            return lendDate;
        }

        public LocalDate getReturnDate() {
            return returnDate;
        }

        public boolean isAvailable() {
            return available;
        }
*/
    }
    // end of inner class BookRecord

    public Catalog(String bookName, int bookId) {
        this.bookName = bookName;
        this.bookId = bookId;
        history = new ArrayList<>();
    }

    public boolean isAvailable() {
        return history.isEmpty() || history.get(history.size()-1).available;
    }

    public boolean lend(Reader reader, LocalDate date) {       // выдать книгу
        if(isAvailable()) {
            return history.add(new BookRecord(reader.readerId, reader.readerFirstName, date));
        } else {
            return false;
        }
    }

    public void returnBook(LocalDate date) {
        history.get(history.size()-1).returnBook(date);
    }

    public int getRecCount() {
        return history.size();
    }

    public String getInfo() {
        StringBuilder str = new StringBuilder("Book '" + bookName + "' (id:" + bookId + ") has been lent " + history.size() + " times");
        for(int i = 0; i < history.size(); i++) {
            str.append("\n" + (i+1) + ". " + history.get(i).readerName + " (id:" + history.get(i).readerId + ") took at " + history.get(i).lendDate.toString());
            if(history.get(i).available) {
                str.append(" returned at " + history.get(i).returnDate.toString());
            }
//            str += '\n';
        }
        if(isAvailable()) {
            str.append("\n Book is available for lend.");
        } else {
            str.append("\n Book isn't available.");
        }
        return str.toString();
    }


    public static void main(String[] args) {
        Catalog cat = new Catalog("Java 8", 3256);
        System.out.println(cat.getInfo());
        cat.lend(new Reader(005,"John", "Doe"), LocalDate.of(2010,4,15));
        System.out.println(cat.getInfo());
        cat.lend(new Reader(8,"Sarah", "Connor"), LocalDate.of(2010,5,15));
        System.out.println(cat.getInfo());
        cat.returnBook(LocalDate.of(2010, 5, 20));
        System.out.println(cat.getInfo());
        cat.lend(new Reader(9,"Sarah", "Connor"), LocalDate.of(2010,6,10));
        cat.returnBook(LocalDate.of(2010, 10, 11));
        cat.lend(new Reader(11,"Эльдар", "Хабибулин"), LocalDate.of(2011,1,3));
        cat.returnBook(LocalDate.of(2011, 10, 4));
        cat.lend(new Reader(15,"Иван", "Васильевич"), LocalDate.of(2011,11,1));
        cat.returnBook(LocalDate.of(2012, 3, 5));
        cat.lend(new Reader(18,"Просто", "Лось"), LocalDate.of(2012,5,1));
        cat.returnBook(LocalDate.of(2012, 12, 1));
        System.out.println(cat.getInfo());

    }

}
