package tests.AbstractInterfaceClassTest;

//Java Program to Illustrate Concept of Interface



//Interface Shape
interface Shape1 {
 // Abstract method draw
 void draw();
 // Abstract method area
 double area();
}

//Rectangle class that implements the Shape interface
class Rectangle1 implements Shape1 {
 int length, width; // Length and width of the rectangle

 // Constructor for Rectangle
 Rectangle1(int length, int width) {
     this.length = length;
     this.width = width;
 }

 // Implementation of the abstract method draw
 @Override
 public void draw() {
     System.out.println("Rectangle has been drawn");
 }

 // Implementation of the abstract method area
 @Override
 public double area() {
     return length * width; // Calculate the area of the rectangle
 }
}

//Circle class that implements the Shape interface
class Circle1 implements Shape1 {
 double pi = 3.14; // Value of pi
 int radius; // Radius of the circle

 // Constructor for Circle
 Circle1(int radius) {
     this.radius = radius;
 }

 // Implementation of the abstract method draw
 @Override
 public void draw() {
     System.out.println("Circle has been drawn");
 }

 // Implementation of the abstract method area
 @Override
 public double area() {
     return pi * radius * radius; // Calculate the area of the circle
 }
}

//Main class to test the implementation
public class InterfaceTest {
 public static void main(String[] args) {
     Shape1 rect = new Rectangle1(2, 3); // Create a Rectangle object
     System.out.println("Area of rectangle: " + rect.area()); // Print the area of the rectangle

     Shape1 circle = new Circle1(2); // Create a Circle object
     System.out.println("Area of circle: " + circle.area()); // Print the area of the circle
 }
}
