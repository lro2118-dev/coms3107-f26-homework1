import java.awt.Color;

public abstract class DrawableShape {

    protected double x;
    protected double y;
    protected Color color;

    public DrawableShape(double x, double y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Color getColor() {
        return color;
    }

    public abstract double area();

    public abstract void draw();
}