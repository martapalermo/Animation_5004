package cs5004.animator;

// for the oval, there are 2 radii: long axis will be height/2 and short axis will be width/2
public class Oval extends AbstractShape {
  public Oval(double x, double y, int appearTime, int disappearTime, double width, double height,
              double red, double green, double blue) throws IllegalArgumentException {
    super(x, y, appearTime, disappearTime, width, height, red, green, blue);
  }

  // Format like in the spec
  @Override
  public String toString() {
    double xRadius = this.getWidth() / 2;
    double yRadius = this.getHeight() / 2;
    return "Name: " + this.getName() + "\n"
        + "Type: oval\n" + "Center: (" + this.getX() + ","
        + this.getY() + "), " + "X radius: " + xRadius + ", " + "Y radius: " + yRadius + ", "
        + "Color: (" + this.getRed() + "," + this.getGreen() + "," + this.getBlue() + ")\n"
        + "Appears at t=" + getAppearTime() + "\n"
        + "Disappears at t=" + getDisappearTime() + "\n";
  }

  @Override
  public Shape copy() {
    return new Oval(this.getX(), this.getY(), this.appearTime, this.disappearTime, this.width,
            this.height, this.red, this.blue, this.green);
  }
}
