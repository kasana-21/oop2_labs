package decorator;

// Component interface for rectangle shapes (basic and decorated)
interface Rectangle {
    double calculateArea();
}

// Concrete component class for basic rectangle
class BasicRectangle implements Rectangle {
    private double length;
    private double width;


    public BasicRectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}

// Decorator interface
interface RectangleDecorator extends Rectangle {
    String getFormattedArea();
}

// Concrete decorator for measurement units
class MeasurementUnitDecorator implements RectangleDecorator {
    private Rectangle rectangle;
    private String unit;

    public MeasurementUnitDecorator(Rectangle rectangle, String unit) {
        this.rectangle = rectangle;
        this.unit = unit;
    }

    // Delegate the calculation to the decorated rectangle
    // This allows us to add new decorators without changing the existing code
    @Override
    public double calculateArea() {
        return rectangle.calculateArea();
    }

    // Add the measurement unit to the formatted area
    @Override
    public String getFormattedArea() {
        // Use the calculateArea() method to get the area
        // Then, format the area by adding the measurement unit
        // For example: 100.00 cm^2
        //             200.00 m^2
        return String.format("%.2f %s", calculateArea(), unit);
    }
}

// Concrete decorator for formatting
class FormattingDecorator implements RectangleDecorator {
    private Rectangle rectangle;
    private String format;

    public FormattingDecorator(Rectangle rectangle, String format) {
        this.rectangle = rectangle;
        this.format = format;
    }

    @Override
    public double calculateArea() {
        return rectangle.calculateArea();
    }

    @Override
    public String getFormattedArea() {
        String formattedArea = String.valueOf(calculateArea());

        if (format.equals("scientific")) {
            formattedArea = String.format("%.2e", calculateArea());
        } else if (format.equals("decimal")) {
            formattedArea = String.format("%.2f", calculateArea());
        }

        return formattedArea;
    }
}

// Main program

