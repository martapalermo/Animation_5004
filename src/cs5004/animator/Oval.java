package cs5004.animator;

public class Oval extends AbstractShape {
  public Oval(double x, double y, int appearTime, int disappearTime, double width, double height, double red, double blue, double green) throws IllegalArgumentException {
    super(x, y, appearTime, disappearTime, width, height, red, blue, green);
  }

  // Format like in the spec
  @Override
  public String toString() {
    return super.toString();
  }
}
