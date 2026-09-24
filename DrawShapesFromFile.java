import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DrawShapesFromFile {

    public static DrawableShape[] readFile(String filename) {

        Scanner reader;

        try {
            reader = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            return new DrawableShape[0];
        }

        int numberOfShapes = reader.nextInt();

        DrawableShape[] shapes = new DrawableShape[numberOfShapes];

        for (int i = 0; i < shapes.length; i++) {

            String type = reader.next();

            double x = reader.nextDouble();
            double y = reader.nextDouble();

            String colorName = reader.next();

            Color color = null;

            if (colorName.equals("red") == true) {
                color = Color.RED;
            } else if (colorName.equals("blue") == true) {
                color = Color.BLUE;
            } else if (colorName.equals("green") == true) {
                color = Color.GREEN;
            }

            if (type.equals("c") == true) {

                double radius = reader.nextDouble();

                shapes[i] =
                        new DrawableCircle(x, y, color, radius);

            } else {

                double width = reader.nextDouble();
                double height = reader.nextDouble();

                shapes[i] =
                        new DrawableRectangle(x, y, color, width, height);
            }
        }

        reader.close();

        return shapes;
    }


    public static void main(String[] args) {

        DrawableShape[] shapes = readFile(args[0]);

        for (int i = 0; i < shapes.length; i++) {
            shapes[i].draw();
        }
    }
}