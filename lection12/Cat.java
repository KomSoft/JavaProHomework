package com.KomSoft.lection12;

/*
    Created by Volodymyr P. Komarov aka KomSoft
*/
/*
    10. Создайте класс Pet и его наследников Cat, Dog, Parrot. Создайте отображение из домашних животных,
    где в качестве ключа выступает имя животного, а в качестве значения класс Pet.
    Добавьте в отображение разных животных. Создайте метод выводящий на консоль все ключи отображения.
*/
public class Cat extends Pet{

    public Cat(String name) {
        super(name);
        voice = "meow";
    }
}
