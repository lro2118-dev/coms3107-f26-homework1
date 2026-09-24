import java.awt.Color;

public class DrawableRectangle extends DrawableShape {

    protected double width;
    protected double height;

    public DrawableRectangle(double x, double y, Color color,
                             double width, double height) {

        super(x, y, color);

        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double area() {
        return width * height;
    }

    public void draw() {
        StdDraw.setPenColor(color);
        StdDraw.filledRectangle(x, y, width / 2, height / 2);
    }

    public static void main(String[] args) {

        DrawableRectangle rectangle =
                new DrawableRectangle(0.5, 0.5, Color.RED, 0.4, 0.2);

        rectangle.draw();
        System.out.println(rectangle.area());



        DrawableRectangle rectangle2 =
        new DrawableRectangle(0.75, 0.75, Color.BLUE, 0.2, 0.3);

        rectangle2.draw();
      System.out.println(rectangle2.area());
    }
}