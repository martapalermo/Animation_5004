package cs5004.animator.model;

/**
 * This is the Oval class. It represents an oval shape. This class extends AbstractShape.
 */
// for the oval, there are 2 radii: long axis will be height/2 and short axis will be width/2
public class Oval extends AbstractShape {

  /**
   * Oval shape constructor.
   *
   * @param x x-value of the oval for Point reference, double
   * @param y y-value of the oval for Point reference, double
   * @param appearTime appearTime of the oval for Time appearance, int
   * @param disappearTime disappearingTime of the oval for Time appearance, int
   * @param width width of the oval for Dimension size, double
   * @param height height of the oval for Dimension size, double
   * @param red red pigment, double
   * @param green green pigment, double
   * @param blue blue pigment, double
   * @throws IllegalArgumentException thrown if appearance time is before 0, if appearance time is
   * after disappearance time, if width or height are <= 0, if red, green and/or blue values are
   * greater than 255 or less than 0.
   */
  public Oval(
      double x, double y, int appearTime, int disappearTime, double width, double height,
      double red, double green, double blue) throws IllegalArgumentException {
    super(x, y, appearTime, disappearTime, width, height, red, green, blue);
  }

  // Format like in the spec

  /**
   * toString method with all features of the oval shape.
   * @return toString for oval shape
   */
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

  /**
   * Copies the shape.
   * @return copy of the shape
   */
  @Override
  public Shape copy() {
    Shape copy = new Oval(this.getX(), this.getY(), this.getAppearTime(), this.getDisappearTime(),
        this.getWidth(), this.getHeight(), this.getRed(), this.getGreen(), this.getBlue());
    copy.setName(this.name);
    return copy;
  }
}
