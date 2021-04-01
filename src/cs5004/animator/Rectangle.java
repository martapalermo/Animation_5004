package cs5004.animator;

public class Rectangle extends AbstractShape {
  public Rectangle(double x, double y, int appearTime, int disappearTime, double width,
                   double height, double red, double blue, double green)
      throws IllegalArgumentException {
    super(x, y, appearTime, disappearTime, width, height, red, blue, green);
  }

  // Format like in the spec
  @Override
  public String toString() {
    return "Name: " + this.getName() + "\n"
        + "Type: rectangle\n" + "Min corner: (" + this.getX() + ","
        + this.getY() + "), " + "Width: " + getWidth() + ", " + "Height: " + getHeight() + ", "
        + "Color: (" + this.getRed() + "," + this.getGreen() + "," + this.getBlue() + ")\n"
        + "Appears at t=" + getAppearTime() + "\n"
        + "Disappears at t=" + getDisappearTime() + "\n";
  }
}
