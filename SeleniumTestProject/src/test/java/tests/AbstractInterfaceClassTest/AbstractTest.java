package tests.AbstractInterfaceClassTest;

// Java Program to Illustrate Concept of Abstract Class



// Class 1
// Abstract class Shape
abstract class Shape {
    String objectName = " "; // Name of the shape

    // Constructor for Shape
    Shape(String name) { 
        this.objectName = name; 
    }

    // Non-abstract method to move the shape
    public void moveTo(int x, int y) {
        System.out.println(this.objectName + " has been moved to x = " + x + " and y = " + y);
    }

    // Abstract method for calculating area
    abstract public double area();
    // Abstract method for drawing the shape
    abstract public void draw();
}

// Rectangle class that extends the abstract class Shape
class Rectangle extends Shape {
    int length, width; // Length and width of the rectangle

    // Constructor for Rectangle
    Rectangle(int length, int width, String name) {
        super(name);
        this.length = length;
        this.width = width;
    }

    // Implementation of the abstract method draw
    @Override 
    public void draw() {
        System.out.println("Rectangle has been drawn ");
    }

    // Implementation of the abstract method area
    @Override 
    public double area() {
        return (double)(length * width); // Calculate the area of the rectangle
    }
}

// Circle class that extends the abstract class Shape
class Circle extends Shape {
    double pi = 3.14; // Value of pi
    int radius; // Radius of the circle

    // Constructor for Circle
    Circle(int radius, String name) {
        super(name);
        this.radius = radius;
    }

    // Implementation of the abstract method draw
    @Override 
    public void draw() {
        System.out.println("Circle has been drawn ");
    }

    // Implementation of the abstract method area
    @Override 
    public double area() {
        return (double)(pi * radius * radius); // Calculate the area of the circle
    }
}

// Main class to test the implementation
class AbstractTest {
    public static void main(String[] args) {
        Shape rect = new Rectangle(2, 3, "Rectangle"); // Create a Rectangle object
        System.out.println("Area of rectangle: " + rect.area()); // Print the area of the rectangle
        rect.moveTo(1, 2); // Move the rectangle
        
        System.out.println(" ");
        
        Shape circle = new Circle(2, "Circle"); // Create a Circle object
        System.out.println("Area of circle: " + circle.area()); // Print the area of the circle
        circle.moveTo(2, 4); // Move the circle
    }
}