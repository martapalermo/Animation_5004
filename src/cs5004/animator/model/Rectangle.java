package cs5004.animator.model;

/**
 * This is the Rectangle class. It represents an rectangle shape. The fields and attributes are
 * extended form AbstractShape abstract class.
 */
public class Rectangle extends AbstractShape {

  /**
   * Rectangle shape constructor.
   *
   * @param x x-value of the rectangle for Point reference, double
   * @param y y-value of the rectangle for Point reference, double
   * @param appearTime appearTime of the rectangle for Time appearance, int
   * @param disappearTime disappearingTime of the rectangle for Time appearance, int
   * @param width width of the rectangle for Dimension size, double
   * @param height height of the rectangle for Dimension size, double
   * @param red red pigment, double
   * @param green green pigment, double
   * @param blue blue pigment, double
   * @throws IllegalArgumentException thrown if appearance time is before 0, if appearance time is
   * after disappearance time, if width or height are <= 0, if red, green and/or blue values are
   * greater than 255 or less than 0.
   */
  public Rectangle(double x, double y, int appearTime, int disappearTime, double width,
                   double height, double red, double green, double blue)
      throws IllegalArgumentException {
    super(x, y, appearTime, disappearTime, width, height, red, green, blue);
  }

  // Format like in the spec
  /**
   * toString method with all features of the rectangle shape.
   * @return toString for rectangle shape
   */
  @Override
  public String toString() {
    return "Name: " + this.getName() + "\n"
        + "Type: rectangle\n" + "Min corner: (" + this.getX() + ","
        + this.getY() + "), " + "Width: " + getWidth() + ", " + "Height: " + getHeight() + ", "
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
    return new Rectangle(this.getX(), this.getY(), this.getAppearTime(), this.getDisappearTime(),
        this.getWidth(), this.getHeight(), this.getRed(), this.getGreen(), this.getBlue());
  }
}