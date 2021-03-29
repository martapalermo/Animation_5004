package cs5004.animator;

public class Rectangle extends AbstractShape {
  public Rectangle(double x, double y, int appearTime, int disappearTime, double width, double height, double red, double blue, double green) throws IllegalArgumentException {
    super(x, y, appearTime, disappearTime, width, height, red, blue, green);
  }
}
