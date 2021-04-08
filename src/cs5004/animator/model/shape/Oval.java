package cs5004.animator.model.shape;

/**
 * This is the Oval class. It represents an oval shape. This class extends AbstractShape.
 */
// for the oval, there are 2 radii: long axis will be height/2 and short axis will be width/2
public class Oval extends AbstractShape {
  private double xRadius;
  private double yRadius;

  /**
   * Oval shape constructor for when initial values are known.
   *
   * @param x x-value of the oval for Point reference, double
   * @param y y-value of the oval for Point reference, double
   * @param appearTime appearTime of the oval for Time appearance, int
   * @param disappearTime disappearingTime of the oval for Time appearance, int
   * @param width width of the oval for Dimension size, double
   * @param height height of the oval for Dimension size, double
   * @param red red pigment, int
   * @param green green pigment, int
   * @param blue blue pigment, int
   * @throws IllegalArgumentException thrown if appearance time is before 0, if appearance time is
   *      after disappearance time, if width or height are <= 0, if red, green and/or blue values
   *      are greater than 255 or less than 0.
   */
  public Oval(
      double x, double y, int appearTime, int disappearTime, double width, double height,
      int red, int green, int blue) throws IllegalArgumentException {
    super(x, y, appearTime, disappearTime, width, height, red, green, blue);

    this.xRadius = this.getWidth() / 2;
    this.yRadius = this.getHeight() / 2;
  }

  /**
   * Oval constructor for when only the name is known.
   * @param name
   */
  public Oval(String name) {
    super(name);
  }

  /**
   * toString method with all features of the oval shape.
   * @return toString for oval shape
   */
  @Override
  public String toString() {
    return "Name: " + this.getName() + "\n"
        + "Type: oval\n" + "Center: (" + this.getX() + ","
        + this.getY() + "), " + "X radius: " + this.xRadius + ", " + "Y radius: " + yRadius + ", "
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
