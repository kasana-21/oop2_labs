package decorator;

public class runDecorator {
    public static void main(String[] args) {
        // Create a basic rectangle
        Rectangle rectangle = new BasicRectangle(5, 90);

        // Add measurement unit decorator
        RectangleDecorator unitDecorator = new MeasurementUnitDecorator(rectangle, "cm");

        // Add formatting decorator
        RectangleDecorator formattingDecorator = new FormattingDecorator(unitDecorator, "decimal");

        // Calculate and display the area
        System.out.println("Area: " + formattingDecorator.getFormattedArea());
    }
}
