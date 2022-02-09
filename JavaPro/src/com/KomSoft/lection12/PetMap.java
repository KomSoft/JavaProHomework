package com.KomSoft.lection12;

import java.util.HashMap;
import java.util.Set;

/*
        Created by Volodymyr P. Komarov aka KomSoft
        */
/*
    10. Создайте класс Pet и его наследников Cat, Dog, Parrot. Создайте отображение из домашних животных,
    где в качестве ключа выступает имя животного, а в качестве значения класс Pet.
    Добавьте в отображение разных животных. Создайте метод выводящий на консоль все ключи отображения.
*/
public class PetMap {
    public HashMap<String, Pet> petMap = new HashMap<>();

    public void printPetName() {
        Set<String> petKey = petMap.keySet();
        for(String s : petKey) {
            System.out.println("Pet: " + s);
        }
    }

    public static void main(String[] args) {
        PetMap pets = new PetMap();
        String name = "Vasyl";
        pets.petMap.put(name, new Cat(name));
        name = "Viskas";
        pets.petMap.put(name, new Cat(name));
        name = "Black";
        pets.petMap.put(name, new Cat(name));
        name = "Sirko";
        pets.petMap.put(name, new Dog(name));
        name = "Spike";
        pets.petMap.put(name, new Dog(name));
        name = "Fluffy";
        pets.petMap.put(name, new Dog(name));
        name = "Mylo";
        pets.petMap.put(name, new Dog(name));
        name = "Bird";
        pets.petMap.put(name, new Parrot(name));
        name = "Chick";
        pets.petMap.put(name, new Parrot(name));
        name = "Cock";
        pets.petMap.put(name, new Parrot(name));
        pets.printPetName();
    }
}
