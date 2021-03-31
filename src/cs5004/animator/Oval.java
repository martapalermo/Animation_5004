package cs5004.animator;

// for the oval, there are 2 radii: long axis will be height/2 and short axis will be width/2
public class Oval extends AbstractShape {
  public Oval(double x, double y, int appearTime, int disappearTime, double width, double height,
              double red, double blue, double green) throws IllegalArgumentException {
    super(x, y, appearTime, disappearTime, width, height, red, blue, green);
  }

  // Format like in the spec
  @Override
  public String toString() {
    double xRadius = this.getWidth() / 2;
    double yRadius = this.getHeight() / 2;
    String str = "Name: " + this.getName()
        + "Type: oval\n" + "Center: (" + this.getX() + ","
        + this.getY() + "), " + "X radius: " + xRadius + ", " +
  }
}
