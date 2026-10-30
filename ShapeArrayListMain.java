import java.util.ArrayList;

abstract class Shape {
    protected String shapeName;

    public Shape(String shapeName) {
        this.shapeName = shapeName;
    }

    public abstract double calculateArea();

    public void area() {
        System.out.printf("%s Area: %.2f\n", shapeName, calculateArea());
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(String shapeName, double radius) {
        super(shapeName);
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

public class ShapeArrayListMain {
    public static void main(String[] args) {
        ArrayList<Shape> shapesList = new ArrayList<>();

        shapesList.add(new Circle("Small Circle", 3.0));
        shapesList.add(new Circle("Medium Circle", 5.5));
        shapesList.add(new Circle("Large Circle", 10.0));

        System.out.println("=== Calculating Area for Shape Objects in ArrayList ===");
        for (Shape s : shapesList) {
            s.area();
        }
    }
}
