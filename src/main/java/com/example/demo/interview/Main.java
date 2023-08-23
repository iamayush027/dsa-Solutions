package com.example.demo.interview;

class Animal {
    public void talk() {
        System.out.println("Animal is making a sound.");
    }
}

class Dog extends Animal {
    @Override
    public void talk() {
        System.out.println("Woof!");
    }
}

class Cat extends Animal {
    @Override
    public void talk() {
        System.out.println("Meow!");
    }
    public void talk(String talk) {
        System.out.println("Meow!"+talk);
    }
}

public class Main {
    public static void makeAnimalTalk(Animal animal) {
        animal.talk();
    }

    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal cat = new Cat();
        Animal animal = new Animal();
        makeAnimalTalk(dog);  // Output: Woof!
        makeAnimalTalk(cat);
        makeAnimalTalk(animal);// Output: Meow!
    }
}

