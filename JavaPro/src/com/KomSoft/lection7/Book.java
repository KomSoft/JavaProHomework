package com.KomSoft.lection7;

/*
    Created by Volodymyr P. Komarov aka KomSoft
*/
public class Book {
    private String name;
    private String author;
    private String publisher;
    private double price;

    public Book(String name, String author, String publisher, double price) {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        if (price < 10) {
            System.out.println("Wrong price. Price to be set 10.");
            this.price = 10.0;
        } else {
            this.price = price;
        }
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 10) {
            System.out.println("Wrong price. Price to be set 10.");
            this.price = 10.0;
        } else {
            this.price = price;
        }
    }

//  можно переопределить toString
    public String getInfo() {
        return name + ", Author: " + author + ", Publisher: " + publisher + ", Price: " + price;
    }

    public static void main(String[] args) {
        Book book1, book2;
        book1 = new Book("Java 7", "Ильдар Хабибулин", "БХВ-Петербург", 200);
        book2 = new Book("Шаблоны проектирования в Java", "Марк Гранд", "Wiley Publishing, Inc", 5);
        System.out.println(book1.getInfo());
        System.out.println(book2.getInfo());
        book2.setPrice(48);
        System.out.println(book2.getInfo());
    }
}
