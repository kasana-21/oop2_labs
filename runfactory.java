package factory;
import factory.Shape;
import factory.ShapeFactory;

import java.util.Random;
import java.util.Scanner;

public class runfactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShapeFactory shapeFactory = new ShapeFactory();
        Random random = new Random();

        System.out.print("Enter the number of shapes to generate: ");
        int numberOfShapes = scanner.nextInt();

        for (int i = 0; i < numberOfShapes; i++) {
            int randomNumber = random.nextInt(2); // Generates random number between 0 and 1

            String shapeType;
            if (randomNumber == 0) {
                shapeType = "circle";
            } else {
                shapeType = "rectangle";
            }

            Shape shape = shapeFactory.createShape(shapeType);
            if (shape != null) {
                shape.draw();
            }
        }

        scanner.close();
    }
}

