abstract class Shape {
    abstract double area();
}

class Circle extends Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    double area() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    double length;
    double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    double area() {
        return length * width;
    }
}

class Triangle extends Shape {
    double base;
    double height;

    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    double area() {
        return 0.5 * base * height;
    }
}

public class ShapeDemo {
    public static void main(String[] args) {

        Shape[] shapes = {
            new Circle(5),
            new Rectangle(10, 4),
            new Triangle(8, 6),
            new Circle(3)
        };

        double total = 0;
        double largest = 0;

        for (Shape shape : shapes) {
            double area = shape.area();

            System.out.printf("area: %.2f%n", area);

            total += area;

            if (area > largest) {
                largest = area;
            }
        }

        System.out.printf("total area: %.2f%n", total);
        System.out.printf("largest area: %.2f%n", largest);
    }
}