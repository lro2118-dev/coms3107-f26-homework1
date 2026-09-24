import java.awt.Color;

public class DrawableCircle extends DrawableShape {

    protected double radius;

    public DrawableCircle(double x, double y, Color color, double radius) {
        super(x, y, color);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public void draw() {
        StdDraw.setPenColor(color);
        StdDraw.filledCircle(x, y, radius);
    }

    public static void main(String[] args) {

        DrawableCircle circle =
                new DrawableCircle(0.25, 0.25, Color.RED, 0.10);

        circle.draw();
        System.out.println(circle.area());

        DrawableShape shape =
                new DrawableCircle(0.75, 0.6, Color.BLUE, 0.20);

        shape.draw();
        System.out.println(shape.area());
    }
}