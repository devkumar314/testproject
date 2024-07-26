package tests.OOPS;

abstract class Animal {
    // Abstract method (does not have a body)
    public abstract void makeSound();

    // Regular method (has a body)
    public void sleep() {
        System.out.println("The animal is sleeping.");
    }
}

class Dog extends Animal {
    // Providing implementation for the abstract method
    public void makeSound() {
        System.out.println("The dog says: bark");
    }
}

class Cat extends Animal {
    // Providing implementation for the abstract method
    public void makeSound() {
        System.out.println("The cat says: meow");
    }
}

public class AbstractExample {
    public static void main(String[] args) {
        Animal myDog = new Dog(); // Create a Dog object
        Animal myCat = new Cat(); // Create a Cat object

        myDog.makeSound();
        myDog.sleep();

        myCat.makeSound();
        myCat.sleep();
    }
}
