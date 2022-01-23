package com.KomSoft.lection12;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
    Created by Volodymyr P. Komarov aka KomSoft
*/
/*
    8. Создайте HashMap, содержащий пары значений  - имя игрушки и объект игрушки (класс Product).
    Перебрать и распечатать пары значений - entrySet().
    Перебрать и распечатать набор из имен продуктов  - keySet().
    Перебрать и распечатать значения продуктов - values().
    Для каждого перебора создать свой метод.

*/
public class Product {
    HashMap<String, Toy> toys;

    private class Toy {
        private final String name;
        private final float cost;
        private final String color;

        public Toy(String name, float cost, String color) {
            this.name = name;
            this.cost = cost;
            this.color = color;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Toy{'" + name + "', cost=" + cost + ", color=" + color + '}';
        }
    }

    public Product() {
        toys = new HashMap<>();
    }

    public void add(String toyName, float toyCost, String toyColor) {
        Toy toy = new Toy(toyName, toyCost, toyColor);
        toys.put(toy.getName(), toy);
    }

    public void printEntrySet() {
        Set<Map.Entry<String, Toy>> toyEntries = toys.entrySet();
        for(Map.Entry<String, Toy> entry : toyEntries) {
            System.out.println("Toy: " + entry.getKey() + ":" + entry.getValue());
        }
    }

    public void printKeySet() {
        Set<String> toyNames = toys.keySet();
        for(String toyKey : toyNames) {
            System.out.println("Toy: " + toyKey);
        }
    }

    public void printValues() {
        System.out.println("<<<first>>>");
        Set<Map.Entry<String, Toy>> toyEntries = toys.entrySet();
        for(Map.Entry<String, Toy> entry : toyEntries) {
            System.out.println("Toy: " + entry.getValue());
        }
        System.out.println("<<<second>>>");
        Set<String> keys = toys.keySet();
        for(String key : keys) {
            System.out.println("Toy: " + toys.get(key));
        }

    }


    public static void main(String[] args) {
        Product shelf = new Product();
        shelf.add("Rabbit", 5.4f, "blue");
        shelf.add("Fish", 3f, "gold");
        shelf.add("Cat", 10f, "black");
        shelf.add("Dog", 5.8f, "white");
        shelf.add("Horse", 15f, "ginger");
        shelf.printEntrySet();
        System.out.println();
        shelf.printKeySet();
        System.out.println();
        shelf.printValues();
        System.out.println();

    }
}
